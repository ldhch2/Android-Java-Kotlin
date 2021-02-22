package com.midtwenties.dogcat

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat.setBackground
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_pet_id.*
import kotlinx.android.synthetic.main.activity_pet_id.petImage
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_terms_of_service.view.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class PetIDActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_id)

        val next=Intent(this,TermsOfService::class.java)
        var kind: Int = intent.getIntExtra("kind",0)
        if(kind==1) Glide.with(this).load(R.drawable.basicdog).into(petImage)
        else if(kind==2) Glide.with(this).load(R.drawable.basiccat).into(petImage)

        val get=intent.getStringExtra("info").toString()
        next.putExtra("info",get)


        val uri: Uri? =intent.getParcelableExtra("signature")
        signature.setImageURI(uri)

        save.setOnClickListener{
            val cardBitmap =captureView(findViewById(R.id.idcardView), idcardView.height, idcardView.width)
            val cardURI=bitmapToURI(cardBitmap)
            val imageuri=cardURI.toString()
            next.putExtra("imageURI", imageuri)
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

    fun captureView(view: View, height: Int, width: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.TRANSPARENT)
        view.draw(canvas)
        return bitmap
    }
}