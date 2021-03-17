package edu.cvtc.cmarek5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalcActivity extends AppCompatActivity {

    private static final String TAG = "Tip Calculator Activity";

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

    // For the Main Menu --Chantelle
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        // Night/Day Mode Code --Chantelle
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else  {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }

        return true;
    }

    // The intent that takes us to the specific activity (Main Menu) --Chantelle
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_home:
                Intent intent = new Intent(TipCalcActivity.this, MainActivity.class);
                intent.putExtra(TAG, "To Main Activity");
                startActivity(intent);
                return true;
            case R.id.action_activity_two:
                Intent intentActivityTwo = new Intent(TipCalcActivity.this, ContactActivity.class);
                intentActivityTwo.putExtra(TAG, "To Second Activity");
                startActivity(intentActivityTwo);
                return true;
            case R.id.action_activity_three:
                Intent intentActivityThree = new Intent(TipCalcActivity.this, DebtsActivity.class);
                intentActivityThree.putExtra(TAG, "To Third Activity");
                startActivity(intentActivityThree);
                return true;
            case R.id.action_activity_four:
                Intent intentActivityFour = new Intent(TipCalcActivity.this, BudgetCreatorActivity.class);
                intentActivityFour.putExtra(TAG, "To Fourth Activity");
                startActivity(intentActivityFour);
                return true;
            case R.id.action_salex_tax:
                Intent intentSalesTax = new Intent(TipCalcActivity.this, SalesTaxCalcActivity.class);
                intentSalesTax.putExtra(TAG, "To Sales Tax Calculator");
                startActivity(intentSalesTax);
                return true;
            default:
                // Do nothing
        }

        //Check if the correct item was clicked (NIGHT/DAY MODE CODE) --Chantelle
        if(item.getItemId() == R.id.night_mode) {

            //Get night mode state of app
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set theme mode for restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            // Recreate the activity for the theme change to take effect
            recreate();
        }
        return true;

        //return super.onOptionsItemSelected(item);
    }

}