package org.techtown.hh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var isOpen = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open)
        val fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close)

        fabMain.setOnClickListener{
            if(isOpen){
                fab_sub1.startAnimation(fabClose)
                fab_sub2.startAnimation(fabClose)
                fab_sub3.startAnimation(fabClose)
                fab_sub4.startAnimation(fabClose)


                isOpen=false
            }
            else{
                fab_sub1.startAnimation(fabOpen)
                fab_sub2.startAnimation(fabOpen)
                fab_sub3.startAnimation(fabOpen)
                fab_sub4.startAnimation(fabOpen)


                fab_sub1.isClickable
                fab_sub2.isClickable
                fab_sub3.isClickable
                fab_sub4.isClickable

                isOpen = true
            }

            fab_sub1.setOnClickListener{
                Toast.makeText(this,"click",Toast.LENGTH_LONG).show()
            }
        }



    }
}