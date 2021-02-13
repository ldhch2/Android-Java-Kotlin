package com.example.midtwenties

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pet_id.*

class PetIDActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_id)
        val intent= intent

        /* uri 전송 방법*/
        val uri: Uri? =intent.getParcelableExtra("signature")
        signature.setImageURI(uri)

        /* bitmap 전송 방법
        val bitmap: Bitmap? =intent.getParcelableExtra("signature")
        signature.setImageBitmap(bitmap)
*/
        check.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}