package com.example.midtwenties

import ContactsListAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_store_layout.*

class FeedStore : AppCompatActivity() {

    var contactsList = arrayListOf<StoreContacts>(
            StoreContacts("","강아지 사료",10000,"구매","1kg","3kg","5kg"),
            StoreContacts("","고양이 사료",10000,"구매","1kg","3kg","5kg"),
            StoreContacts("","뼈다귀(강아지용)",500,"구매","","",""),
            StoreContacts("","참치(고양이용)",500,"구매","","",""),
            StoreContacts("","룰룰루",500,"구매","","","")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_layout)

        val storeType = findViewById<TextView>(R.id.StoreType)
        storeType.text = "사료/간식"

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