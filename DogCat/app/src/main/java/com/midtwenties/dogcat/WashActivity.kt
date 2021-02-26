package com.midtwenties.dogcat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_wash.*

class WashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wash)

        backButton.setOnClickListener{
            onBackPressed()
        }
        wash.setOnClickListener{
            Toast.makeText(this,"선택", Toast.LENGTH_SHORT).show()
            Glide.with(this).load(R.raw.wash).into(washing)
        }
    }
}