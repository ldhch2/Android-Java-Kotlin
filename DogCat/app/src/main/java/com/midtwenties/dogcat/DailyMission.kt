package com.midtwenties.dogcat

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_daily_mission.*
import kotlinx.android.synthetic.main.activity_daily_mission.backButton
import kotlinx.android.synthetic.main.activity_item_popup.*
import kotlinx.android.synthetic.main.activity_mission.*

class DailyContacts(var missionContents: String, var missionComplete:String)

class DailyMission: AppCompatActivity(){
    var missionlist = arrayListOf<DailyContacts>(
        DailyContacts("모든 데일리 미션 완료",""),
        DailyContacts("산책 1회",""),
        DailyContacts("밥 3회",""),
        DailyContacts("놀아주기 2회",""),
        DailyContacts("쓰다듬기 20회",""),
        DailyContacts("yard에서 30번 움직이기",""),
        DailyContacts("씻기 1회",""),
        DailyContacts("영양제 섭취 1회",""),
        DailyContacts("광고 3회 보기",""),
        DailyContacts("검진 1회","")
    )


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_mission)

        backButton.setOnClickListener{
            onBackPressed()
        }

        val dailymissionadapter = DailyMissionListAdapter(this,missionlist)
        DailyMissionRecyclerView.adapter = dailymissionadapter

        val gridLayoutManager = GridLayoutManager(applicationContext,3)
        DailyMissionRecyclerView.layoutManager = gridLayoutManager


    }
}

class DailyMissionListAdapter(val context: Context, val dailylist : ArrayList<DailyContacts>):
        RecyclerView.Adapter<DailyMissionListAdapter.Holder>(){
    inner class Holder(missionView: View?) : RecyclerView.ViewHolder(missionView!!){
        val Contents = missionView?.findViewById<TextView>(R.id.DailyMissionText)
        val Complete = missionView?.findViewById<TextView>(R.id.DailyMissionComplete)

        fun bind(Missionitem : DailyContacts,context: Context){
            Contents?.text = Missionitem.missionContents
            Complete?.text = Missionitem.missionComplete

        }
    }
    override fun getItemCount(): Int{
        return dailylist.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.activity_dailymission_contacts,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(dailylist[position], context)
    }
}