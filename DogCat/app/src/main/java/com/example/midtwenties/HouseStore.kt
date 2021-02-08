package com.example.midtwenties

import ContactsListAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_store_layout.*

class HouseStore : AppCompatActivity() {

    var contactsList = arrayListOf<StoreContacts>(
            StoreContacts("redhouse","Red 심플 홈",500,"구매","소형","중형","대형"),
            StoreContacts("bluehouse","Blue 심플 홈",500,"구매","소형","중형","대형"),
            StoreContacts("yellowhouse","Yellow 심플 홈",500,"구매","소형","중형","대형"),
            StoreContacts("","캣타워",500,"구매","빨강색","파란색","초록색"),
            StoreContacts("","룰룰루",500,"구매","빨강색","파란색","초록색")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_layout)

        val storeType = findViewById<TextView>(R.id.StoreType)
        storeType.text = "집"

        back.setOnClickListener{
            startActivity(Intent(this,MyStore::class.java))
        }

        val adapter = ContactsListAdapter(this, contactsList)
        StoreRecyclerview.adapter = adapter

        val lay = LinearLayoutManager(this)
        StoreRecyclerview.layoutManager = lay
        StoreRecyclerview.setHasFixedSize(true)
    }
}