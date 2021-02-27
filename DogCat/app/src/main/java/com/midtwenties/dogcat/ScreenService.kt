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
import android.os.IBinder
import androidx.annotation.RequiresApi

class ScreenService : Service() {

    var receiver:Screenoffreceiver?=null
    private val ANDROID_CHANNEL_ID="com.midtwenties.dogcat"
    private val NOTIFICATION_ID=9999

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

        return Service.START_REDELIVER_INTENT
    }

    override fun onDestroy() {
        super.onDestroy()

        if (receiver!= null){
            unregisterReceiver(receiver)
        }

    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}