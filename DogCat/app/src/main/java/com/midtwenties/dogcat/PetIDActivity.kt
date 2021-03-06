package com.midtwenties.dogcat

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_pet_id.*
import kotlinx.android.synthetic.main.activity_pet_id.petImage
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.Calendar.MONTH

class PetIDActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_id)

        val next=Intent(this,TermsOfService::class.java)


        val get=intent.getStringExtra("info").toString()
        next.putExtra("info",get)
        val arr=get.split(" ")
        val name=arr[0]
        val kind=arr[1].toInt()
        val month=arr[2].toInt()
        val gender=arr[3].toInt()

        val today= SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date())
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
        petidName.setText(name)
        if(gender==1) petidGender.setText("女")
        else if (gender==2) petidGender.setText("男")
        petidBirthday.setText(birthday)

        val uri: Uri? =intent.getParcelableExtra("signature")
        signature.setImageURI(uri)
        petidDay.setText(today)

        save.setOnClickListener{
            val cardBitmap =captureView(findViewById(R.id.idcardView), idcardView.height, idcardView.width)
            val cardURI=bitmapToURI(cardBitmap)
            val imageuri=cardURI.toString()
            next.putExtra("imageURI", imageuri)
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

    fun captureView(view: View, height: Int, width: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.TRANSPARENT)
        view.draw(canvas)
        return bitmap
    }
}