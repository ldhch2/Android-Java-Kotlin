package com.midtwenties.dogcat

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class CustomDialog(context: Context) {
    private val dialog = Dialog(context)
    fun userDig(){
        UserDig()
        dialog.show()
    }

    fun hospitalDig(name: String, price: String) {
        HospitalDig(name, price)
        dialog.show()
    }

    fun exitDig(){
        ExitDig()
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
            val send = "0"
            onClickedListener.onClicked(send)
            dialog.dismiss()
        }
        buyB.setOnClickListener {
            val send = "1"
            onClickedListener.onClicked(send)
            dialog.dismiss()
        }
        dialog.setCanceledOnTouchOutside(true)
        dialog.setCancelable(true)
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

