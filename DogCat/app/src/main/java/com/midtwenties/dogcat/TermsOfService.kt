package com.midtwenties.dogcat

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_terms_of_service.*

class TermsOfService : AppCompatActivity() {

    val init = "init"
    val screen = "screen"

    val prefernce by lazy { getSharedPreferences("setting_data",Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_of_service)

        var get=intent.getStringExtra("info").toString()

        val next=Intent(this,YardActivity::class.java)

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

                get+=" "+intent.getStringExtra("imageURI").toString()

                val name= get.split(" ")
                saveToInnerStorage(String.format("%s.txt",name[0]),"pet.txt")
                saveToInnerStorage(get,String.format("%s.txt",name[0]))

                prefernce.edit().putBoolean(screen,checkBox1.isChecked).apply()
                prefernce.edit().putBoolean(init,true).apply()

                startActivity(next)
            }
            else Toast.makeText(applicationContext,"선택해주세요.",Toast.LENGTH_SHORT).show()
        }
    }

    fun saveToInnerStorage(text: String, filename: String){
        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }
}