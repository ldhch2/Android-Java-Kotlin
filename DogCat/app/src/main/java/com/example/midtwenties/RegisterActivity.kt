package com.example.midtwenties

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.gcacace.signaturepad.views.SignaturePad
import kotlinx.android.synthetic.main.activity_register.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val next = Intent(this,PetIDActivity::class.java)


        val info=intent.getStringExtra("정보").toString()
        saveToInnerStorage(info,"test2.txt")

        saveToInnerStorage("aaaa","test3.txt")

        var signaturePad: SignaturePad =findViewById(R.id.signaturePad)
        signaturePad.setPenColor(Color.BLACK)

        clearButton.setOnClickListener{
            signaturePad.clear()
        }
        saveButton.setOnClickListener{
            val signature = signaturePad.signatureBitmap
            /* uri 전송 방법 */
            val signPath = bitmapToURI(signature)

            /* uri 전송 방법  */

            next.putExtra("signature", signPath)
            next.putExtra("정보",info)

        //    intent.putExtra("signature", signature)
            startActivity(next)
        }
    }

    /* uri 저장 방법 */
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