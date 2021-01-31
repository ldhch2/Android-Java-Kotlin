package com.example.midtwenties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_terms_of_service.*

class TermsOfService : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_of_service)

        checkBox1.isChecked=false;
        checkBox2.isChecked=false;

        checkBox1.setOnClickListener{
            checkBox2.isChecked=false
        }

        checkBox2.setOnClickListener{
            checkBox1.isChecked=false
        }

        nextButton.setOnClickListener {
            if(checkBox1.isChecked || checkBox2.isChecked) {
                startActivity(Intent(this, YardActivity::class.java))
            }
            else Toast.makeText(applicationContext,"선택해주세요.",Toast.LENGTH_SHORT).show()
        }
    }
}