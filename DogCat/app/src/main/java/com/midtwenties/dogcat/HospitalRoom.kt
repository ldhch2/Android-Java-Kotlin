package com.midtwenties.dogcat

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_hospital_room.*

class HospitalContacts (var name: String, var price: Int, var buy : String, var effects : String)

class HospitalRoom : AppCompatActivity() {
    var injectionList = arrayListOf<HospitalContacts>(
            HospitalContacts("종합백신", 500, "구매", "효능"),
            HospitalContacts("신종플루", 300, "구매", "효능 어쩌구저쩌구")
    )
    var nutritionList = arrayListOf<HospitalContacts>(
            HospitalContacts("종합비타민", 100, "구매", "효능"),
            HospitalContacts("유산균", 200, "구매", "효능 어쩌구저쩌구"),
            HospitalContacts("오메가3", 50, "구매", "오메가33"),
            HospitalContacts("밀크시슬", 100, "구매", "간 기능 개선"),
            HospitalContacts("글루코사민", 200, "구매", "관절 기능 개선")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_room)

        backButton.setOnClickListener {
            onBackPressed()
        }

        var type = intent.getIntExtra("room", 0)
        if(type == 1) {
            val roomType = findViewById<TextView>(R.id.RoomType)
            roomType.text = "주사실"
            val roomText = findViewById<TextView>(R.id.RoomText)
            roomText.text = "주사를 선택해주세요."

            val adapter = NutritionListAdapter(this, injectionList)
            NutritionRecyclerview.adapter = adapter
        } else if(type == 2) {
            val roomType = findViewById<TextView>(R.id.RoomType)
            roomType.text = "영양제실"
            val roomText = findViewById<TextView>(R.id.RoomText)
            roomText.text = "영양제를 선택해주세요."

            val adapter = NutritionListAdapter(this, nutritionList)
            NutritionRecyclerview.adapter = adapter
        }
        val lay = LinearLayoutManager(this)
        NutritionRecyclerview.layoutManager = lay
        NutritionRecyclerview.setHasFixedSize(true)
    }
}

class NutritionListAdapter(val context: Context, val itemList : ArrayList<HospitalContacts>) :
    RecyclerView.Adapter<NutritionListAdapter.Holder>() {
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val itemname = itemView?.findViewById<TextView>(R.id.itemname)
        val price = itemView?.findViewById<TextView>(R.id.price)
        val buybutton = itemView?.findViewById<Button>(R.id.buybutton)
        val effects = itemView?.findViewById<TextView>(R.id.effects)

        fun bind(item: HospitalContacts, context: Context) {
            itemname?.text = item.name
            price?.text = item.price.toString()
            buybutton?.text = item.buy
            effects?.text = item.effects
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.activity_hospital_contacts, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(itemList[position], context)
    }
}