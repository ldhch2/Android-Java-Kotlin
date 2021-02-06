package com.example.midtwenties

import ContactsListAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bowl_store.*


class StoreItem : AppCompatActivity() {

    var contactsList = arrayListOf<StoreContacts>(
            StoreContacts("aa","공",500,"구매","빨강색","파란색","초록색"),
            StoreContacts("aa","삑삑이",500,"구매","빨강색","파란색","초록색"),
            StoreContacts("aa","뽁뽁이",500,"구매","빨강색","파란색","초록색")

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bowl_store)

        val adapter = ContactsListAdapter(this, contactsList)
        BowlRecyclerview.adapter = adapter

    }
}