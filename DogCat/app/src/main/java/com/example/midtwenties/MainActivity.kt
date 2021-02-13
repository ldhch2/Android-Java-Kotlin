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

        val next=Intent(this,StoreItem::class.java)


        var stateList = arrayListOf<State>(
            State("hungry", "full", 40),
            State("dirty", "clean", 15),
            State("bored", "excited", 85),
            State("sleepy", "awake", 25),
            State("sad", "happy", 60),
            State("sick", "healthy", 0),
            State("anxious", "relaxed", 5)
        )

        /* 여기가 안돼
>>>>>>> e6be8161263d114874afa7786072c63111c8e633
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
        */

        val stateAdapter=StateAdapter(this, stateList)
        stateRecyclerView.adapter = stateAdapter

        val lm = LinearLayoutManager(this)
        stateRecyclerView.layoutManager = lm
        stateRecyclerView.setHasFixedSize(true)

        val fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open)
        val fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close)

        walkwalk.setOnClickListener{

        }
        feedfeed.setOnClickListener{
            startActivity(Intent(this, FeedActivity::class.java))
        }
        washwash.setOnClickListener{
            // startActivity(Intent(this,WashActivity::class.java))
        }

        fabMain.setOnClickListener{
            if(isOpen){
                fab_sub1.startAnimation(fabClose)
                fab_sub2.startAnimation(fabClose)
                fab_sub3.startAnimation(fabClose)
                showState.startAnimation(fabClose)
                registerButton.startAnimation(fabClose)

                isOpen=false
            }
            else{
                fab_sub1.startAnimation(fabOpen)
                fab_sub2.startAnimation(fabOpen)
                fab_sub3.startAnimation(fabOpen)
                showState.startAnimation(fabOpen)
                registerButton.startAnimation(fabOpen)

                fab_sub1.isClickable
                fab_sub2.isClickable
                fab_sub3.isClickable
                showState.isClickable
                registerButton.isClickable

                isOpen = true
            }

            fab_sub1.setOnClickListener{
                Toast.makeText(this,"click",Toast.LENGTH_LONG).show()
                startActivity(next)
            }

            showState.setOnClickListener() {
                drawerState.openDrawer(GravityCompat.START)
            }
            registerButton.setOnClickListener(){
                startActivity(Intent(this,RegisterActivity::class.java))
            }
        }

    }

    fun loadFromInnerStorage(filename: String):String{
        val fileInputStream=openFileInput(filename)
        return fileInputStream.reader().readText()
    }

}