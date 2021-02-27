package com.midtwenties.dogcat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import java.util.Random
import kotlinx.android.synthetic.main.activity_info_next.*

class InfoNext : AppCompatActivity() {

    val random = Random()
    val numb = random.nextInt(5) + 1
    val filename = "init.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_next)

        val imagePet: ImageView = findViewById(R.id.imagePet)
        Glide.with(this).load(R.raw.doggy).into(imagePet)

        val get=intent.getStringExtra("info").toString()

        var next=Intent(this, RegisterActivity::class.java)
        next.putExtra("info",String.format("%s %d 50 7 19 50 50 50 50",get,numb))

        var character: Character = if (numb==0) Perfect()
        else if (numb==1) Foodfight()
        else if (numb==2) Naughty()
        else if (numb==3) Cleaner()
        else if (numb==4) Lazy()
        else if (numb==5) Coward()
        else Perfect()

        characterView2.text=character.info.toString()

        button10.setOnClickListener {
            startActivity(next)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }
    }

    fun saveToInnerStorage(text: String, filename: String) {
        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }

}