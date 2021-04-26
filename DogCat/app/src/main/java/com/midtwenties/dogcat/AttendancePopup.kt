package com.midtwenties.dogcat

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.Window
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_attendance_popup.*

class AttendancePopup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        } catch (e:IllegalStateException) { }

        // 타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_attendance_popup)

        val intent = getIntent()
        val result = intent.getIntExtra("countDate", 0)

        if(result == 1) {
            val layout = findViewById<LinearLayout>(R.id.layoutDay1)
            layout.setBackgroundResource(R.drawable.mycolor)
        }
        else if(result == 2) {
            val layout = findViewById<LinearLayout>(R.id.layoutDay2)
            layout.setBackgroundResource(R.drawable.mycolor)
        }
        else if(result == 3) {
            val layout = findViewById<LinearLayout>(R.id.layoutDay3)
            layout.setBackgroundResource(R.drawable.mycolor)
        }
        else if(result == 4) {
            val layout = findViewById<LinearLayout>(R.id.layoutDay4)
            layout.setBackgroundResource(R.drawable.mycolor)
        }
        else if(result == 5) {
            val layout = findViewById<LinearLayout>(R.id.layoutDay5)
            layout.setBackgroundResource(R.drawable.mycolor)
        }

        closeButton.setOnClickListener {
            var intent = Intent()
            intent.putExtra("result", "Close Popup")
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if(event?.action == MotionEvent.ACTION_OUTSIDE) {
            return false
        }
        return true
    }
    override fun onBackPressed() {
        return
    }
}