package com.midtwenties.dogcat


import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.WindowManager
import android.widget.Button
import kotlinx.android.synthetic.main.exit_popup.*

class CustomDialog (context: Context) {
    private val dialog = Dialog(context)

    fun myDig(){
        MyDig()
        dialog.show()
    }

    fun MyDig(){
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

