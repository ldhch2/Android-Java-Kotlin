package com.example.midtwenties

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class YardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yard)
        var date = ""
        val today=SimpleDateFormat("yyyy-MM-dd",Locale.KOREA).format(Date())
        var countDate = 0
        var flag = false
        try {
            val readDate = loadFromInnerStorage("attendancefile.txt")
            var arr = readDate.split("/")
            date = arr[0].toString()
            countDate = arr[1].toInt() + 1
        } catch(e: Exception) {
            date = today
            countDate = 1
            flag = true
        }
        if(countDate == 6) countDate = 1
        if(!date.equals(today) || flag == true) {
            val writedate = date + "/" + countDate
            saveToInnerStorage(writedate,"attendancefile.txt")

            var intent = Intent(this, AttendancePopup::class.java)
            intent.putExtra("countDate", countDate)

            startActivityForResult(intent, 1)
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

