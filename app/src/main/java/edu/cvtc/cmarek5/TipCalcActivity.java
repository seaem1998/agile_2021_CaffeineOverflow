package edu.cvtc.cmarek5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalcActivity extends AppCompatActivity {

    // Create Variables --Chantelle
    private EditText amount; // The Bill, before the tip
    private TextView seekBarPercent; // The percentage choosen for the tip
    private Button calculate; // Function to calculate the tip
    private SeekBar seekBar; // The Seek Bar itself
    private int seekPercent;
    private double bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calc);

        // Connect the variables to where they draw user data from -- Chantelle
        amount = (EditText) findViewById(R.id.tip_calc_total_amount_text);
        seekBar = (SeekBar) findViewById(R.id.seekBar_percent);
        seekBarPercent = (TextView) findViewById(R.id.percentage_label);
        calculate = (Button) findViewById(R.id.tip_button);

        // This will keep track of what the Seek Bar does -- Chantelle
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Shows the percentage that Seek Bar is on
                seekBarPercent.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Gets the progress of the seek bar
                seekPercent = seekBar.getProgress();
            }
        });

        // This will calculate the Total Cost of the Bill, this will include the tip
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If the user provided information, math will be performed
                if (!amount.getText().toString().equals("")) {
                    // Variables to perform calculations
                    double result = 0;
                    double total = 0;

                    // Calculate the Total
                    bill = Double.parseDouble(amount.getText().toString());
                    result = bill * seekPercent / 100;
                    total = bill + result;

                    Toast.makeText(TipCalcActivity.this, "Total is " + total, Toast.LENGTH_LONG).show();
                } else {
                    // If user provided no information, we do nothing and let them know to add information
                    Toast.makeText(TipCalcActivity.this, "Please Enter the Amount" ,Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}