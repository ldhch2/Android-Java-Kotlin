package com.midtwenties.dogcat

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.github.gcacace.signaturepad.views.SignaturePad
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.petImage
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class RegisterActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val next = Intent(this, PetIDActivity::class.java)
        val info=intent.getStringExtra("info").toString()
        val arr=info.split(" ")
        val name=arr[0]
        val kind=arr[1].toInt()
        val month=arr[2].toInt()
        val gender=arr[3].toInt()

        val now=LocalDate.now()

        var birth=now
        when (month) {
            1 ->  birth=now.minusMonths(1)
            25 -> birth=now.minusMonths(25)
            85 -> birth=now.minusMonths(85)

        }
        val birthday: String = birth.format(DateTimeFormatter.ofPattern("yyMMdd"))

        if(kind==1) Glide.with(this).load(R.drawable.basicdog).into(petImage)
        else if(kind==2) Glide.with(this).load(R.drawable.basiccat).into(petImage)
        registerName.setText(name)
        if(gender==1) registerGender.setText("女")
        else if (gender==2) registerGender.setText("男")
        registerBirthday.setText(birthday)


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
            finish()
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
