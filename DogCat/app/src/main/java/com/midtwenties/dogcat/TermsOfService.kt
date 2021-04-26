package com.midtwenties.dogcat

import android.content.Context
import android.content.Intent
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_terms_of_service.*

class TermsOfService : AppCompatActivity() {

    val init = "init"
    val screen = "screen"
    val nowpet="nowpet"

    val prefernce by lazy { getSharedPreferences("setting_data",Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_of_service)

        var get = intent.getStringExtra("info").toString()
        val next = Intent(this,YardActivity::class.java)

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getRealSize(size)
        val widthScreen = size.x
        val heightScreen = size.y

        prefernce.edit().putInt("widthScreen",widthScreen)
        prefernce.edit().putInt("heightScreen",heightScreen)

        yesButton.setOnClickListener {
            get += " " + intent.getStringExtra("imageURI").toString()

            val name = get.split(" ")
            saveToInnerStorage(String.format("%s.txt", name[0]),"pet.txt")
            saveToInnerStorage(get,String.format("%s.txt", name[0]))

            prefernce.edit().putBoolean(screen,true).apply()
            prefernce.edit().putBoolean(init,true).apply()
            prefernce.edit().putString(nowpet, String.format("%s.txt",name[0])).apply()


            startActivity(next)
            finish()
        }

        noButton.setOnClickListener {
            get += " " + intent.getStringExtra("imageURI").toString()

            val name = get.split(" ")
            saveToInnerStorage(String.format("%s.txt", name[0]),"pet.txt")
            saveToInnerStorage(get,String.format("%s.txt", name[0]))

            prefernce.edit().putBoolean(screen,false).apply()
            prefernce.edit().putBoolean(init,true).apply()
            prefernce.edit().putString(nowpet, String.format("%s.txt",name[0])).apply()

            startActivity(next)
            finish()
        }
    }

    override fun onBackPressed() {
    }

    fun saveToInnerStorage(text: String, filename: String){
        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }
}