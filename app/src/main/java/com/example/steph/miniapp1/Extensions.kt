package com.example.steph.miniapp1

import android.widget.TextView
import java.text.DecimalFormat

internal fun TextView.showConversion(nSpeed: Double, fSize: Double)
{
    val precision = DecimalFormat("0.0")
    val transferTime = fSize/nSpeed
    text = precision.format(transferTime).toString()
}