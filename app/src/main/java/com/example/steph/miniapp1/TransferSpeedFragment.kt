package com.example.steph.miniapp1

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.steph.miniapp1.databinding.FragmentTransferSpeedBinding

class TransferSpeedFragment : Fragment() {

    companion object {
        fun newInstance(): TransferSpeedFragment {
            return TransferSpeedFragment()
        }
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(SimpleViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_transfer_speed, container, false)
        val binding: FragmentTransferSpeedBinding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_transfer_speed, container, false)

        binding.viewmodel = viewModel

        // update the conversion
        /*rootView.networkSpeedET.addTextChangedListener(object : TextWatcher {
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
        })*/

        return rootView
    }

    /*fun calculateTransferTime() {
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
    }*/
}
