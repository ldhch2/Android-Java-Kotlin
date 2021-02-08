package com.example.midtwenties

import ContactsListAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_store_layout.*

class BowlStore : AppCompatActivity() {

    var contactsList = arrayListOf<StoreContacts>(
            StoreContacts("","그릇 세트",500,"구매","빨강색","파란색",""),
            StoreContacts("","밥그릇",500,"구매","빨강색","파란색","초록색"),
            StoreContacts("","물그릇",500,"구매","빨강색","파란색","초록색"),
            StoreContacts("","공공공",500,"구매","빨강색","파란색","초록색"),
            StoreContacts("","룰룰루",500,"구매","빨강색","파란색","초록색")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_layout)

        val storeType = findViewById<TextView>(R.id.StoreType)
        storeType.text = "밥그릇/물그릇"

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