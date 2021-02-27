package com.midtwenties.dogcat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hospital.*

class HospitalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital)

        backButton.setOnClickListener {
            onBackPressed()
        }
        goButton1.setOnClickListener {
            startActivity(Intent(this, HospitalTreatment::class.java))
        }
        goButton2.setOnClickListener {
            val intent = Intent(this, HospitalRoom::class.java)
            intent.putExtra("room", "1".toInt())
            startActivity(intent)
        }
        goButton3.setOnClickListener {
            val intent = Intent(this, HospitalRoom::class.java)
            intent.putExtra("room", "2".toInt())
            startActivity(intent)
        }
    }
}