package com.midtwenties.dogcat

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.github.gcacace.signaturepad.views.SignaturePad
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.activity_register.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val next = Intent(this, PetIDActivity::class.java)
        val info=intent.getStringExtra("info").toString()
        var kind: Int = intent.getIntExtra("kind",0)
        if(kind==1) Glide.with(this).load(R.drawable.basicdog).into(petImage)
        else if(kind==2) Glide.with(this).load(R.drawable.basiccat).into(petImage)


        var signaturePad: SignaturePad =findViewById(R.id.signaturePad)
        signaturePad.setPenColor(Color.BLACK)

        clearButton.setOnClickListener{
            signaturePad.clear()
        }
        saveButton.setOnClickListener{
            val signature = signaturePad.signatureBitmap
            val signPath = bitmapToURI(signature)

            next.putExtra("signature", signPath)
            next.putExtra("info",info)
            next.putExtra("kind",kind)
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