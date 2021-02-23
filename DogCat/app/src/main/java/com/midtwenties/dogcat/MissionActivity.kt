package com.example.midtwenties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_mission.*

class MissionActivity : AppCompatActivity() {

    var MissionList = arrayListOf<Mission>(
            Mission("산책 10번 시키기",10,5),
            Mission("밥 10번 주기",10,3)
    )




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mission)

        val missionadapter = MissionAdapter(this,MissionList)
        missionRecyclerView.adapter = missionadapter

        val lm = LinearLayoutManager(this)
        missionRecyclerView.layoutManager = lm
        missionRecyclerView.setHasFixedSize(true)


    }
}