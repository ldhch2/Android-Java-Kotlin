package com.example.midtwenties

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

<<<<<<< Updated upstream:DogCat/app/src/main/java/com/example/midtwenties/RegisterActivity.kt
        //var signaturePad:SignaturePad=findViewById(R.id.signaturePad)
=======
        val next = Intent(this, PetIDActivity::class.java)


        val info=intent.getStringExtra("info").toString()

        var signaturePad: SignaturePad =findViewById(R.id.signaturePad)
>>>>>>> Stashed changes:DogCat/app/src/main/java/com/midtwenties/dogcat/RegisterActivity.kt
        signaturePad.setPenColor(Color.BLACK)

        clearButton.setOnClickListener{
            signaturePad.clear()
        }
        saveButton.setOnClickListener{
            val signature = signaturePad.signatureBitmap

<<<<<<< Updated upstream:DogCat/app/src/main/java/com/example/midtwenties/RegisterActivity.kt
            /* uri 전송 방법
            val signPath = saveBitmap(signature)
            */

            val intent = Intent(this,CheckActivity::class.java)
            /* uri 전송 방법
            intent.putExtra("signature", signPath)
            */
            intent.putExtra("signature", signature)
            startActivity(intent)
=======
            next.putExtra("signature", signPath)
            next.putExtra("info",info)
            startActivity(next)
>>>>>>> Stashed changes:DogCat/app/src/main/java/com/midtwenties/dogcat/RegisterActivity.kt
        }
    }

    /* uri 저장 방법
    fun saveBitmap(bitmap: Bitmap): Uri {
        val wrapper = ContextWrapper(applicationContext)

        val petName="bara"
        var file = wrapper.getDir("Images", Context.MODE_PRIVATE)
        file = File(file, "${petName}_signature.jpg")

        try{
            val stream: OutputStream = FileOutputStream(file)
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream)
            stream.flush()
            stream.close()
        }catch (e: IOException){
        }

        return Uri.parse(file.absolutePath)
    }
    */
}