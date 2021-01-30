package com.example.midtwenties

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils

class SplashActivity : AppCompatActivity() {

    var first=false;

    val filename="init.txt"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if(loadFromInnerStorage(filename).equals("true")){
            startActivity(Intent(this, RealMainActivity::class.java))
        }
        else{
            startActivity(Intent(this, init_pet::class.java))
        }

        Handler(Looper.getMainLooper()).postDelayed({
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }, 2500)


    }

    fun loadFromInnerStorage(filename: String):String{
        val fileInputStream=openFileInput(filename)
        return fileInputStream.reader().readText()
    }

}