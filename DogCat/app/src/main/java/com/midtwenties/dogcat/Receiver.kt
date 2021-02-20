package com.midtwenties.dogcat

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class Receiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when{
            intent?.action==Intent.ACTION_BOOT_COMPLETED->{
                Log.d("quizlocker","부팅완료")
                Toast.makeText(context,"부팅 완료",Toast.LENGTH_LONG).show()
            }
        }
    }
}