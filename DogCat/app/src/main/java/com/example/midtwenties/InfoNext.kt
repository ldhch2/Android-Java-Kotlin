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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_next)

<<<<<<< Updated upstream:DogCat/app/src/main/java/com/example/midtwenties/InfoNext.kt
=======
        val imagePet: ImageView = findViewById(R.id.imagePet)
        Glide.with(this).load(R.raw.doggy).into(imagePet)

        val get=intent.getStringExtra("info").toString()

        val next=Intent(this, RegisterActivity::class.java)
        next.putExtra("info",String.format("%s %d 50 50 50 50 50 50 50",get,numb))
>>>>>>> Stashed changes:DogCat/app/src/main/java/com/midtwenties/dogcat/InfoNext.kt

        val next=Intent(this,TermsOfService::class.java)

        Glide.with(this).load(R.raw.doggy).into(imagePet)

<<<<<<< Updated upstream:DogCat/app/src/main/java/com/example/midtwenties/InfoNext.kt
        val get=intent.getStringExtra("정보")
        next.putExtra("정보",String.format("%s %d 50 50 50 50 50 50 50",get,num))

        Glide.with(this).load(R.raw.doggy).into(imagePet)
=======
>>>>>>> Stashed changes:DogCat/app/src/main/java/com/midtwenties/dogcat/InfoNext.kt
        button10.setOnClickListener {
            startActivity(next)
        }
    }
<<<<<<< Updated upstream:DogCat/app/src/main/java/com/example/midtwenties/InfoNext.kt


    fun saveToInnerStorage(text: String, filename: String) {
        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }

=======
>>>>>>> Stashed changes:DogCat/app/src/main/java/com/midtwenties/dogcat/InfoNext.kt
}