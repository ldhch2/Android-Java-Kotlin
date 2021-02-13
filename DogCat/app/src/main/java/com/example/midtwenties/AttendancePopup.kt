package com.example.midtwenties

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.Window
import kotlinx.android.synthetic.main.activity_attendance_popup.*

class AttendancePopup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_attendance_popup)

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