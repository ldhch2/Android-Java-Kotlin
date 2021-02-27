package com.midtwenties.dogcat

import IDAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_id_list.*

class IDListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_id_list)

        val filename=loadFromInnerStorage("pet.txt")
        val temp=filename.split('\n')
        val pet= PetClass(loadFromInnerStorage(temp[0]))

        var idList = arrayListOf<Id>(
            Id(pet.card, pet.name)
        )

        val idAdapter=IDAdapter(this, idList)
        idRecyclerView.adapter = idAdapter

        /*
        val lm = LinearLayoutManager(this)
        idRecyclerView.layoutManager = lm
        idRecyclerView.setHasFixedSize(true)
        */

        val gridLayoutManager = GridLayoutManager(applicationContext,2)
        idRecyclerView.layoutManager = gridLayoutManager

        backButton.setOnClickListener{
            onBackPressed()
        }
    }

    fun loadFromInnerStorage(filename: String):String{
        val fileInputStream=openFileInput(filename)
        return fileInputStream.reader().readText()
    }


}