package com.example.midtwenties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_store.*

class FeedStore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed_store)

        back.setOnClickListener{
            startActivity(Intent(this,MyStore::class.java))
        }
    }
}