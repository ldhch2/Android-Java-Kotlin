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
    Iteminfo("공"),
    Iteminfo("오뚝이"),
    Iteminfo("터그"),
    Iteminfo("낚시대"),
    Iteminfo("인형")
)
var houseList = arrayListOf<Iteminfo>(
    Iteminfo("기본 쿠션"),
    Iteminfo("Pink 베이직 홈"),
    Iteminfo("Blue 베이직 홈"),
    Iteminfo("Brown 베이직 홈"),
    Iteminfo("프린세스 홈"),
    Iteminfo("Premium 캣타워")
)
var householdList = arrayListOf<Iteminfo>(
    Iteminfo("멍샴푸"),
    Iteminfo("냥삼푸"),
    Iteminfo("칫솔"),
    Iteminfo("치약"),
    Iteminfo("배변패드")
)
var feedList = arrayListOf<Iteminfo>(
    Iteminfo("강아지 사료"),
    Iteminfo("고양이 사료"),
    Iteminfo("Premium 강아지 사료"),
    Iteminfo("Premium 고양이 사료"),
    Iteminfo("개껌 (강아지용)"),
    Iteminfo("닭가슴살 츄르 (고양이용)"),
    Iteminfo("연어 츄르 (고양이용)"),
    Iteminfo("참치 츄르 (고양이용)")
)
var clothesList = arrayListOf<Iteminfo>(
    Iteminfo("목줄"),
    Iteminfo("심플 옷"),
    Iteminfo("옷옷")
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

