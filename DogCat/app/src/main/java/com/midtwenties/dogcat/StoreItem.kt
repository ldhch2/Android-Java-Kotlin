package com.midtwenties.dogcat

import ContactsListAdapter
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_store_item.*

class StoreItem : AppCompatActivity() {

    var toyList = arrayListOf<StoreContacts>(
            StoreContacts("", "공", 500, "구매", "빨강색", "파란색", ""),
            StoreContacts("", "삑삑이", 500, "구매", "빨강색", "파란색", "초록색"),
            StoreContacts("", "뽁뽁이", 500, "구매", "빨강색", "파란색", "초록색"),
            StoreContacts("", "공공공", 500, "구매", "빨강색", "파란색", "초록색"),
            StoreContacts("", "룰룰루", 500, "구매", "빨강색", "파란색", "초록색")
    )
    var houseList = arrayListOf<StoreContacts>(
            StoreContacts("redhouse", "Red 심플 홈", 500, "구매", "소형", "중형", "대형"),
            StoreContacts("bluehouse", "Blue 심플 홈", 500, "구매", "소형", "중형", "대형"),
            StoreContacts("yellowhouse", "Yellow 심플 홈", 500, "구매", "소형", "중형", "대형"),
            StoreContacts("", "캣타워", 500, "구매", "빨강색", "파란색", "초록색"),
            StoreContacts("", "룰룰루", 500, "구매", "빨강색", "파란색", "초록색")
    )
    var bowlList = arrayListOf<StoreContacts>(
            StoreContacts("", "그릇 세트", 500, "구매", "빨강색", "파란색", ""),
            StoreContacts("", "밥그릇", 500, "구매", "빨강색", "파란색", "초록색"),
            StoreContacts("", "물그릇", 500, "구매", "빨강색", "파란색", "초록색"),
            StoreContacts("", "밥밥", 500, "구매", "빨강색", "파란색", "초록색"),
            StoreContacts("", "물물", 500, "구매", "빨강색", "파란색", "초록색")
    )
    var feedList = arrayListOf<StoreContacts>(
            StoreContacts("", "강아지 사료", 10000, "구매", "1kg", "3kg", "5kg"),
            StoreContacts("", "고양이 사료", 10000, "구매", "1kg", "3kg", "5kg"),
            StoreContacts("", "뼈다귀(강아지용)", 500, "구매", "", "", ""),
            StoreContacts("", "참치(고양이용)", 500, "구매", "", "", "")
    )
    var clothesList = arrayListOf<StoreContacts>(
            StoreContacts("", "심플 옷", 500, "구매", "빨강색", "파란색", ""),
            StoreContacts("", "목줄", 500, "구매", "빨강색", "파란색", "초록색"),
            StoreContacts("", "옷옷", 500, "구매", "빨강색", "파란색", "초록색")
    )
    fun reset() {
        goToyStore.setBackgroundColor(Color.parseColor("#00FF0000"))
        goHouseStore.setBackgroundColor(Color.parseColor("#00FF0000"))
        goBowlStore.setBackgroundColor(Color.parseColor("#00FF0000"))
        goFeedStore.setBackgroundColor(Color.parseColor("#00FF0000"))
        goClothesStore.setBackgroundColor(Color.parseColor("#00FF0000"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_item)

        val storeType = findViewById<TextView>(R.id.StoreType)
        storeType.text = "상점"

        back.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
        goToyStore.setOnClickListener{
            reset()
            val adapter = ContactsListAdapter(this, toyList)
            StoreRecyclerview.adapter = adapter
            goToyStore.setBackgroundColor(Color.parseColor("#22741C"))
        }
        goHouseStore.setOnClickListener{
            reset()
            val adapter = ContactsListAdapter(this, houseList)
            StoreRecyclerview.adapter = adapter
            goHouseStore.setBackgroundColor(Color.parseColor("#22741C"))
        }
        goBowlStore.setOnClickListener{
            reset()
            val adapter = ContactsListAdapter(this, bowlList)
            StoreRecyclerview.adapter = adapter
            goBowlStore.setBackgroundColor(Color.parseColor("#22741C"))
        }
        goFeedStore.setOnClickListener{
            reset()
            val adapter = ContactsListAdapter(this, feedList)
            StoreRecyclerview.adapter = adapter
            goFeedStore.setBackgroundColor(Color.parseColor("#22741C"))
        }
        goClothesStore.setOnClickListener{
            reset()
            val adapter = ContactsListAdapter(this, clothesList)
            StoreRecyclerview.adapter = adapter
            goClothesStore.setBackgroundColor(Color.parseColor("#22741C"))
        }

        val lay = LinearLayoutManager(this)
        StoreRecyclerview.layoutManager = lay
        StoreRecyclerview.setHasFixedSize(true)
    }
}

