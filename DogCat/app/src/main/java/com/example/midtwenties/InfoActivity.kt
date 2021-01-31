package com.example.midtwenties

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.ImageSwitcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        var button1=0;
        var button2=0;

        var anim =  AlphaAnimation(0.0f,1.0f)

        femaleButton.setOnClickListener{
            Toast.makeText(applicationContext,"암컷을 입양합니다.",Toast.LENGTH_SHORT).show()
            button2=1;
        }
        maleButton.setOnClickListener{
            Toast.makeText(applicationContext,"수컷을 입양합니다.",Toast.LENGTH_SHORT).show()
            button2=2;
        }
        babyButton.setOnClickListener{
            petImage.setImageResource(R.drawable.baby_dog)
            babyButton.startAnimation(anim);
            button1=1
            month.setText(button1.toString());
        }
        adultButton.setOnClickListener{
            petImage.setImageResource(R.drawable.adult_dog)
            adultButton.startAnimation(anim)
            button1=25
            month.setText(button1.toString());
        }
        oldButton.setOnClickListener{
            petImage.setImageResource(R.drawable.old_dog)
            oldButton.startAnimation(anim)
            button1=85
            month.setText(button1.toString());
        }

        saveInfo.setOnClickListener {
            if(button1==0 || button2==0 || TextUtils.isEmpty(petName.text.toString())){
                Toast.makeText(applicationContext,"선택해주세요",Toast.LENGTH_SHORT).show()
            }
            else {
                val type=loadFromInnerStorage("pet.txt")

                var first = petclass(petName.text.toString(),type.toInt());
                first.gender= button2
                first.month=button1

                saveToInnerStorage(first.saveinfo(),first.filename())
                saveToInnerStorage(first.filename(),"pet.txt")
                Toast.makeText(applicationContext, "저장되었습니다", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, TermsOfService::class.java))

            }
        }

    }

    fun saveToInnerStorage(text: String, filename: String){
        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }

    fun loadFromInnerStorage(filename: String):String{
        val fileInputStream=openFileInput(filename)
        return fileInputStream.reader().readText()
    }

}