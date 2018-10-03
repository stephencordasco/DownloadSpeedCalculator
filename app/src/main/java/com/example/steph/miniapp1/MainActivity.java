package com.example.steph.miniapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // reference to widgets
    TextView networkSpeedTV;
    TextView fileSizeTV;
    TextView transferTimeTV;
    EditText networkSpeedET;
    EditText fileSizeET;

    // reference to member variables
    double transferTime = 0;
    double nSpeed = 0;
    double fSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // widget definitions
        networkSpeedTV = findViewById(R.id.networkSpeedTV);
        fileSizeTV = findViewById(R.id.fileSizeTV);
        transferTimeTV = findViewById(R.id.transferTimeTV);
        networkSpeedET = findViewById(R.id.networkSpeedET);
        fileSizeET = findViewById(R.id.fileSizeET);

        // update the conversion
        transferTimeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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

                // MiB to B to b
                fSize = ((fSize * Math.pow(2, 20)) * 8);

                // Mbps to bps
                nSpeed = (nSpeed * Math.pow(10, 6));

                // store the transfer time
                transferTime = fSize / nSpeed;

                // display the transfer time
                transferTimeTV.setText(getString(R.string.transfer_time, transferTime));
            }
        });
    }
}
