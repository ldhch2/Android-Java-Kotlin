package com.midtwenties.dogcat

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import android.view.animation.AlphaAnimation
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        var kind: Int = intent.getIntExtra("kind",0)

        if(kind==1) catImage.isVisible=false
        else if(kind==2) dogImage.isVisible=false

        var button1=0;
        var button2=0;

        val next=Intent(this, InfoNext::class.java)

        var anim =  AlphaAnimation(0.0f,1.0f)

        femaleButton.setOnClickListener{
            Toast.makeText(applicationContext,"암컷을 입양합니다.",Toast.LENGTH_SHORT).show()
            femaleButton.setColorFilter(Color.parseColor("#A17432"))
            maleButton.setColorFilter(Color.BLACK)
            button2=1;
        }
        maleButton.setOnClickListener{
            Toast.makeText(applicationContext,"수컷을 입양합니다.",Toast.LENGTH_SHORT).show()
            maleButton.setColorFilter(Color.parseColor("#A17432"))
            femaleButton.setColorFilter(Color.BLACK)
            button2=2;
        }

        babyButton.setOnClickListener{
            dogImage.setImageResource(R.drawable.baby_dog)
            catImage.setImageResource(R.drawable.baby_dog)
            babyButton.startAnimation(anim);
            button1= 1
            month.setText(button1.toString());
        }
        adultButton.setOnClickListener{
            dogImage.setImageResource(R.drawable.adult_dog)
            catImage.setImageResource(R.drawable.adult_dog)
            adultButton.startAnimation(anim)
            button1=25
            month.setText(button1.toString());
        }
        oldButton.setOnClickListener{
            dogImage.setImageResource(R.drawable.old_dog)
            catImage.setImageResource(R.drawable.old_dog)
            oldButton.startAnimation(anim)
            button1=85
            month.setText(button1.toString());
        }

        petName.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KEYCODE_ENTER) {
                Toast.makeText(applicationContext,"완료됐습니다",Toast.LENGTH_SHORT).show()
                return@setOnKeyListener  false
            }
            else{
                return@setOnKeyListener false
            }
        }

        saveInfo.setOnClickListener {
            if(button1==0 || button2==0 || TextUtils.isEmpty(petName.text.toString())){
                Toast.makeText(applicationContext,"모든 정보를 입력해주세요",Toast.LENGTH_SHORT).show()
            }
            else {
                val info=String.format("%s %d %d %d",petName.text.toString(),kind,button1,button2)
                next.putExtra("info", info)
                Toast.makeText(applicationContext, "저장되었습니다", Toast.LENGTH_SHORT).show()

                startActivity(next)
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
            }
        }
    }

    fun saveToInnerStorage(text: String, filename: String){
        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }


}