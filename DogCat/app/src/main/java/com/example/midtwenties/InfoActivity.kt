package com.example.midtwenties

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.ImageSwitcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        var button1=0;
        var button2=0;
        var info=" "

        femaleButton.setOnClickListener{
            Toast.makeText(applicationContext,"암컷을 입양합니다.",Toast.LENGTH_SHORT).show()
            button2=1;
        }
        maleButton.setOnClickListener{
            Toast.makeText(applicationContext,"수컷을 입양합니다.",Toast.LENGTH_SHORT).show()
            button2=2;
        }
        babyButton.setOnClickListener{
            Toast.makeText(applicationContext,"1개월-24개월",Toast.LENGTH_SHORT).show()
            petImage.setImageResource(R.drawable.baby_dog)
            button1=1
        }
        adultButton.setOnClickListener{
            Toast.makeText(applicationContext,"25개월-84개월",Toast.LENGTH_SHORT).show()
            petImage.setImageResource(R.drawable.adult_dog)
            button1=2
        }
        oldButton.setOnClickListener{
            Toast.makeText(applicationContext,"85개월-",Toast.LENGTH_SHORT).show()
            petImage.setImageResource(R.drawable.old_dog)
            button1=3
        }

        saveInfo.setOnClickListener {
            if(button1==0 || button2==0 || TextUtils.isEmpty(petName.text.toString())){
                Toast.makeText(applicationContext,"선택해주세요",Toast.LENGTH_SHORT).show()
            }
            else {
                info +=petName.text.toString();
                if(button2==1) info+=" 여자"
                else info += " 남자"

                if (button1==1) info += " 1"
                else if (button1==2) info+= " 25"
                else info += " 85"

                saveToInnerStorage(info,"pet.txt")
                Toast.makeText(applicationContext, "저장되었습니다", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, TermsOfService::class.java))
            }
        }

    }

    fun saveToInnerStorage(text: String, filename: String){
        val fileOutputStream = openFileOutput(filename, Context.MODE_APPEND)
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }

}