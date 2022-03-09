package com.zj.pickertest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.bigkoo.pickerview.builder.TimePickerBuilder
import com.bigkoo.pickerview.listener.OnTimeSelectListener
import com.bigkoo.pickerview.view.TimePickerView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun initTimePicker(v: View) {
        initTimePicker(v.context) { date, _ ->
            Log.e("------", "$date")
        }.show()
    }

    private fun initTimePicker(context: Context, listener: OnTimeSelectListener): TimePickerView {
        val pvTime = TimePickerBuilder(context, listener).setType(booleanArrayOf(false, true, true, true, true, false)).setRangDate(Calendar.getInstance(), getEndDate()).setDate(getEndDate()).build()
        if (pvTime != null) {
            val mDialog = pvTime.dialog
            if (mDialog != null) {
                val params = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM)
                params.leftMargin = 0
                params.rightMargin = 0
                pvTime.dialogContainerLayout.layoutParams = params
                mDialog.window?.setGravity(Gravity.BOTTOM)
            }
        }
        return pvTime
    }

    private fun getEndDate(): Calendar {
        val date = Calendar.getInstance()
        val endTime = date.timeInMillis + 6 * 30 * 24 * 60 * 60 * 1000L
        date.timeInMillis = endTime
        return date
    }
}