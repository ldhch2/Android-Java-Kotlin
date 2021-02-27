package com.midtwenties.dogcat

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_id_list.*
import kotlinx.android.synthetic.main.id.view.*

class IDListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_id_list)

        supportFragmentManager.beginTransaction()
            .replace(R.id.coin, CoinView())
            .commit()

        val filename=loadFromInnerStorage("pet.txt")
        val temp=filename.split('\n')
        val pet= PetClass(loadFromInnerStorage(temp[0]))

        var idList = arrayListOf<Id>(
            Id(pet.card, pet.name, false)
        )

        val idAdapter=IDAdapter(this, idList)
        idRecyclerView.adapter = idAdapter

        backButton.setOnClickListener{
           // Toast.makeText(applicationContext, "대표 동물이 설정되었습니다.", Toast.LENGTH_SHORT).show()
            onBackPressed()
        }

        /*
        val lm = LinearLayoutManager(this)
        idRecyclerView.layoutManager = lm
        idRecyclerView.setHasFixedSize(true)
        */

        val gridLayoutManager = GridLayoutManager(applicationContext,2)
        idRecyclerView.layoutManager = gridLayoutManager


    }

    fun loadFromInnerStorage(filename: String):String{
        val fileInputStream=openFileInput(filename)
        return fileInputStream.reader().readText()
    }


}

class IDAdapter(val context: Context, val IdList:ArrayList<Id>):
    RecyclerView.Adapter<IDAdapter.Holder>() {
    var check = -1
    var preLayout : ConstraintLayout? = null
    var idflag = false

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val image = itemView?.findViewById<ImageView>(R.id.idCard)
        val name = itemView?.findViewById<TextView>(R.id.idName)
        val idclick = itemView?.findViewById<Button>(R.id.idClick)
        val layout = itemView?.findViewById<ConstraintLayout>(R.id.IdConstraint)

        fun bind(id: Id, context: Context) {
            image?.setImageURI(id.imageURI)
            name?.text = id.name
            idclick?.isSelected=id.flag
            if(IdList.size==1) {
                preLayout = itemView.IdConstraint
                idclick!!.isSelected = true
                check = IdList.indexOf(id)
            }
            else{
                idclick?.setOnClickListener {
                    if (check != IdList.indexOf(id)) {
                        val pre = check
                        IdList[pre].flag = false
                        check = IdList.indexOf(id)
                        idclick.isSelected = true
                    }
                }
            }
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
        holder.bind(IdList[position], context)
    }
}