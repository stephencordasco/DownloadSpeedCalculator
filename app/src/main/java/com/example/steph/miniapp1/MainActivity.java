package com.example.steph.miniapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // reference to widgets
    TextView networkSpeedTV;
    TextView fileSizeTV;
    TextView transferTimeTV;
    TextView textView;
    EditText networkSpeedET;
    EditText fileSizeET;

    // reference to member variables
    double transferTime = 0;
    double nSpeed = 0;
    double fSize = 0;
    DecimalFormat precision;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // widget definitions
        networkSpeedTV = findViewById(R.id.networkSpeedTV);
        fileSizeTV = findViewById(R.id.fileSizeTV);
        transferTimeTV = findViewById(R.id.transferTimeTV);
        textView = findViewById(R.id.transferTimeTV2);
        networkSpeedET = findViewById(R.id.networkSpeedET);
        fileSizeET = findViewById(R.id.fileSizeET);
        precision = new DecimalFormat("0.0");

        // update the conversion
        networkSpeedET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculateTransferTime();
            }
        });

        fileSizeET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                calculateTransferTime();
            }
        });
    }

    public void calculateTransferTime()
    {
        // check if the fields are empty
        if (networkSpeedET.getText().toString().equals(""))
        {
            networkSpeedET.setText("0");
        }
        if (fileSizeET.getText().toString().equals(""))
        {
            fileSizeET.setText("0");
        }

        // perform conversion
        nSpeed = Double.parseDouble(networkSpeedET.getText().toString());
        fSize = Double.parseDouble(fileSizeET.getText().toString());

        // check for 0 in the denominator
        if (nSpeed == 0)
        {
            nSpeed = 1;
        }

        // MiB to B to b
        fSize = ((fSize * Math.pow(2, 20)) * 8);

        // Mbps to bps
        nSpeed = (nSpeed * Math.pow(10, 6));

        // store the transfer time
        transferTime = fSize / nSpeed;

        // display the transfer time
        textView.setText(String.valueOf(precision.format(transferTime)));
    }
}
