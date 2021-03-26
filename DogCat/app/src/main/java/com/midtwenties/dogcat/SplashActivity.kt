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

        titleView.visibility= View.INVISIBLE
        titleView1.visibility= View.INVISIBLE
        titleView2.visibility=View.INVISIBLE
        titleImage1.visibility= View.INVISIBLE
        titleImage2.visibility= View.INVISIBLE


        Handler(Looper.getMainLooper()).postDelayed({
            titleView1.visibility = View.VISIBLE
        }, 1000)

        Handler(Looper.getMainLooper()).postDelayed({
            titleImage1.visibility= View.VISIBLE
        }, 1100)

        Handler(Looper.getMainLooper()).postDelayed({
            titleView.visibility= View.VISIBLE
        }, 1400)

        Handler(Looper.getMainLooper()).postDelayed({
            titleView2.visibility=View.VISIBLE
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
                        startActivity(Intent(this, UserNameActivity::class.java))
                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                        finish()
                    }, 3000)
                }
        }
        catch (e: FileNotFoundException){
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, UserNameActivity::class.java))
                overridePendingTransition(R.anim.splash_fade_in, R.anim.splash_fade_out)
                finish()
            }, 3000)
        }

    }

    override fun onBackPressed() {
    }

    fun loadFromInnerStorage(filename: String):String{
        val fileInputStream = openFileInput(filename)
        if(fileInputStream==null) return "false"
        else return fileInputStream.reader().readText()
    }
}