package com.example.midtwenties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_wash.*

class Wash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wash)


        wash.setOnClickListener{
            Toast.makeText(this,"선택", Toast.LENGTH_SHORT).show()
            Glide.with(this).load(R.raw.wash).into(imageView7)
        }
    }
}