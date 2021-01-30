package com.example.midtwenties

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class InfoNext: AppCompatActivity() {

    val filename="init.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        saveToInnerStorage("true",filename)

        startActivity(Intent(this, RealMainActivity::class.java))

        finish()
    }


    fun saveToInnerStorage(text: String, filename: String){
        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }

}