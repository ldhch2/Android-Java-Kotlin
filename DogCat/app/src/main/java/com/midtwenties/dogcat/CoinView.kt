package com.midtwenties.dogcat

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.coin_view.*

class CoinView : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val test=this.arguments
        var co:Int

        if (test != null) {
            co=test.getInt("money",111)
        }
        else co=3000

        //myCoin.text = 4000.toString()

        return inflater.inflate(R.layout.coin_view, container, false)
    }
}
