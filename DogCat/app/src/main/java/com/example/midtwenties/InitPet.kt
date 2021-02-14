package com.example.midtwenties

import android.content.Context
import android.content.Intent
import android.icu.text.IDNA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_init_pet.*
import com.bumptech.glide.Glide


class InitPet : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init_pet)


        val next=Intent(this,InfoActivity::class.java);

        imageView3.visibility=View.INVISIBLE

        SelectButton.setOnClickListener {
            if(catbutton.isChecked==true){
                Toast.makeText(applicationContext,"냥이가 선택되었습니다.",Toast.LENGTH_SHORT).show()
                next.putExtra("kind",1)
                startActivity(next)
            }
            else if (dogbutton.isChecked==true){
                Toast.makeText(applicationContext,"멍이가 선택되었습니다.",Toast.LENGTH_SHORT).show()
                next.putExtra("kind",2)
                startActivity(next)
            }
            else{
                Toast.makeText(applicationContext,"둘 중 하나를 체크해주세요",Toast.LENGTH_SHORT).show()
            }
        }

        var checkcat=0;
        var checkdog=0;

        cat_preview.setOnClickListener {
            if(checkcat==0 || checkdog==1) {
                Glide.with(this).load(R.raw.yoon).into(imageView3)
                imageView3.visibility=View.VISIBLE
                checkcat=1
                checkdog=0
            }
            else{
                imageView3.visibility=View.INVISIBLE
                checkcat=0
            }
        }
        dog_preview.setOnClickListener {
            if(checkdog==0 || checkcat==1) {
                Glide.with(this).load(R.raw.a).into(imageView3)
                imageView3.visibility=View.VISIBLE
                checkdog=1
                checkcat=0
            }
            else{
                imageView3.visibility=View.INVISIBLE
                checkdog=0
            }
        }
    }
}