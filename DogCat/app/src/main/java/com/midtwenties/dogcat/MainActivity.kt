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
                State("배고파요", "배불러요", pet.state.full),
                State("찝찝해요", "개운해요", pet.state.clean),
                State("지루해요", "신나요", pet.state.excited),
                State("졸려요", "상쾌해요", pet.state.awake),
                State("슬퍼요", "행복해요", pet.state.happy),
                State("아파요", "건강해요", pet.state.healthy),
                State("불안해요", "편안해요", pet.state.relaxed)
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
        stateButton.setOnClickListener{
            drawerState.openDrawer(GravityCompat.START)
        }

        fabMain.setOnClickListener{
            if(isOpen){
                storeButton.startAnimation(fabClose)
                playButton.startAnimation(fabClose)
                showState.startAnimation(fabClose)
                homeButton.startAnimation(fabClose)

                isOpen=false
            }
            else{
                storeButton.startAnimation(fabOpen)
                playButton.startAnimation(fabOpen)
                showState.startAnimation(fabOpen)
                homeButton.startAnimation(fabOpen)
                storeButton.isClickable
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
            playButton.setOnClickListener {
                startActivity(Intent(this,PlayActivity::class.java))
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