package edu.cvtc.cmarek5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactActivity extends AppCompatActivity {

    private static final String TAG = "From Activity 2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Activity 2 - onCreate Method");
        setContentView(R.layout.activity_second);
        //Random
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
                Intent intentActivityTwo = new Intent(ContactActivity.this, MainActivity.class);
                intentActivityTwo.putExtra(TAG, "To Main Activity");
                startActivity(intentActivityTwo);
                return true;
            case R.id.action_activity_three:
                Intent intentActivityThree = new Intent(ContactActivity.this, DebtsActivity.class);
                intentActivityThree.putExtra(TAG, "To Third Activity");
                startActivity(intentActivityThree);
                return true;
            case R.id.action_activity_four:
                Intent intentActivityFour = new Intent(ContactActivity.this, BudgetCreatorActivity.class);
                intentActivityFour.putExtra(TAG, "To Fourth Activity");
                startActivity(intentActivityFour);
                return true;
            case R.id.action_salex_tax:
                Intent intentSalesTax = new Intent(ContactActivity.this, SalesTaxCalcActivity.class);
                intentSalesTax.putExtra("From Third Activity", "To Sales Tax Calculator");
                startActivity(intentSalesTax);
                return true;
            case R.id.action_tip_calc:
                Intent intentTipCalc = new Intent(ContactActivity.this, TipCalcActivity.class);
                intentTipCalc.putExtra("From Third Activity", "To Tip Calculator");
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

    // App is Back to Working and Everything Shifted
    // Buttons that Have a Purpose --Chantelle
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Component Has Started");
        Button resultButton = findViewById(R.id.button_calcPayment);

        // Submits User Info
        resultButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Log.d(TAG, "The Submit Button Has Been Clicked by User!");
                // Get the Edit Texts --Chantelle
                EditText cFirstName = ((View)view.getParent()).findViewById(R.id.creditor_first_name_text);
                EditText cLastName = ((View)view.getParent()).findViewById(R.id.credit_last_name_text);
                EditText TotalText = ((View)view.getParent()).findViewById(R.id.editText_Total);
                EditText dFirstName = ((View)view.getParent()).findViewById(R.id.debt_first_name_text);
                EditText dLastName = ((View)view.getParent()).findViewById(R.id.debt_last_name_text);
                EditText dEmail = ((View)view.getParent()).findViewById(R.id.debt_email_text);
                EditText dPhone = ((View)view.getParent()).findViewById(R.id.debt_phone_number);

                // Convert Variables to a String
                String firstName = cFirstName.getText().toString();
                String lastName = cLastName.getText().toString();
                String userTotal = TotalText.getText().toString();
                String nameFirst = dFirstName.getText().toString();
                String nameLast = dLastName.getText().toString();
                String email = dEmail.getText().toString();
                String phone = dPhone.getText().toString();

                // Toast to Display the User Inputs
                Toast.makeText(ContactActivity.this,"Your name is " +
                        firstName + " " + lastName + "." + "\n" + "And " + nameFirst + " " +
                        nameLast + " owes you " + userTotal + "." + "\n" + "There contact information is " +
                        email + " , and their phone number is " + phone, Toast.LENGTH_LONG).show();

            }
        });
    }

}