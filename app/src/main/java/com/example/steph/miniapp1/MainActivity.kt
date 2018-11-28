package com.example.steph.miniapp1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.root_layout, TransferSpeedFragment.newInstance(), "transferSpeed")
                    .commit()
        }

        // update the conversion
//        networkSpeedET.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//
//            }
//
//            override fun afterTextChanged(s: Editable) {
//                calculateTransferTime()
//            }
//        })
//
//        fileSizeET.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
//
//            }
//
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
//
//            }
//
//            override fun afterTextChanged(s: Editable) {
//                calculateTransferTime()
//            }
//        })
    }

//    fun calculateTransferTime() {
//        // prevent null pointer exception
//        if (networkSpeedET.text.toString() == " ") {
//            networkSpeedET.setText("0")
//        }
//        if (fileSizeET.text.toString() == " ") {
//            fileSizeET.setText("0")
//        }
//
//        // perform conversion
//        val nSpeed = java.lang.Double.parseDouble(networkSpeedET.text.toString()) *
//                (Math.pow(10.0, 6.0))
//        val fSize = java.lang.Double.parseDouble(fileSizeET.text.toString()) *
//                (Math.pow(2.0, 20.0) * 8)
//
//        // display the transfer time
//        transferTimeTV2.showConversion(nSpeed, fSize)
//    }
}
