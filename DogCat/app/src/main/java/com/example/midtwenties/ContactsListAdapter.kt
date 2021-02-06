package com.example.midtwenties

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.storecontacts.view.*
import com.example.midtwenties.StoreContacts
import com.example.midtwenties.R
import com.example.midtwenties.StoreItem

class ContactsListAdapter(val context: Context, val itemList : ArrayList<StoreContacts>) :
    RecyclerView.Adapter<ContactsListAdapter.Holder>()  {
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!){
        val imagename = itemView?.findViewById<ImageView>(R.id.imagename)
        val itemname = itemView?.findViewById<TextView>(R.id.itemname)
        val price = itemView?.findViewById<TextView>(R.id.price)
        val buybutton = itemView?.findViewById<Button>(R.id.buybutton)
        val option1 = itemView?.findViewById<RadioButton>(R.id.option1)
        val option2 = itemView?.findViewById<RadioButton>(R.id.option2)
        val option3 = itemView?.findViewById<RadioButton>(R.id.option3)


        fun bind(item: StoreContacts, context: Context) {
         //   imagename?.srcCompat = item.imagename
            itemname?.text = item.name
            price?.text = item.price.toString()
            buybutton?.text=item.buy
            option1?.text = item.option1
            option2?.text = item.option2
            option3?.text=item.option3
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.storecontacts, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(itemList[position],context)
    }

}