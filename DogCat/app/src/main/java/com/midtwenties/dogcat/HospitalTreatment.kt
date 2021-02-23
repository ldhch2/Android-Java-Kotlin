package com.midtwenties.dogcat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.Random
import kotlinx.android.synthetic.main.activity_hospital_treatment.*

class HospitalTreatment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_treatment)

        back.setOnClickListener {
            finish()
        }

        val random = Random()
        val num = random.nextInt(6)
        var tt = findViewById<TextView>(R.id.textView3)

        if(num == 0){
            tt.setText("장염인 것 같습니다.")
        }
        else if (num == 1){
            tt.setText("산책하다가 다리 인대가 늘어난 것 같습니다.")
        }
        else if(num == 2){
            tt.setText("소화불량인 것 같습니다.")
        }
        else if(num == 3){
            tt.setText("귀에 염증이 발견되었습니다.")
        }
        else if(num == 4){
            tt.setText("위염")
        }
        else if(num == 5){
            tt.setText("피부염")
        }
    }
}