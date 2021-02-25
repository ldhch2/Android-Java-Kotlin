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
import kotlinx.android.synthetic.main.activity_hospital_nutrition.*

class NutritionContacts (var name: String, var price: Int, var buy : String, var effects : String)

class HospitalNutrition : AppCompatActivity() {
    var nutritionList = arrayListOf<NutritionContacts>(
        NutritionContacts("종합비타민", 100, "구매", "효능"),
        NutritionContacts("유산균", 200, "구매", "효능 어쩌구저쩌구"),
        NutritionContacts("오메가3", 50, "구매", "오메가33"),
        NutritionContacts("밀크시슬", 100, "구매", "간 기능 개선"),
        NutritionContacts("글루코사민", 200, "구매", "관절 기능 개선")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_nutrition)

        back.setOnClickListener {
            onBackPressed()
        }

        val adapter = NutritionListAdapter(this, nutritionList)
        NutritionRecyclerview.adapter = adapter

        val lay = LinearLayoutManager(this)
        NutritionRecyclerview.layoutManager = lay
        NutritionRecyclerview.setHasFixedSize(true)
    }
}

class NutritionListAdapter(val context: Context, val itemList : ArrayList<NutritionContacts>) :
    RecyclerView.Adapter<NutritionListAdapter.Holder>() {
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val itemname = itemView?.findViewById<TextView>(R.id.itemname)
        val price = itemView?.findViewById<TextView>(R.id.price)
        val buybutton = itemView?.findViewById<Button>(R.id.buybutton)
        val effects = itemView?.findViewById<TextView>(R.id.effects)

        fun bind(item: NutritionContacts, context: Context) {
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
            LayoutInflater.from(context).inflate(R.layout.activity_nutrition_contacts, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(itemList[position], context)
    }
}