package com.midtwenties.dogcat

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.app.Service
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.android.synthetic.main.activity_yard.*

class YardActivity : AppCompatActivity() {

    val preference by lazy { getSharedPreferences("setting_data", Context.MODE_PRIVATE) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yard)

        val today=SimpleDateFormat("yyyy-MM-dd",Locale.KOREA).format(Date())

        var countDate = preference.getInt("count",0)
        val date = preference.getString("date",today).toString()

        if(date != today || countDate==0) {
            countDate+=1
            preference.edit().putString("date",date).apply()
            preference.edit().putInt("count",countDate).apply()

            val intent = Intent(this, AttendancePopup::class.java)
            intent.putExtra("countDate", countDate)
            startActivityForResult(intent, 1)
        }

        idcardList.setOnClickListener{
            startActivity(Intent(this, IDListActivity::class.java))
        }
        temporaryMain.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        when {
            preference.getBoolean("screen", false) -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(Intent(applicationContext, ScreenService::class.java))
                } else {
                    startService(Intent(applicationContext, ScreenService::class.java))
                }
            }
            else -> stopService(Intent(applicationContext, ScreenService::class.java))
        }
    }


    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 1) {
            if(resultCode == RESULT_OK) {
                var result = data?.getStringExtra("result")
            }
        }
    }
    override fun onBackPressed() {
        val alBuilder = AlertDialog.Builder(this)
        alBuilder.setMessage("Are you sure you want to exit?")
        alBuilder.setNegativeButton("okay") { dialogInterface, which -> finish() }
        alBuilder.setPositiveButton("cancel", DialogInterface.OnClickListener { dialogInterface, i -> return@OnClickListener })
        alBuilder.setTitle("Exit")
        alBuilder.show()
    }

    fun saveToInnerStorage(text: String, filename: String){
        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }

    fun loadFromInnerStorage(filename: String):String{
        val fileInputStream=openFileInput(filename)
        return fileInputStream.reader().readText()
    }

}

