import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.midtwenties.Id
import com.example.midtwenties.R

class IDAdapter(val context:Context, val IdList:ArrayList<Id>):
        RecyclerView.Adapter<IDAdapter.Holder>() {
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val image = itemView?.findViewById<ImageView>(R.id.idCard)
        val name = itemView?.findViewById<TextView>(R.id.idName)

        fun bind(id: Id, context: Context) {
            image?.setImageURI(id.imageURI)
            name?.text = id.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.id, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return IdList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(IdList[position], context)
    }
}