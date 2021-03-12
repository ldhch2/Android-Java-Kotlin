package com.midtwenties.dogcat

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_daily_mission.*
import kotlinx.android.synthetic.main.activity_daily_mission.backButton
import java.util.*
import kotlin.collections.ArrayList

class DailyMission: AppCompatActivity(){

    var missionlist = arrayListOf<Missionclass>()
    val random = Random()


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_mission)

        backButton.setOnClickListener{
            onBackPressed()
        }
        var checklist = arrayListOf<Int>()
        var i = 0
        while (true){

            var randomint = random.nextInt(9)
            if(checklist.contains(randomint)){
                missionlist.add(Missionclass(randomint))
                checklist.add(randomint)
                i++
            }
            if(i==5)break;

        }

        val dailymissionadapter = DailyMissionListAdapter(this,missionlist)
        DailyMissionRecyclerView.adapter = dailymissionadapter

        val gridLayoutManager = GridLayoutManager(applicationContext,3)
        DailyMissionRecyclerView.layoutManager = gridLayoutManager


    }
}

class DailyMissionListAdapter(val context: Context, val dailylist : ArrayList<Missionclass>):
        RecyclerView.Adapter<DailyMissionListAdapter.Holder>(){
    inner class Holder(missionView: View?) : RecyclerView.ViewHolder(missionView!!){
        val missiontext  = missionView?.findViewById<TextView>(R.id.DailyMissionText)
        val mission1 = missionView?.findViewById<TextView>(R.id.DailyMission1)
        val mission2 = missionView?.findViewById<TextView>(R.id.DailyMission2)

        fun bind(Missionitem : Missionclass,context: Context){
            missiontext?.text = Missionitem.Mission_content
            mission1?.text = Missionitem.Mission_daily_now.toString()
            mission2?.text = Missionitem.Mission_daily_max.toString()
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