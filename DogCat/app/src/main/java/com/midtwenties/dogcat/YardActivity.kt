package com.midtwenties.dogcat

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_yard.*
import java.text.SimpleDateFormat
import java.util.*

class YardActivity : AppCompatActivity() {

    val preference by lazy { getSharedPreferences("setting_data", Context.MODE_PRIVATE) }
    var isOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yard)

        supportFragmentManager.beginTransaction()
            .replace(R.id.coin, CoinView())
            .commit()

        val today = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date())

        var countDate = preference.getInt("count", 0)
        val date = preference.getString("date", today).toString()

        if (countDate == 6) countDate = 1

        if (date != today || countDate == 0) {
            countDate += 1
            preference.edit().putString("date", date).apply()
            preference.edit().putInt("count", countDate).apply()

            val intent = Intent(this, AttendancePopup::class.java)
            intent.putExtra("countDate", countDate)
            startActivityForResult(intent, 1)
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

        val fabOpen = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        val fabClose = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        pet01.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

        fabMain.setOnClickListener {
            if (isOpen) {
                mainSetting.startAnimation(fabClose)
                idcardList.startAnimation(fabClose)
                itemButton.startAnimation(fabClose)
                storeButton.startAnimation(fabClose)

                isOpen = false

            } else {
                mainSetting.startAnimation(fabOpen)
                idcardList.startAnimation(fabOpen)
                itemButton.startAnimation(fabOpen)
                storeButton.startAnimation(fabOpen)

                mainSetting.isClickable
                idcardList.isClickable
                itemButton.isClickable
                storeButton.isClickable

                isOpen = true
            }

            mainSetting.setOnClickListener {
                startActivity(Intent(this, MainSetting::class.java))
            }
            idcardList.setOnClickListener {
                startActivity(Intent(this, IDListActivity::class.java))
            }
            itemButton.setOnClickListener{
                startActivity(Intent(this,ItemList::class.java))
            }
            storeButton.setOnClickListener {
                startActivity(Intent(this, StoreItem::class.java))
            }
        }
    }
    override fun onBackPressed() {
        val alBuilder = AlertDialog.Builder(this)
/*        dialog = builder.create()

        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(WHAT);
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(WHAT);

 */
        alBuilder.setMessage("즐거웠어! 다음에 또 올거지?")
        alBuilder.setNegativeButton("금방 또 올게!" ) { dialogInterface, which -> finish() }
        alBuilder.setPositiveButton("좀 더 있을까?", DialogInterface.OnClickListener { dialogInterface, i -> return@OnClickListener })
        alBuilder.setTitle("안녕!")
        alBuilder.show()

        //val textView = alBuilder.findViewById(android.R.id.message)
    }


        fun saveToInnerStorage(text: String, filename: String) {
            val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)
            fileOutputStream.write(text.toByteArray())
            fileOutputStream.close()
        }

        fun loadFromInnerStorage(filename: String): String {
            val fileInputStream = openFileInput(filename)
            return fileInputStream.reader().readText()
        }

}

