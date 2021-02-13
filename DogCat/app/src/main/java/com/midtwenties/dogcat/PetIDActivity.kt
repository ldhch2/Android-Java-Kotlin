package com.midtwenties.dogcat

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.gcacace.signaturepad.views.SignaturePad
import kotlinx.android.synthetic.main.activity_pet_id.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class PetIDActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_id)
        val intent1= intent

        val next=Intent(this,TermsOfService::class.java)

        val get=intent.getStringExtra("정보").toString()
        saveToInnerStorage(get,"test5.txt")
        next.putExtra("정보",get)

        val uri: Uri? =intent1.getParcelableExtra("signature")
        signature.setImageURI(uri)

        var imagePad: SignaturePad =findViewById(R.id.imagePad)

        check.setOnClickListener{
            val cardBitmap = imagePad.signatureBitmap
            val cardURI = bitmapToURI(cardBitmap)

            val ur=cardURI.toString()
            next.putExtra("imageURI", ur)

            startActivity(next)
        }

    }

    fun bitmapToURI(bitmap: Bitmap): Uri {
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

    fun saveToInnerStorage(text: String, filename: String) {
        val fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE)
        fileOutputStream.write(text.toByteArray())
        fileOutputStream.close()
    }

}