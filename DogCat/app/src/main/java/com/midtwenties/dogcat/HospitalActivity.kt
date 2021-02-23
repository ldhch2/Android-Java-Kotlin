package com.midtwenties.dogcat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.midtwenties.HospitalTreatment
import kotlinx.android.synthetic.main.activity_hospital.*

class HospitalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital)

        back.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        room1.setOnClickListener {
            startActivity(Intent(this, HospitalTreatment::class.java))
        }

    }
}