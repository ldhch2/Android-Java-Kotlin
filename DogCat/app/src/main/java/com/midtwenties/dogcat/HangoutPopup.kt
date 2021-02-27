package com.midtwenties.dogcat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_hangout_popup.*

class HangoutPopup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hangout_popup)

        hospitalButton.setOnClickListener{
            startActivity(Intent(this, HospitalActivity::class.java))
            finish()
        }
        walkButton.setOnClickListener{
            //startActivity(Intent(this, walkActivity::class.java))
        }
    }
}