package com.example.midtwenties

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_init_pet.*
import com.bumptech.glide.Glide


class init_pet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init_pet)

        imageView3.visibility=View.INVISIBLE
        SelectButton.setOnClickListener {
            if(catbutton.isChecked==true){
                Toast.makeText(applicationContext,"냥이가 선택되었습니다.",Toast.LENGTH_SHORT).show()
                saveToInnerStorage("냥이","pet.txt")
                startActivity(Intent(this, InfoActivity::class.java))
            }
            else if (dogbutton.isChecked==true){
                Toast.makeText(applicationContext,"멍이가 선택되었습니다.",Toast.LENGTH_SHORT).show()
                saveToInnerStorage("멍이","pet.txt")
                startActivity(Intent(this, InfoActivity::class.java))
            }
            else{
                Toast.makeText(applicationContext,"둘 중 하나를 체크해주세요",Toast.LENGTH_SHORT).show()
            }
        }

        var checkcat=0;
        var checkdog=0;

        cat_preview.setOnClickListener {
            if(checkcat==0){
                Glide.with(this).load(R.raw.yoon).into(cat_image)
                checkcat=1
            }
            else{
                cat_image.setImageResource(R.drawable.yoon1)
                checkcat=0
            }
        }
        dog_preview.setOnClickListener {
            if(checkdog==0) {
                Glide.with(this).load(R.raw.a).into(dog_image)
                checkdog=1
            }
            else{
                dog_image.setImageResource(R.drawable.yoon2)
                checkdog=0
            }
        }

        testbutton.setOnClickListener {
            if(imageView3.visibility==View.VISIBLE) imageView3.visibility=View.INVISIBLE
            else imageView3.visibility=View.VISIBLE
        }

    }

    fun saveToInnerStorage(text: String, filename: String){
        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }

}