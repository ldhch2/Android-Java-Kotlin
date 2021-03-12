package com.midtwenties.dogcat

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CustomDialog(context: Context) : AppCompatActivity() {
    private val dialog = Dialog(context)

    fun userDig(){
        UserDig()
        dialog.show()
    }
    fun UserDig(){
        dialog.setContentView(R.layout.user_popup)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        val tellB = dialog.findViewById<Button>(R.id.tellButton)
        tellB.setOnClickListener{
            val myName = dialog.findViewById<TextView>(R.id.myName)
            onClickedListener.onClicked(myName.text.toString())
            dialog.dismiss()
        }

        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)
    }

    // 병원에서 '구매' 버튼 연결
    fun hospitalDig(name: String, price: String) {
        HospitalDig(name, price)
        dialog.show()
    }
    fun HospitalDig(name : String, price : String) {
        dialog.setContentView(R.layout.hospital_popup)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        val finishB = dialog.findViewById<ImageButton>(R.id.closeclose)
        val buyB = dialog.findViewById<Button>(R.id.buybuy)
        val buyText = dialog.findViewById<TextView>(R.id.buyText)
        val priceText = dialog.findViewById<TextView>(R.id.priceText)

        buyText.setText(name + "을(를) 구매하시겠습니까?")
        priceText.setText("가격 : " + price)

        finishB.setOnClickListener {
            onClickedListener.onClicked("0")
            dialog.dismiss()
        }
        buyB.setOnClickListener {
            onClickedListener.onClicked("1")
            dialog.dismiss()
        }
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
    }

    // 상점에서 '구매' 버튼 연결
    fun storeDig(name: String, price: String, saveInfo : String, storeContext: Context) {
        StoreDig(name, price, saveInfo, storeContext)
        dialog.show()
    }
    fun StoreDig(name: String, price: String, saveInfo: String, storeContext: Context) {
        dialog.setContentView(R.layout.activity_buyitem)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        val finishB = dialog.findViewById<ImageButton>(R.id.StoreBuyClose)
        val buyB = dialog.findViewById<Button>(R.id.StoreBuyBuy)
        val buyText = dialog.findViewById<TextView>(R.id.StoreBuyText)
        val priceText = dialog.findViewById<TextView>(R.id.StorePriceText)

        buyText.setText(name + "을(를) 구매하시겠습니까?")
        priceText.setText("가격 : " + price)

        finishB.setOnClickListener {
            onClickedListener.onClicked("0")
            dialog.dismiss()
        }
        buyB.setOnClickListener {
            val next = Intent(storeContext, SaveStoreInfo::class.java)
            next.putExtra("info", saveInfo)
            storeContext.startService(next)

            onClickedListener.onClicked("1")
            dialog.dismiss()
        }
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
    }

    fun exitDig(){
        ExitDig()
        dialog.show()
    }
    fun ExitDig(){
        dialog.setContentView(R.layout.exit_popup)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)

        val finishB = dialog.findViewById<Button>(R.id.finishButton)
        finishB.setOnClickListener{
            System.exit(0)
        }

        val returnB = dialog.findViewById<Button>(R.id.returnButton)
        returnB.setOnClickListener{
            dialog.dismiss()
        }

        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)

    }

    interface CustomDialogListener{
        fun onClicked(content:String)
    }

    private lateinit var onClickedListener:CustomDialogListener

    fun setOnClickedListener(listener: CustomDialogListener){
        onClickedListener=listener
    }

}

class SaveStoreInfo : AppCompatActivity() {

    val prefernce by lazy { getSharedPreferences("setting_data", Context.MODE_PRIVATE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val save = intent.getStringExtra("info")
        var info = prefernce.getString("item",null)
        if (info == null) info = save
        else info += String.format(" %s",save)
        prefernce.edit().putString("item",info).apply()
    }
}

