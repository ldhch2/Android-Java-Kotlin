package com.midtwenties.dogcat

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
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

        titleView1.visibility= View.INVISIBLE
        titleImage1.visibility= View.INVISIBLE
        titleImage2.visibility= View.INVISIBLE

        val animation1 = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        Handler(Looper.getMainLooper()).postDelayed({
            titleView1.visibility = View.VISIBLE
            titleView1.startAnimation(animation1)
        }, 1000)

        Handler(Looper.getMainLooper()).postDelayed({
            //overridePendingTransition(R.anim.fade_out, R.anim.fade_in)
            titleImage1.visibility= View.VISIBLE
        }, 2500)

        Handler(Looper.getMainLooper()).postDelayed({
            titleImage2.visibility= View.VISIBLE
            //titleImage2.startAnimation(animation1)
        }, 3000)

        try {
                if (loadFromInnerStorage(filename).equals("true")) {
                    Handler(Looper.getMainLooper()).postDelayed({
                        startActivity(Intent(this, YardActivity::class.java))
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        finish()
                    },5000)
                } else {
                    Handler(Looper.getMainLooper()).postDelayed({
                        startActivity(Intent(this, InitPet::class.java))
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        finish()
                    }, 5000)
                }
        }
        catch (e: FileNotFoundException){
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, InitPet::class.java))
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
            }, 5000)
        }

    }

    fun loadFromInnerStorage(filename: String):String{
        val fileInputStream = openFileInput(filename)
        if(fileInputStream==null) return "false"
        else return fileInputStream.reader().readText()
    }
}