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
import android.widget.Toast;

public class SalesTaxCalcActivity extends AppCompatActivity {

    private static final String TAG = "Sales Tax Calculator Activity";

    // Variables
    private EditText cost;
    private EditText tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_tax_calc);
    }

    protected void onStart() {
        super.onStart();

        // The Sales Tax Button
        Button taxButton = findViewById(R.id.button_sales_tax_submit);

        taxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cost = (EditText) findViewById(R.id.cost_text);
                tax = (EditText) findViewById(R.id.tax_text);

                // Convert to string
                String sCost = cost.getText().toString();
                String sTax = tax.getText().toString();

                // Convert to Double
                Double dCost = Double.parseDouble(sCost);
                Double dTax = Double.parseDouble(sTax);

                    // Calculate the Cost of the Bill
                    double taxPercent = (dTax / 100);
                    double calcPercent = dCost * taxPercent;
                    double payment = dCost + calcPercent;

                    // Convert Payment to a String
                    String billDue = (String.valueOf(payment));

                    // Send to Toast to show the user their amount
                    Toast.makeText(SalesTaxCalcActivity.this, "Your Total is " + billDue, Toast.LENGTH_LONG).show();
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
                Intent intent = new Intent(SalesTaxCalcActivity.this, MainActivity.class);
                intent.putExtra(TAG, "To Main Activity");
                startActivity(intent);
                return true;
            case R.id.action_activity_two:
                Intent intentActivityTwo = new Intent(SalesTaxCalcActivity.this, ContactActivity.class);
                intentActivityTwo.putExtra(TAG, "To Second Activity");
                startActivity(intentActivityTwo);
                return true;
            case R.id.action_activity_three:
                Intent intentActivityThree = new Intent(SalesTaxCalcActivity.this, DebtsActivity.class);
                intentActivityThree.putExtra(TAG, "To Third Activity");
                startActivity(intentActivityThree);
                return true;
            case R.id.action_activity_four:
                Intent intentActivityFour = new Intent(SalesTaxCalcActivity.this, BudgetCreatorActivity.class);
                intentActivityFour.putExtra(TAG, "To Fourth Activity");
                startActivity(intentActivityFour);
                return true;
            case R.id.action_tip_calc:
                Intent intentTipCalc = new Intent(SalesTaxCalcActivity.this, TipCalcActivity.class);
                intentTipCalc.putExtra(TAG, "To Tip Calculator");
                startActivity(intentTipCalc);
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