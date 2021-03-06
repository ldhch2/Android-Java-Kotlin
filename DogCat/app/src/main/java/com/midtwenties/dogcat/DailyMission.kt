package com.midtwenties.dogcat

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_daily_mission.*
import kotlinx.android.synthetic.main.activity_mission.*

class DailyContacts(var missionContents: String, var missionComplete:String)

class DailyMission: AppCompatActivity(){
    var missionlist = arrayListOf<DailyContacts>(
        DailyContacts("ddd","seifjlaisdjlfi"),
        DailyContacts("elaifjselifj","cliasjelfijasej")
    )

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_mission)

        backButton.setOnClickListener{
            onBackPressed()
        }

        val dailymissionadapter = DailyMissionListAdapter(this,missionlist)
        DailyMissionRecyclerView.adapter = dailymissionadapter

        val lm = LinearLayoutManager(this)
        DailyMissionRecyclerView.layoutManager = lm
        DailyMissionRecyclerView.setHasFixedSize(true)


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