package com.midtwenties.dogcat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_item_contacts.view.*
import kotlinx.android.synthetic.main.activity_item_popup.*
import kotlinx.android.synthetic.main.activity_item_popup.backButton
import kotlinx.android.synthetic.main.activity_main.*

class Itemnew (var item_name: String, var image_name : String)

class ItemPopup : AppCompatActivity() {
    var itemToylist = arrayListOf<Itemnew>(
            Itemnew("공", "doggum"),
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


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_popup)

        var type = intent.getIntExtra("ItemType", 0)

        if(type == 1){
            val text = findViewById<TextView>(R.id.textView2)
            text.text="내 장난감"
            val adapter = ItemNewListAdapter(this, itemToylist)
            SeparateRecyclerView.adapter = adapter

            clickbutton.setOnClickListener {
                if(adapter.flag) {
                    Toast.makeText(this, "선택되었습니다.", Toast.LENGTH_SHORT).show()
                    val newintent = Intent(this, MainActivity::class.java)
                    newintent.putExtra("imagepara",adapter.paraimagename)
                    finish()
                }
                else{
                    Toast.makeText(this,"아이템을 선택해주세요.",Toast.LENGTH_SHORT).show()
                }
            }

        }
        else if(type == 2){
            val text = findViewById<TextView>(R.id.textView2)
            text.text="내 사료"
            val adapter = ItemNewListAdapter(this, itemFeedlist)
            SeparateRecyclerView.adapter = adapter

            clickbutton.setOnClickListener {
                if(adapter.flag) {
                    Toast.makeText(this, "선택되었습니다.", Toast.LENGTH_SHORT).show()
                    val newintent = Intent(this, MainActivity::class.java)
                    newintent.putExtra("imagepara",adapter.paraimagename)
                    finish()
                }
                else{
                    Toast.makeText(this,"아이템을 선택해주세요.",Toast.LENGTH_SHORT).show()
                }
            }

        }
        else if(type == 3){
            val text = findViewById<TextView>(R.id.textView2)
            text.text="내 물건"
            val adapter = ItemNewListAdapter(this, itemBowllist)
            SeparateRecyclerView.adapter = adapter

            clickbutton.setOnClickListener {
                if(adapter.flag) {
                    Toast.makeText(this, "선택되었습니다.", Toast.LENGTH_SHORT).show()
                    val newintent = Intent(this, MainActivity::class.java)
                    newintent.putExtra("imagepara",adapter.paraimagename)
                    finish()
                }
                else{
                    Toast.makeText(this,"아이템을 선택해주세요.",Toast.LENGTH_SHORT).show()
                }
            }
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
    var check = -1
    var preLayout : ConstraintLayout? = null
    var flag = false
    var paraimagename=""
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val itemname = itemView?.findViewById<TextView>(R.id.itemlistname)
        val imagename = itemView?.findViewById<ImageView>(R.id.imagename)
        val itemclick = itemView?.findViewById<Button>(R.id.itemclick)
        val layout = itemView?.findViewById<ConstraintLayout>(R.id.ItemConstraint)

        fun bind(item2: Itemnew, context: Context){
            itemname?.text = item2.item_name
            if (item2.image_name != "") {
                val resourceId = context.resources.getIdentifier(item2.image_name, "drawable", context.packageName)
                imagename?.setImageResource(resourceId)
            } else {
                imagename?.setImageResource(R.mipmap.ic_launcher)
            }
            itemclick?.setOnClickListener {
                if(check == -1){
                    check = itemList.indexOf(item2)
                    preLayout = itemView.ItemConstraint
                    preLayout?.setBackgroundResource(R.drawable.edge)
                    flag = true
                    paraimagename = item2.image_name
                }
                else if(check != itemList.indexOf(item2)){
                    val pre = check
                    check = itemList.indexOf(item2)
                    preLayout?.setBackgroundResource(R.drawable.border_round)
                    preLayout = itemView.ItemConstraint

                    layout?.setBackgroundResource(R.drawable.edge)
                    flag = true
                    paraimagename = item2.image_name
                }
                else {
                    check = -1
                    layout?.setBackgroundResource(R.drawable.border_round)
                    flag = false
                }
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