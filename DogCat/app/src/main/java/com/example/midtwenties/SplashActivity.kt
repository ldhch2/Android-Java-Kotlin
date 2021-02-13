package com.example.midtwenties

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*
import java.io.FileNotFoundException

class SplashActivity : AppCompatActivity() {
    var checkinit = false

    var first=false;

    val filename="init.txt"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val animation1 = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        Handler(Looper.getMainLooper()).postDelayed({
            overridePendingTransition(R.anim.fade_out, R.anim.fade_in)
            //titleView1.startAnimation(animation1)
        }, 2000)

        //val animation2 = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        Handler(Looper.getMainLooper()).postDelayed({
            overridePendingTransition(R.anim.fade_out, R.anim.fade_in)
            //titleImage1.startAnimation(animation1)
        }, 3000)

        Handler(Looper.getMainLooper()).postDelayed({
            titleImage2.startAnimation(animation1)
        }, 4000)

        try {
            if (loadFromInnerStorage(filename).equals("True")) {
                startActivity(Intent(this, MainActivity::class.java))

            } else {
                startActivity(Intent(this, InitPet::class.java))
            }
            Handler(Looper.getMainLooper()).postDelayed({
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
            }, 11000)
        }
        catch (e: FileNotFoundException){
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, InitPet::class.java))
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
            }, 2500)
        }

    }

    fun loadFromInnerStorage(filename: String):String{
        val fileInputStream=openFileInput(filename)
        if(fileInputStream==null) return "false"
        else return fileInputStream.reader().readText()
    }
}