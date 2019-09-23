package com.example.mindork.util

import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import androidx.core.graphics.drawable.toDrawable
import com.example.mindork.R

object CommonUtil {

    fun showLoadingDialog(context: Context): ProgressDialog = ProgressDialog(context).let {
            it.show()
            it.window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            it.setContentView(R.layout.progress_dialog)
            it.isIndeterminate =true
            it.setCancelable(false)
            it.setCanceledOnTouchOutside(false)
        return it
        }

}