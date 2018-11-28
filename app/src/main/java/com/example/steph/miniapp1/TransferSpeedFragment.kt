package com.example.steph.miniapp1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_transfer_speed.*
import kotlinx.android.synthetic.main.fragment_transfer_speed.view.*

class TransferSpeedFragment : Fragment() {

    companion object {
        fun newInstance(): TransferSpeedFragment {
            return TransferSpeedFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_transfer_speed, container, false)

        // update the conversion
        rootView.networkSpeedET.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                calculateTransferTime()
            }
        })

        rootView.fileSizeET.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                calculateTransferTime()
            }
        })

        return rootView
    }

    fun calculateTransferTime() {
        // prevent null pointer exception
        if (networkSpeedET.text.toString() == "") {
            networkSpeedET.setText("0")
        }
        if (fileSizeET.text.toString() == "") {
            fileSizeET.setText("0")
        }

        // perform conversion
        val nSpeed = java.lang.Double.parseDouble(networkSpeedET.text.toString()) *
                (Math.pow(10.0, 6.0))
        val fSize = java.lang.Double.parseDouble(fileSizeET.text.toString()) *
                (Math.pow(2.0, 20.0) * 8)

        // display the transfer time
        transferTimeTV2.showConversion(nSpeed, fSize)
    }
}
