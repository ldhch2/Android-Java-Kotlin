package com.example.midtwenties

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class YardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yard)
    }


    override fun onBackPressed() {
        val alBuilder = AlertDialog.Builder(this)
        alBuilder.setMessage("Are you sure you want to exit?")
        alBuilder.setNegativeButton("okay") { dialogInterface, which -> finish() }
        alBuilder.setPositiveButton("cancel", DialogInterface.OnClickListener { dialogInterface, i -> return@OnClickListener })
        alBuilder.setTitle("Exit")
        alBuilder.show()
    }
}