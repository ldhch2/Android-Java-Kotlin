package com.example.midtwenties

import ContactsListAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_store_layout.*

class ToyStore : AppCompatActivity() {

    var contactsList = arrayListOf<StoreContacts>(
            StoreContacts("","공",500,"구매","빨강색","파란색",""),
            StoreContacts("","삑삑이",500,"구매","빨강색","파란색","초록색"),
            StoreContacts("","뽁뽁이",500,"구매","빨강색","파란색","초록색"),
            StoreContacts("","공공공",500,"구매","빨강색","파란색","초록색"),
            StoreContacts("","룰룰루",500,"구매","빨강색","파란색","초록색")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_layout)

        val storeType = findViewById<TextView>(R.id.StoreType)
        storeType.text = "장난감"

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