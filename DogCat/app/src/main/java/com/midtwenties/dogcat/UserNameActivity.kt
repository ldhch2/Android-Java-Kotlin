package com.midtwenties.dogcat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user_name.*

class UserNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_name)
        var name:String=""

        val right = AnimationUtils.loadAnimation(this, R.anim.pull_in_right)
        val left = AnimationUtils.loadAnimation(this, R.anim.pull_in_left)
        val blink=AnimationUtils.loadAnimation(this,R.anim.blink)

        hiCat.visibility= View.INVISIBLE
        hiDog.visibility= View.INVISIBLE
        hi.visibility= View.INVISIBLE
        nice.visibility= View.INVISIBLE
        hiButton.visibility= View.INVISIBLE
              click.visibility= View.INVISIBLE

        Handler(Looper.getMainLooper()).postDelayed({
            hiCat.visibility = View.VISIBLE
            hiCat.startAnimation(right)
        }, 0)

        Handler(Looper.getMainLooper()).postDelayed({
            hi.visibility= View.VISIBLE
        }, 300)


        Handler(Looper.getMainLooper()).postDelayed({
            hiDog.visibility= View.VISIBLE
            hiDog.startAnimation(left)
        }, 800)

        Handler(Looper.getMainLooper()).postDelayed({
            nice.visibility= View.VISIBLE
        }, 1100)

        Handler(Looper.getMainLooper()).postDelayed({
            val dialog=CustomDialog(this)
            dialog.userDig()

            dialog.setOnClickedListener(object: CustomDialog.CustomDialogListener{
                override fun onClicked(content:String){
                    name=content
                    hiButton.visibility = View.VISIBLE
                    click.visibility = View.VISIBLE
                    click.startAnimation(blink)
                }
            })
        }, 2500)


        hiButton.setOnClickListener(){
            startActivity(Intent(this, InitPet::class.java))
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }


    }
}