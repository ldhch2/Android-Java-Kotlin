package com.midtwenties.dogcat

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.os.Build
import android.os.CountDownTimer
import android.os.IBinder
import android.widget.Toast
import androidx.core.app.NotificationCompat

class ScreenService : Service() {

    var receiver:Screenoffreceiver?=null
    private val ANDROID_CHANNEL_ID="com.midtwenties.dogcat"
    private val NOTIFICATION_ID=9999
    var message = ""

    val prefernce by lazy { getSharedPreferences("setting_data",Context.MODE_PRIVATE) }



    var builder = NotificationCompat.Builder(this, ANDROID_CHANNEL_ID)
            .setSmallIcon(R.drawable.logo)
            .setContentTitle("반려견이 메세지를 보냈어요")
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)



    override fun onCreate() {
        super.onCreate()

        if(receiver==null){
            receiver= Screenoffreceiver()
            val filter=IntentFilter(Intent.ACTION_SCREEN_OFF)
            registerReceiver(receiver,filter)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        if(intent!=null){
            if(intent.action==null){
                if(receiver==null){
                    receiver= Screenoffreceiver()
                    val filter=IntentFilter(Intent.ACTION_SCREEN_OFF)
                    registerReceiver(receiver,filter)
                }
            }
        }

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            val chan=NotificationChannel(ANDROID_CHANNEL_ID,"dogcatService",NotificationManager.IMPORTANCE_NONE)
            chan.lightColor= Color.BLUE
            chan.lockscreenVisibility= Notification.VISIBILITY_PRIVATE

            val manager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            manager.createNotificationChannel(chan)

            val builder=Notification.Builder(this,ANDROID_CHANNEL_ID).setContentTitle(getString(R.string.app_name)).setContentText("SmartTracker Running")
            val notification=builder.build()

            startForeground(NOTIFICATION_ID,notification)
        }

        val timer = object : CountDownTimer(360 * 1000,  1000) {
            val filename=prefernce.getString("nowpet","").toString()
            val pet= PetClass(loadFromInnerStorage(filename))
            override fun onTick(millisUntilFinished: Long) {
                // 펫의 특성에 따라 상태 바꾸기
                Toast.makeText(applicationContext, "진행되는중",Toast.LENGTH_LONG).show()
            }
            override fun onFinish() {
                if(pet.state.full <= 20) {
                    // 배고프다는 팝업알림 띄우기
                    message = "배고픈 반려견에게 밥을 주세요!"
                }
                if(pet.state.clean <= 20) {
                    // 씻겨달라는 팝업알림 띄우기
                    if(message == "") {
                        message = "찝찝한 반려견을 씻겨 주세요!"
                    }
                    else {
                        message += "\n찝찝한 반려견을 씻겨 주세요!"
                    }
                }
                if(pet.state.excited <= 20 || pet.state.happy <= 20 || pet.state.relaxed <= 20) {
                    // 놀아달라는 팝업알림 띄우기
                    if(message == "") {
                        message = "혼자 있는 반려견을 놀아 주세요!"
                    }
                    else {
                        message += "\n혼자 있는 반려견을 놀아 주세요!"
                    }
                }
                if(pet.state.healthy <= 20) {
                    // 아프다는 팝업알림 띄우기
                    if(message == "") {
                        message = "아픈 반려견을 병원에 보내주세요!"
                    }
                    else {
                        message += "\n아픈 반려견을 병원에 보내주세요!"
                    }
                }
                if(message != "") {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        val importance = NotificationManager.IMPORTANCE_DEFAULT
                        val channel = NotificationChannel(ANDROID_CHANNEL_ID, "냥냥멍멍", importance)
                        val notificationManager : NotificationManager =
                                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                        notificationManager.createNotificationChannel(channel)
                        notificationManager.notify(ANDROID_CHANNEL_ID.toInt(), builder.build())
                    }
                    else {
                        val notificationManager : NotificationManager =
                                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                        notificationManager.notify(ANDROID_CHANNEL_ID.toInt(), builder.build())
                    }
                    message = ""
                }
                this.start()
            }
        }

        timer.start()


        return Service.START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        super.onDestroy()
        if (receiver!= null){
            unregisterReceiver(receiver)
        }

    }

    fun loadFromInnerStorage(filename: String):String{
        val fileInputStream=openFileInput(filename)
        return fileInputStream.reader().readText()
    }


    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}