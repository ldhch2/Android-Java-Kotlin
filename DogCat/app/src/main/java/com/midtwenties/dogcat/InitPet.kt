package com.midtwenties.dogcat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_init_pet.*
import com.bumptech.glide.Glide

class InitPet : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init_pet)

        val next=Intent(this, InfoActivity::class.java);

        previewDog.isVisible=false
        previewCat.isVisible=false

        dogbutton.setOnClickListener{
            catbutton.isChecked=false
            dogbutton.isChecked=true
        }

        catbutton.setOnClickListener{
            dogbutton.isChecked=false
            catbutton.isChecked=true
        }

        SelectButton.setOnClickListener {
            if (dogbutton.isChecked==true) {
                Toast.makeText(applicationContext, "멍이가 선택되었습니다.", Toast.LENGTH_SHORT).show()
                next.putExtra("kind", 1)
                startActivity(next)
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
            }
            else if(catbutton.isChecked==true){
                Toast.makeText(applicationContext,"냥이가 선택되었습니다.",Toast.LENGTH_SHORT).show()
                next.putExtra("kind",2)
                startActivity(next)
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                finish()
            }
            else{
                Toast.makeText(applicationContext,"둘 중 하나를 체크해주세요",Toast.LENGTH_SHORT).show()
            }
        }

        var checkcat=0;
        var checkdog=0;

        cat_preview.setOnClickListener {
            if(checkcat==0) {
                checkcat=1
                cat_image.isVisible=false
                previewCat.isVisible=true
            }
            else{
                previewCat.isVisible=false
                cat_image.isVisible=true
                checkcat=0
            }
        }
        dog_preview.setOnClickListener {
            if(checkdog==0) {
                checkdog=1
                dog_image.isVisible=false
                previewDog.isVisible=true
            }
            else{
                previewDog.isVisible=false
                dog_image.isVisible=true
                checkdog=0
            }
        }
    }
}