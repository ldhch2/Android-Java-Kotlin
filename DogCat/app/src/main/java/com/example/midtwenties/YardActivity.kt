package com.example.midtwenties

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_yard.*

class YardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yard)

        Log.v("버전 : ", " SDK_INT" + Build.VERSION_CODES.O)

        showAttendance.setOnClickListener {
            var intent = Intent(this, AttendancePopup::class.java)
            intent.putExtra("data", "Test Popup")
            startActivityForResult(intent, 1)
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == 1) {
            if(resultCode == RESULT_OK) {
                var result = data?.getStringExtra("result")
                val buttonText = findViewById<Button>(R.id.showAttendance)
                buttonText.text = "출석 완료"
            }
        }
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