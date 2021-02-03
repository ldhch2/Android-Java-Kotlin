package com.example.midtwenties

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import java.util.Random
import android.view.View
import kotlinx.android.synthetic.main.activity_info_next.*


class InfoNext : AppCompatActivity() {

    val random = Random()
    val num = random.nextInt(5)
    val filename = "init.txt"

    var arrayNature = arrayOf("지나치게 경계함", "지나치게 소심함", "지나치게 까다로움", "지나치게 활발함", "지나치게 게으름")

    override fun onCreate(savedInstanceState: Bundle?) {
        //Imageview initPet = findViewById(R.id.initPet)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_next)
        
        Glide.with(this).load(R.drawable.doggy).into(imagePet)
        saveToInnerStorage("true", filename)
        startActivity(Intent(this, YardActivity::class.java))
        finish()
    }


    fun saveToInnerStorage(text: String, filename: String) {
        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }

}