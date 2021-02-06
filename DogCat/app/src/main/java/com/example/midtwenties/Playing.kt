package com.example.midtwenties

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_playing.*
import java.nio.file.Files.list

class Playing : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playing)

       playingpet.setOnClickListener{
            Toast.makeText(this,"선택",Toast.LENGTH_SHORT).show()
            Glide.with(this).load(R.raw.tailmoving).into(playingpet)

        }

        val list = findViewById<ListView>(R.id.list)

        list.adapter = MyCustomAdapter(this)

        val apater = ArrayAdapter(this, android.R.layout.list,arrayOfList)

        list.onItemClickListener = AdapterView.OnItemClickListener{ parent,view,position,id ->
            val selectItem = parent.getItemAtPosition(position) as String
            selectName.text = selectItem

        }
    }

    private class MyCustomAdapter(context: Context) : BaseAdapter(){
        private val mContext: Context
        private val names = arrayListOf<String>(
                "A","B","C"
        )

        init {
            mContext = context
        }
        override fun getCount(): Int{
            return names.size
        }

        override fun getItemId(posision: Int): Long{
            return position.toLong()
        }
        override fun getItem(position: Int): Any{
            val selectItem = names.get(position)
            return selectItem
        }
        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?):View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.activity_playing.viewGroup,false)


        }

    }
}