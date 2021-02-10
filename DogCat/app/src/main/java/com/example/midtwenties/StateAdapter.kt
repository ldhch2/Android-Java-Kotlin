import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
<<<<<<< Updated upstream
import androidx.core.widget.ContentLoadingProgressBar
=======
import androidx.core.view.isVisible
>>>>>>> Stashed changes
import androidx.recyclerview.widget.RecyclerView
import com.example.midtwenties.PetState
import com.example.midtwenties.R
import com.example.midtwenties.State
import kotlinx.android.synthetic.main.state.*

class StateAdapter(val context:Context, val stateList: ArrayList<State>):
        RecyclerView.Adapter<StateAdapter.Holder>() {
        inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
                val start = itemView?.findViewById<TextView>(R.id.startTv)
                val end = itemView?.findViewById<TextView>(R.id.endTv)
                val degree = itemView?.findViewById<ProgressBar>(R.id.progressBar)
                val bool = itemView?.findViewById<ProgressBar>(R.id.progressBarDanger)

                fun bind (state: State, context: Context) {
                        /* TextView와 String 데이터를 연결한다. */
                        start?.text = state.start
                        end?.text = state.end
                        if(state.degree<20){
                                degree?.isVisible=false
                                bool?.progress=state.degree
                        }
                        else{
                                bool?.isVisible=false
                                degree?.progress=state.degree
                        }
                }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
                val view= LayoutInflater.from(context).inflate(R.layout.state,parent,false)
                return Holder(view)
        }

        override fun getItemCount(): Int {
                return stateList.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
                holder?.bind(stateList[position],context)
        }
}
