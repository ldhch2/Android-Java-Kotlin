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

        val save=intent.getStringExtra("info")

        var info = prefernce.getString("item",null)
        if (info==null) info=save
        else info += String.format(" %s",save)
        prefernce.edit().putString("item",info).apply()

        button2.setOnClickListener {
            finish()
        }
    }
}