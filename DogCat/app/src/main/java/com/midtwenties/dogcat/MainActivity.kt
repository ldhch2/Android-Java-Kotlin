package com.midtwenties.dogcat

import StateAdapter
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    var isOpen = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filename=loadFromInnerStorage("pet.txt")
        val temp=filename.split('\n')
        val pet= PetClass(loadFromInnerStorage(temp[0]))

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

        hangout.setOnClickListener{
            startActivity(Intent(this,HangoutPopup::class.java))
        }
        feedfeed.setOnClickListener{
            startActivity(Intent(this, FeedActivity::class.java))
        }
        washwash.setOnClickListener{
            startActivity(Intent(this,WashActivity::class.java))
        }

        fabMain.setOnClickListener{
            if(isOpen){
                storeButton.startAnimation(fabClose)
                itemButton.startAnimation(fabClose)
                playButton.startAnimation(fabClose)
                showState.startAnimation(fabClose)
                homeButton.startAnimation(fabClose)

                isOpen=false
            }
            else{
                storeButton.startAnimation(fabOpen)
                itemButton.startAnimation(fabOpen)
                playButton.startAnimation(fabOpen)
                showState.startAnimation(fabOpen)
                homeButton.startAnimation(fabOpen)
                storeButton.isClickable
                itemButton.isClickable
                playButton.isClickable
                showState.isClickable
                homeButton.isClickable

                isOpen = true
            }

            homeButton.setOnClickListener(){
                onBackPressed()
            }
            showState.setOnClickListener() {
                drawerState.openDrawer(GravityCompat.START)
            }
            playButton.setOnClickListener{
               // 놀아주기로
            }
            itemButton.setOnClickListener{
                // 내 아이템함으로
            }
            storeButton.setOnClickListener{
                startActivity(Intent(this, StoreItem::class.java))
            }
        }

    }

    fun loadFromInnerStorage(filename: String):String{
        val fileInputStream=openFileInput(filename)
        return fileInputStream.reader().readText()
    }

}