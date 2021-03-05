package com.midtwenties.dogcat

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_buyitem.*

class Buynewitem : AppCompatActivity() {

    val prefernce by lazy { getSharedPreferences("setting_data", Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buyitem)

        val name=intent.getStringExtra("item")
        val option=intent.getStringExtra("option")
        val category=intent.getStringExtra("category")

        var info = prefernce.getString(category,null)
        if (info==null) info=String.format("%s",name)
        else info += String.format(" %s",name)
        prefernce.edit().putString(category,info).apply()

        button2.setOnClickListener {
            finish()
        }
    }
}