package com.example.midtwenties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_my_store.*

class MyStore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_store)

        back.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
        toyButton.setOnClickListener {
            startActivity(Intent(this, ToyStore::class.java))
        }
        houseButton.setOnClickListener {
            startActivity(Intent(this, HouseStore::class.java))
        }
        bowlButton.setOnClickListener {
            startActivity(Intent(this, BowlStore::class.java))
        }
        feedButton.setOnClickListener {
            startActivity(Intent(this, FeedStore::class.java))
        }
        nutritionButton.setOnClickListener {

        }
        padButton.setOnClickListener {

        }
    }



}