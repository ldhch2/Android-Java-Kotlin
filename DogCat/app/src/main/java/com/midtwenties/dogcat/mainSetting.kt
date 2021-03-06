package com.midtwenties.dogcat

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_setting.*

class MainSetting : AppCompatActivity() {

    val prefernce by lazy { getSharedPreferences("setting_data", Context.MODE_PRIVATE) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_setting)

        switch1.isChecked=true

        button.setOnClickListener {
            prefernce.edit().putBoolean("screen",switch1.isChecked).apply()
        }

        backButton.setOnClickListener{
            onBackPressed()
        }
    }

}