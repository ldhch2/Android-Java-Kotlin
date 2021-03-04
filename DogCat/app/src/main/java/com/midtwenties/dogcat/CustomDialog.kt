package com.midtwenties.dogcat


import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView

class CustomDialog(context: Context) {
    private val dialog = Dialog(context)
    fun userDig(){
        UserDig()
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
            val name=myName.text.toString()
            /* 이름 어떻게 저장할거지?

            */
            dialog.dismiss()

        }

        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)
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


}

