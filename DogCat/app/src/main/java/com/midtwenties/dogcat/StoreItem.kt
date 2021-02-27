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
            StoreContacts("freecushion", "기본 쿠션", 0, "구매", "소형", "중형", "대형"),
            StoreContacts("pinkbasichouse", "Pink 베이직 홈", 500, "구매", "소형", "중형", "대형"),
            StoreContacts("bluebasichouse", "Blue 베이직 홈", 500, "구매", "소형", "중형", "대형"),
            StoreContacts("brownbasichouse", "Brown 베이직 홈", 500, "구매", "소형", "중형", "대형"),
            StoreContacts("princesshouse", "프린세스 홈", 1000, "구매", "빨강색", "파란색", "초록색"),
            StoreContacts("cattowerpre", "[Premium] 캣타워", 2000, "구매", "빨강색", "파란색", "초록색")
    )
    var householdList = arrayListOf<StoreContacts>(
            StoreContacts("", "개샴푸", 500, "구매", "빨강색", "파란색", ""),
            StoreContacts("", "고양이샴푸", 500, "구매", "빨강색", "파란색", "초록색"),
            StoreContacts("", "칫솔", 500, "구매", "빨강색", "파란색", "초록색"),
            StoreContacts("", "치약", 500, "구매", "빨강색", "파란색", "초록색"),
            StoreContacts("", "배변패드", 500, "구매", "빨강색", "파란색", "초록색")
    )
    var feedList = arrayListOf<StoreContacts>(
            StoreContacts("dogyum", "강아지 사료", 10000, "구매", "1kg", "3kg", "5kg"),
            StoreContacts("catyum", "고양이 사료", 10000, "구매", "1kg", "3kg", "5kg"),
            StoreContacts("dogyumpre", "[Premium] 강아지 사료", 15000, "구매", "1kg", "3kg", "5kg"),
            StoreContacts("catyumpre", "[Premium] 고양이 사료", 15000, "구매", "1kg", "3kg", "5kg"),
            StoreContacts("doggum", "개껌 (강아지용)", 500, "구매", "", "", ""),
            StoreContacts("yellowchu", "닭가슴살 츄르 (고양이용)", 500, "구매", "", "", ""),
            StoreContacts("orangechu", "연어 츄르 (고양이용)", 500, "구매", "", "", ""),
            StoreContacts("pinkchu", "참치 츄르 (고양이용)", 500, "구매", "", "", "")
    )
    var clothesList = arrayListOf<StoreContacts>(
            StoreContacts("", "목줄", 500, "구매", "빨강색", "파란색", ""),
            StoreContacts("", "심플 옷", 500, "구매", "빨강색", "파란색", "초록색"),
            StoreContacts("", "옷옷", 500, "구매", "빨강색", "파란색", "초록색")
    )
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

