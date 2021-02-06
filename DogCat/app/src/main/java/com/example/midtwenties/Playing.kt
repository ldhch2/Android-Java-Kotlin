package com.example.midtwenties

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_playing.*
import java.nio.file.Files.list

class Playing : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playing)

       playingpet.setOnClickListener{
            Toast.makeText(this,"선택",Toast.LENGTH_SHORT).show()
            Glide.with(this).load(R.raw.tailmoving).into(playingpet)

        }

    }



}