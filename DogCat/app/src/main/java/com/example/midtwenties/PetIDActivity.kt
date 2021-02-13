package com.example.midtwenties

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.gcacace.signaturepad.views.SignaturePad
import kotlinx.android.synthetic.main.activity_pet_id.*
import kotlinx.android.synthetic.main.activity_register.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

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

        var imagePad: SignaturePad =findViewById(R.id.imagePad)

        check.setOnClickListener{
            val cardImage = imagePad.signatureBitmap
            val cardPath = bitmapToURI(cardImage)

            startActivity(Intent(this, MainActivity::class.java))
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
}