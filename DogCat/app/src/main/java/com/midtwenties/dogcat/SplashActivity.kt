package com.midtwenties.dogcat

import android.content.Context
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
    val init = "init"

    val prefernce by lazy { getSharedPreferences("setting_data", Context.MODE_PRIVATE) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        titleView1.visibility= View.INVISIBLE
        titleView2.visibility=View.INVISIBLE
        titleImage1.visibility= View.INVISIBLE
        titleImage2.visibility= View.INVISIBLE

        //val animation1 = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        Handler(Looper.getMainLooper()).postDelayed({
            titleView1.visibility = View.VISIBLE
            //titleView1.startAnimation(animation1)
            //overridePendingTransition(R.anim.fade_out, R.anim.fade_in)

        }, 1000)

        Handler(Looper.getMainLooper()).postDelayed({
            titleImage1.visibility= View.VISIBLE
        }, 1100)


        Handler(Looper.getMainLooper()).postDelayed({
            titleView2.visibility=View.VISIBLE
            //titleImage2.visibility= View.VISIBLE
            //titleImage2.startAnimation(animation1)
        }, 1500)

        Handler(Looper.getMainLooper()).postDelayed({
            titleImage2.visibility= View.VISIBLE
        }, 1600)

        try {
                if (prefernce.getBoolean(init,false)) {
                    Handler(Looper.getMainLooper()).postDelayed({
                        startActivity(Intent(this, YardActivity::class.java))
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        finish()
                    },3000)
                } else {
                    Handler(Looper.getMainLooper()).postDelayed({
                        startActivity(Intent(this, InitPet::class.java))
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        finish()
                    }, 3000)
                }
        }
        catch (e: FileNotFoundException){
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, InitPet::class.java))
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
            }, 3000)
        }

    }

    fun loadFromInnerStorage(filename: String):String{
        val fileInputStream = openFileInput(filename)
        if(fileInputStream==null) return "false"
        else return fileInputStream.reader().readText()
    }
}