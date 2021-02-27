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
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_item_list.*

class ItemList : AppCompatActivity() {

    var itemToylist = arrayListOf<Iteminfo>(
    )
    var itemHouselist = arrayListOf<Iteminfo>(
    )

    var itemHouseholdllist = arrayListOf<Iteminfo>(
    )
    var itemFeedlist = arrayListOf<Iteminfo>(
    )
    var itemClotheslist = arrayListOf<Iteminfo>(
    )

    val prefernce by lazy { getSharedPreferences("setting_data",Context.MODE_PRIVATE) }
    var num=0

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

        val toy = prefernce.getString("toy",null)?.split(" ")
        if (toy != null) {
            for (i in 0..toy.size) {
                itemToylist.add(Iteminfo(toy[i]))
            }
        }

        val house = prefernce.getString("house",null)?.split(" ")
        if (house != null) {
            for (i in 0..house.size) {
                itemHouselist.add(Iteminfo(house[i]))
            }
        }

        val household = prefernce.getString("household",null)?.split(" ")
        if (household != null) {
            for (i in 0..household.size) {
                itemHouseholdllist.add(Iteminfo(household[i]))
            }
        }

        val feed = prefernce.getString("feed",null)?.split(" ")
        if (feed != null) {
                for (i in 0..feed.size) {
                    itemFeedlist.add(Iteminfo(feed[i]))
            }
        }

        val cloth = prefernce.getString("cloth",null)?.split(" ")
        if (cloth != null) {
            for (i in 1..cloth.size) {
                itemClotheslist.add(Iteminfo(cloth[i]))
            }
        }

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
            val adapter = ItemListAdapter(this, itemHouseholdllist)
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

class ItemListAdapter(val context: Context, val itemList : ArrayList<Iteminfo>) :
        RecyclerView.Adapter<ItemListAdapter.Holder>() {
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val itemname = itemView?.findViewById<TextView>(R.id.itemlistname)
        val imagename = itemView?.findViewById<ImageView>(R.id.itemimage2)

        fun bind(item2: Iteminfo, context: Context) {
            itemname?.text = item2.name
            if(item2.imagename != ""){
                val resourceId = context.resources.getIdentifier(item2.imagename,"drawable",context.packageName)
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
        holder.bind(itemList[position], context)
    }
}