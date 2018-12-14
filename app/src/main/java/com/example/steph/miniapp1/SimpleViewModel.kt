package com.example.steph.miniapp1

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.util.Log


class SimpleViewModel : ViewModel() {
    val networkSpeed = ObservableField<String>("84.0")
    val fileSize = ObservableField<String>("84.0")
    val transferSpeed = ObservableField<String>()

    fun calculateTransferSpeed() {
        /*val nSpeed = networkSpeed.get() * (Math.pow(10.0, 6.0))
        val fSize = fileSize.get() * (Math.pow(2.0, 20.0) * 8)*/
        Log.i("SimpleVM", networkSpeed.get())
        Log.i("SimpleVM", fileSize.get())
        /*transferSpeed.set(nSpeed/fSize)    // perform conversion*/
    }
}