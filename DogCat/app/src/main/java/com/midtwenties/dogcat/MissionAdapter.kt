package com.midtwenties.dogcat

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MissionAdapter(val context: Context, val MissionList: ArrayList<Mission>):
        RecyclerView.Adapter<MissionAdapter.Holder>() {
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val missionname = itemView?.findViewById<TextView>(R.id.MissionName)
        val missioncomplete = itemView?.findViewById<TextView>(R.id.complete)
        val missioncondition = itemView?.findViewById<TextView>(R.id.condition)
        val missionpercent = itemView?.findViewById<ProgressBar>(R.id.progressBar2)

        fun bind (mission: Mission, context: Context) {
            /* TextView와 String 데이터를 연결한다. */
            missionname?.text = mission.MissionName
            missioncomplete?.text = mission.CompleteTrials.toString()
            missioncondition?.text = mission.ConditionTrials.toString()
            missionpercent?.progress= (((mission.CompleteTrials.toFloat())/(mission.ConditionTrials.toFloat())) * 100).toInt()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view= LayoutInflater.from(context).inflate(R.layout.mission,parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return MissionList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(MissionList[position],context)
    }
}
