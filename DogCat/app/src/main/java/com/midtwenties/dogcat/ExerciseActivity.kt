package com.midtwenties.dogcat

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_exercise.*

class ExerciseActivity : AppCompatActivity() {
    var totalStep = 0
    var isStart = false

    val sensorManager: SensorManager by lazy{
        getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    val eventListener: SensorEventListener = object : SensorEventListener{
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        }

        override fun onSensorChanged(event: SensorEvent?) {
            event?.let {
                if (event.sensor.type != Sensor.TYPE_STEP_COUNTER) return@let
                val step = Math.pow(event.values[0].toDouble(), 2.0) + Math.pow(event.values[1].toDouble(), 2.0) + Math.pow(event.values[2].toDouble(), 2.0)
                if (!isStart){
                    isStart=true
                }
                if(event.sensor.getType()==Sensor.TYPE_STEP_COUNTER){
                    totalStep= event.values[0].toInt()
                    steps.setText(""+totalStep)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        backButton.setOnClickListener {
            Toast.makeText(applicationContext, "${String.format("%d", totalStep)}", Toast.LENGTH_LONG).show()
            onBackPressed()
        }
    }

    override fun onBackPressed(){
        isStart = false
        val intent= Intent(this, MainActivity::class.java)
        intent.putExtra("step", totalStep) // 총 운동량
        startActivity(intent)
        finish()
    }

    override fun onStart(){
        super.onStart()
        initGame()
    }

    override fun onStop(){
        super.onStop()
        try{
            sensorManager.unregisterListener(eventListener)
        }catch (e:Exception){}
    }

    fun initGame(){
        totalStep = 0
        isStart = false

        sensorManager.registerListener(
            eventListener,
            sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER),
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }
}