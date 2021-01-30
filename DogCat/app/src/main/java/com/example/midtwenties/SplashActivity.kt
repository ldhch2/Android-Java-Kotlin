package com.example.midtwenties

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import java.io.FileNotFoundException

class SplashActivity : AppCompatActivity() {
<<<<<<< HEAD
    var checkinit = false
=======

    var first=false;

    val filename="init.txt"

>>>>>>> check

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

<<<<<<< HEAD
        Handler(Looper.getMainLooper()).postDelayed({
            if(!checkinit){
                startActivity(Intent(this, init_pet::class.java))

            }
            else {
                startActivity(Intent(this, MainActivity::class.java))
            }
=======
        try {
            if (loadFromInnerStorage(filename).equals("true")) {
                startActivity(Intent(this, RealMainActivity::class.java))

            } else {
                startActivity(Intent(this, init_pet::class.java))
            }

            Handler(Looper.getMainLooper()).postDelayed({
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
            }, 2500)
        }
        catch (e: FileNotFoundException){
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, init_pet::class.java))
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
            }, 2500)
        }

    }

    fun loadFromInnerStorage(filename: String):String{
>>>>>>> check

        val fileInputStream=openFileInput(filename)
        if(fileInputStream==null) return "false"
        else return fileInputStream.reader().readText()
    }
}