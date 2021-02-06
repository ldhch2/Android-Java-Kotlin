package com.example.midtwenties

import StateAdapter
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    var isOpen = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var stateList = arrayListOf<State>(
                State("hungry", "full", 40),
                State("dirty", "clean", 15),
                State("bored", "excited", 85),
                State("sleepy", "awake", 25),
                State("sad", "happy", 60),
                State("sick", "healthy", 0),
                State("anxious", "relaxed", 5)
        )

        val stateAdapter=StateAdapter(this, stateList)
        stateRecyclerView.adapter = stateAdapter

        val lm = LinearLayoutManager(this)
        stateRecyclerView.layoutManager = lm
        stateRecyclerView.setHasFixedSize(true)

        val fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open)
        val fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close)


        fabMain.setOnClickListener{
            if(isOpen){
                fab_sub1.startAnimation(fabClose)
                fab_sub2.startAnimation(fabClose)
                fab_sub3.startAnimation(fabClose)
                showState.startAnimation(fabClose)


                isOpen=false
            }
            else{
                fab_sub1.startAnimation(fabOpen)
                fab_sub2.startAnimation(fabOpen)
                fab_sub3.startAnimation(fabOpen)
                showState.startAnimation(fabOpen)


                fab_sub1.isClickable
                fab_sub2.isClickable
                fab_sub3.isClickable
                showState.isClickable

                isOpen = true
            }

            fab_sub1.setOnClickListener{
                Toast.makeText(this,"click",Toast.LENGTH_LONG).show()
            }
            showState.setOnClickListener() {
                drawerState.openDrawer(GravityCompat.START)
            }
        }

    }
}