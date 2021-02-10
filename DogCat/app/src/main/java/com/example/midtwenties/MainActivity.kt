package com.example.midtwenties

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
<<<<<<< Updated upstream
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_pet_state.*
=======
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.activity_my_store.*
import kotlinx.android.synthetic.main.state.view.*
>>>>>>> Stashed changes

class MainActivity : AppCompatActivity() {

    var isOpen = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

<<<<<<< Updated upstream
=======
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

>>>>>>> Stashed changes
        val fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open)
        val fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close)

        walkwalk.setOnClickListener{

        }
        feedfeed.setOnClickListener{
            startActivity(Intent(this,FeedActivity::class.java))
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
        }
<<<<<<< Updated upstream

        showState.setOnClickListener() {
            startActivity(Intent(this, PetState::class.java))
        }
=======
>>>>>>> Stashed changes
    }
}