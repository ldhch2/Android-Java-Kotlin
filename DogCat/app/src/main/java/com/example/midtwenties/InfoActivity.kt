package com.example.midtwenties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageSwitcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        femaleButton.setOnClickListener{
            Toast.makeText(applicationContext,"암컷을 입양합니다.",Toast.LENGTH_SHORT).show()
        }

        maleButton.setOnClickListener{
            Toast.makeText(applicationContext,"수컷을 입양합니다.",Toast.LENGTH_SHORT).show()
        }

        babyButton.setOnClickListener{
            Toast.makeText(applicationContext,"1개월-24개월",Toast.LENGTH_SHORT).show()
            petImage.setImageResource(R.drawable.baby_dog)
        }

        adultButton.setOnClickListener{
            Toast.makeText(applicationContext,"25개월-84개월",Toast.LENGTH_SHORT).show()
            petImage.setImageResource(R.drawable.adult_dog)
        }

        oldButton.setOnClickListener{
            Toast.makeText(applicationContext,"85개월-",Toast.LENGTH_SHORT).show()
            petImage.setImageResource(R.drawable.old_dog)
        }
    }
}