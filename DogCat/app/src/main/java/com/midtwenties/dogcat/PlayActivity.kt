package com.midtwenties.dogcat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_play.*

class PlayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

       playingPet.setOnClickListener{
            Toast.makeText(this,"선택",Toast.LENGTH_SHORT).show()
            Glide.with(this).load(R.raw.tailmoving).into(playingPet)
        }
        backButton.setOnClickListener{
            onBackPressed()
        }

    }



}