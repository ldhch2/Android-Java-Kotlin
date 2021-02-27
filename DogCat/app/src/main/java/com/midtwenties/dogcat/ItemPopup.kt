package com.midtwenties.dogcat

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_item_popup.*

class Itemnew (var item_name: String, var image_name : String)

class ItemPopup : AppCompatActivity() {
    var itemToylist = arrayListOf<Itemnew>(
            Itemnew("공", ""),
            Itemnew("삑삑이", ""),
            Itemnew("오메가3", ""),
            Itemnew("밀크시슬", ""),
            Itemnew("글루코사민", "")
    )

    var itemHouselist = arrayListOf<Itemnew>(
            Itemnew("캣타워","cattowerpre"),
            Itemnew("기본 쿠션","freecushion")
    )

    var itemBowllist = arrayListOf<Itemnew>(
            Itemnew("그릇 세트",""),
            Itemnew("밥그릇","")
    )

    var itemFeedlist = arrayListOf<Itemnew>(
            Itemnew("강아지 사료","dogyum"),
            Itemnew("고양이 사료","catyum")
    )
    var itemClotheslist = arrayListOf<Itemnew>(
            Itemnew("심플 옷",""),
            Itemnew("목줄","")
    )


    fun loadFromInnerStorage(filename: String): String {
        val fileInputStream = openFileInput(filename)
        return fileInputStream.reader().readText()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_popup)

        var type = intent.getIntExtra("ItemType", 0)

        if(type == 1){
            val adapter = ItemNewListAdapter(this, itemToylist)
            SeparateRecyclerView.adapter = adapter

        }
        else if(type == 2){
            val adapter = ItemNewListAdapter(this, itemFeedlist)
            SeparateRecyclerView.adapter = adapter

        }
        else if(type == 3){
            val adapter = ItemNewListAdapter(this, itemBowllist)
            SeparateRecyclerView.adapter = adapter

        }

        backButton.setOnClickListener {
            onBackPressed()
        }
        val gridLayoutManager = GridLayoutManager(applicationContext,3)
        SeparateRecyclerView.layoutManager = gridLayoutManager

    }
}

class ItemNewListAdapter(val context: Context, val itemList : ArrayList<Itemnew>) :
        RecyclerView.Adapter<ItemNewListAdapter.Holder>() {
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val itemname = itemView?.findViewById<TextView>(R.id.itemlistname)
        val imagename = itemView?.findViewById<ImageButton>(R.id.imagename)

        fun bind(item2: Itemnew, context: Context) {
            itemname?.text = item2.item_name
            if (item2.image_name != "") {
                val resourceId = context.resources.getIdentifier(item2.image_name, "drawable", context.packageName)
                imagename?.setImageResource(resourceId)
            } else {
                imagename?.setImageResource(R.mipmap.ic_launcher)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view =
                LayoutInflater.from(context).inflate(R.layout.activity_item_contacts, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(itemList[position], context)
    }
}