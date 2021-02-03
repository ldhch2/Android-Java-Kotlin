package com.example.midtwenties

import StateAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_pet_state.*

class PetState : AppCompatActivity() {

    var stateList = arrayListOf<State>(
        State("hungry", "full", 40),
        State("dirty", "clean", 15),
        State("bored", "excited", 85),
        State("sleepy", "awake", 25),
        State("sad", "happy", 60),
        State("sick", "healthy", 0),
        State("anxious", "relaxed", 5)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val stateAdapter=StateAdapter(this, stateList)
        stateRecyclerView.adapter = stateAdapter

        val lm = LinearLayoutManager(this)
        stateRecyclerView.layoutManager = lm
        stateRecyclerView.setHasFixedSize(true)
    }

}