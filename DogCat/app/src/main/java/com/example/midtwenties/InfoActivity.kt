package com.example.midtwenties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        var button=0;

        femaleButton.setOnClickListener{
            Toast.makeText(applicationContext,"암컷을 입양합니다.",Toast.LENGTH_SHORT).show()
        }

        maleButton.setOnClickListener{
            Toast.makeText(applicationContext,"수컷을 입양합니다.",Toast.LENGTH_SHORT).show()
        }

        babyButton.setOnClickListener{
            Toast.makeText(applicationContext,"1개월-24개월",Toast.LENGTH_SHORT).show()
            petImage.setImageResource(R.drawable.baby_dog)
            button=1
        }
        adultButton.setOnClickListener{
            Toast.makeText(applicationContext,"25개월-84개월",Toast.LENGTH_SHORT).show()
            petImage.setImageResource(R.drawable.adult_dog)
            button=2
        }
        oldButton.setOnClickListener{
            Toast.makeText(applicationContext,"85개월-",Toast.LENGTH_SHORT).show()
            petImage.setImageResource(R.drawable.old_dog)
            button=3
        }

        saveInfo.setOnClickListener {
            if(button==0){
                Toast.makeText(applicationContext,"선택해주세요",Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(applicationContext, "저장되었습니다", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, TermsOfService::class.java))
            }
        }
    }
}