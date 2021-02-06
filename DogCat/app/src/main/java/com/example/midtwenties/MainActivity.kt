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

        val filename=loadFromInnerStorage("pet.txt")
        val temp=filename.split('\n')
        val pet=PetClass(loadFromInnerStorage(temp[0]))

        var stateList = arrayListOf<State>(
                State("hungry", "full", pet.state.full),
                State("dirty", "clean", pet.state.clean),
                State("bored", "excited", pet.state.excited),
                State("sleepy", "awake", pet.state.awake),
                State("sad", "happy", pet.state.happy),
                State("sick", "healthy", pet.state.healthy),
                State("anxious", "relaxed", pet.state.relaxed)
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

    fun loadFromInnerStorage(filename: String):String{
        val fileInputStream=openFileInput(filename)
        return fileInputStream.reader().readText()
    }

}