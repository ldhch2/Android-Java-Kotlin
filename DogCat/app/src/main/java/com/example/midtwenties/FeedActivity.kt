package com.example.midtwenties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_feed.*
import kotlinx.android.synthetic.main.activity_main.*

class FeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        returnButton.setOnClickListener(){
            startActivity(Intent(this,MainActivity::class.java))
        }

        feedButton.setOnClickListener(){
            full_bowl.isVisible=true
        }
    }
}