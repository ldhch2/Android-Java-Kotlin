package com.midtwenties.dogcat

import ContactsListAdapter
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_store_item.*

var toyList = arrayListOf<Iteminfo>(
    Iteminfo("1_1_0"),
    Iteminfo("1_2_0"),
    Iteminfo("1_3_0"),
    Iteminfo("1_4_0"),
    Iteminfo("1_5_0")
)
var houseList = arrayListOf<Iteminfo>(
    Iteminfo("2_1_0"),
    Iteminfo("2_2_0"),
    Iteminfo("2_3_0"),
    Iteminfo("2_4_0"),
    Iteminfo("2_5_0"),
    Iteminfo("2_6_0")
)
var householdList = arrayListOf<Iteminfo>(
    Iteminfo("3_1_0"),
    Iteminfo("3_2_0"),
    Iteminfo("3_3_0"),
    Iteminfo("3_4_0"),
    Iteminfo("3_5_0")
)
var feedList = arrayListOf<Iteminfo>(
    Iteminfo("4_1_0"),
    Iteminfo("4_2_0"),
    Iteminfo("4_3_0"),
    Iteminfo("4_4_0"),
    Iteminfo("4_5_0"),
    Iteminfo("4_6_0"),
    Iteminfo("4_7_0"),
    Iteminfo("4_8_0")
)
var clothesList = arrayListOf<Iteminfo>(
    Iteminfo("5_1_0"),
    Iteminfo("5_2_0"),
    Iteminfo("5_3_0")
)


class StoreItem : AppCompatActivity() {

    fun reset() {
        goToyStore.isSelected=false
        goHouseStore.isSelected=false
        goHouseholdStore.isSelected=false
        goFeedStore.isSelected=false
        goClothesStore.isSelected=false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_item)

        supportFragmentManager.beginTransaction()
            .replace(R.id.coin, CoinView())
            .commit()

        val storeType = findViewById<TextView>(R.id.StoreType)
        storeType.text = "상점"

        backButton.setOnClickListener{
            onBackPressed()
        }
        goToyStore.setOnClickListener{
            reset()
            val adapter = ContactsListAdapter(this, toyList)
            StoreRecyclerview.adapter = adapter
            goToyStore.isSelected=true
        }
        goHouseStore.setOnClickListener{
            reset()
            val adapter = ContactsListAdapter(this, houseList)
            StoreRecyclerview.adapter = adapter
            goHouseStore.isSelected=true
        }
        goHouseholdStore.setOnClickListener{
            reset()
            val adapter = ContactsListAdapter(this, householdList)
            StoreRecyclerview.adapter = adapter
            goHouseholdStore.isSelected=true
        }
        goFeedStore.setOnClickListener{
            reset()
            val adapter = ContactsListAdapter(this, feedList)
            StoreRecyclerview.adapter = adapter
            goFeedStore.isSelected=true
        }
        goClothesStore.setOnClickListener {
            reset()
            val adapter = ContactsListAdapter(this, clothesList)
            StoreRecyclerview.adapter = adapter
            goClothesStore.isSelected =true
        }

        val lay = LinearLayoutManager(this)
        StoreRecyclerview.layoutManager = lay
        StoreRecyclerview.setHasFixedSize(true)
    }
}

