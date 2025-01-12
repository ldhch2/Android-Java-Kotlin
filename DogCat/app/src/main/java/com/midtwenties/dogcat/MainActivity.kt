package com.midtwenties.dogcat

import StateAdapter
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    var isOpen = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fillButton.visibility = View.INVISIBLE
        fillAnimation.visibility = View.INVISIBLE

        supportFragmentManager.beginTransaction()
            .replace(R.id.coin, CoinView())
            .commit()

        val filename=loadFromInnerStorage("pet.txt")
        val temp=filename.split('\n')
        val pet= PetClass(loadFromInnerStorage(temp[0]))
        val fillAnimation: ImageView = findViewById(R.id.fillAnimation)
        Glide.with(this).load(R.raw.fillbowl2).into(fillAnimation)


        var stateList = arrayListOf<State>(
                State("배고파요", "배불러요", pet.state.full),
                State("찝찝해요", "개운해요", pet.state.clean),
                State("지루해요", "신나요", pet.state.excited),
                State("졸려요", "상쾌해요", pet.state.awake),
                State("슬퍼요", "행복해요", pet.state.happy),
                State("아파요", "건강해요", pet.state.healthy),
                State("불안해요", "편안해요", pet.state.relaxed)
        )

        val stateAdapter=StateAdapter(this, stateList)
        stateRecyclerView.adapter = stateAdapter

        val lm = LinearLayoutManager(this)
        stateRecyclerView.layoutManager = lm
        stateRecyclerView.setHasFixedSize(true)

        val fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open)
        val fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close)

        /*var newtype = intent.getStringExtra("imagepara")


        if(newtype != null) {
            Toast.makeText(this, "사진사진사진.", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, newtype, Toast.LENGTH_SHORT).show()
            val resourceId = resources.getIdentifier(newtype, "drawable", this.packageName)
            fillAnimation?.setImageResource(resourceId)
            fillAnimation.visibility = View.VISIBLE
        }*/

        playplay.setOnClickListener{
            val intent = Intent(this, ItemPopup::class.java)
            intent.putExtra("ItemType", "1".toInt())
            startActivity(intent)
        }

        feedfeed.setOnClickListener{
            val intent = Intent(this, ItemPopup::class.java)
            intent.putExtra("ItemType", "2".toInt())
            startActivityForResult(intent, 100)
        }

        fillButton.setOnClickListener{
            fillAnimation.visibility = View.VISIBLE
            fillButton.visibility = View.INVISIBLE
            //f
        }

        washwash.setOnClickListener{
            val intent = Intent(this, ItemPopup::class.java)
            intent.putExtra("ItemType", "3".toInt())
            startActivity(intent)
        }

        stateButton.setOnClickListener{
            drawerState.openDrawer(GravityCompat.START)
        }

        backButton.setOnClickListener(){
            onBackPressed()
        }

        hangoutButton.setOnClickListener() {
            startActivity(Intent(this,HangoutPopup::class.java))
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                100 -> {
                    val bowlflag = data!!.getIntExtra("bowlFlag", 0)
                    if(bowlflag == 1){
                        fillButton.visibility = View.VISIBLE
                    }
                }
            }
        }

        /*
        if(resultCode == RESULT_OK) {
            val bowlflag = intent.getIntExtra("bowlFlag", 0)
            if(bowlflag == 1){
                fillButton.visibility = View.VISIBLE
            }
        }

         */


    }

    fun loadFromInnerStorage(filename: String):String{
        val fileInputStream=openFileInput(filename)
        return fileInputStream.reader().readText()
    }

}