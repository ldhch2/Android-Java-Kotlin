import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.midtwenties.dogcat.Iteminfo
import com.midtwenties.dogcat.StoreContacts
import com.midtwenties.dogcat.R

class ContactsListAdapter(val context: Context, val itemList : ArrayList<Iteminfo>) :
    RecyclerView.Adapter<ContactsListAdapter.Holder>()  {
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!){
        val imagename = itemView?.findViewById<ImageView>(R.id.imagename)
        val itemname = itemView?.findViewById<TextView>(R.id.itemname)
        val price = itemView?.findViewById<TextView>(R.id.option1_price)
        val buybutton = itemView?.findViewById<Button>(R.id.buybutton)
        val option1 = itemView?.findViewById<RadioButton>(R.id.option1)
        val option2 = itemView?.findViewById<RadioButton>(R.id.option2)
        val option3 = itemView?.findViewById<RadioButton>(R.id.option3)

        fun bind(item: Iteminfo, context: Context) {

            if(item.imagename != ""){
                val resourceId = context.resources.getIdentifier(item.imagename,"drawable",context.packageName)
                imagename?.setImageResource(resourceId)
            } else {
                imagename?.setImageResource(R.mipmap.ic_launcher)
            }
            itemname?.text = item.name
            price?.text = item.price.toString()
            buybutton?.text="구매"

            if(item.option1 != "") option1?.text = item.option1
            else option1?.setVisibility(View.INVISIBLE)

            if(item.option2 != "") option2?.text = item.option2
            else option2?.setVisibility(View.INVISIBLE)

            if(item.option3 != "") option3?.text = item.option3
            else option3?.setVisibility(View.INVISIBLE)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_store_contacts, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(itemList[position],context)
    }

}