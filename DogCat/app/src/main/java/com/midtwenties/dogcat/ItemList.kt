package com.midtwenties.dogcat

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_item_list.*

class ItemContacts (var item_name: String, var image_name : String)

class ItemList : AppCompatActivity() {
    var itemToylist = arrayListOf<ItemContacts>(
            ItemContacts("공", ""),
            ItemContacts("삑삑이", ""),
            ItemContacts("오메가3", ""),
            ItemContacts("밀크시슬", ""),
            ItemContacts("글루코사민", "")
    )

    var itemHouselist = arrayListOf<ItemContacts>(
            ItemContacts("캣타워","cattowerpre"),
            ItemContacts("기본 쿠션","freecushion")
    )

    var itemBowllist = arrayListOf<ItemContacts>(
            ItemContacts("그릇 세트",""),
            ItemContacts("밥그릇","")
    )

    var itemFeedlist = arrayListOf<ItemContacts>(
            ItemContacts("강아지 사료","dogyum"),
            ItemContacts("고양이 사료","catyum")
    )
    var itemClotheslist = arrayListOf<ItemContacts>(
            ItemContacts("심플 옷",""),
            ItemContacts("목줄","")
    )

    fun reset(){
        Toy.isSelected = false
        Toy.setBackgroundResource(R.drawable.beige_button)
        House.isSelected=false
        House.setBackgroundResource(R.drawable.beige_button)
        Bowl.isSelected=false
        Bowl.setBackgroundResource(R.drawable.beige_button)
        Feed.isSelected=false
        Feed.setBackgroundResource(R.drawable.beige_button)
        Cloth.isSelected=false
        Cloth.setBackgroundResource(R.drawable.beige_button)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)




        Toy.setBackgroundResource(R.drawable.brown_button)
        val adapter = ItemListAdapter(this, itemToylist)
        itemRecyclerView.adapter = adapter
        Toy.isSelected=true


        backButton.setOnClickListener {
            onBackPressed()
        }
        Toy.setOnClickListener{
            reset()
            Toy.setBackgroundResource(R.drawable.brown_button)
            val adapter = ItemListAdapter(this, itemToylist)
            itemRecyclerView.adapter = adapter
            Toy.isSelected=true
        }

        House.setOnClickListener {
            reset()
            House.setBackgroundResource(R.drawable.brown_button)
            val adapter = ItemListAdapter(this, itemHouselist)
            itemRecyclerView.adapter = adapter
            House.isSelected=true
        }
        Bowl.setOnClickListener {
            reset()
            Bowl.setBackgroundResource(R.drawable.brown_button)
            val adapter = ItemListAdapter(this, itemBowllist)
            itemRecyclerView.adapter = adapter
            Bowl.isSelected=true
        }
        Feed.setOnClickListener {
            reset()
            Feed.setBackgroundResource(R.drawable.brown_button)
            val adapter = ItemListAdapter(this, itemFeedlist)
            itemRecyclerView.adapter = adapter
            Feed.isSelected=true
        }
        Cloth.setOnClickListener {
            reset()
            Cloth.setBackgroundResource(R.drawable.brown_button)
            val adapter = ItemListAdapter(this, itemClotheslist)
            itemRecyclerView.adapter = adapter
            Cloth.isSelected=true
        }
      //  val lay = LinearLayoutManager(this)
      //  itemRecyclerView.layoutManager = lay
      //  itemRecyclerView.setHasFixedSize(true)

        val gridLayoutManager = GridLayoutManager(applicationContext,3)
        itemRecyclerView.layoutManager = gridLayoutManager
    }
}

class ItemListAdapter(val context: Context, val itemList : ArrayList<ItemContacts>) :
        RecyclerView.Adapter<ItemListAdapter.Holder>() {
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val itemname = itemView?.findViewById<TextView>(R.id.itemlistname)
        val imagename = itemView?.findViewById<ImageView>(R.id.itemimage)

        fun bind(item2: ItemContacts, context: Context) {
            itemname?.text = item2.item_name
            if(item2.image_name != ""){
                val resourceId = context.resources.getIdentifier(item2.image_name,"drawable",context.packageName)
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