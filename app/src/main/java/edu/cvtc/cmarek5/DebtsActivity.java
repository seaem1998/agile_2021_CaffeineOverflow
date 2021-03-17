package edu.cvtc.cmarek5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class DebtsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

          Intent intent = getIntent();
          String contactInfoText = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
          TextView textView = findViewById(R.id.textView_debts_display);
          textView.setText(contactInfoText);

        // Create the spinner.
        Spinner spinner = findViewById(R.id.label_spinner); if (spinner != null) {
            spinner.setOnItemSelectedListener(this); }

        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
                Intent intentActivityHome = new Intent(DebtsActivity.this, MainActivity.class);
                intentActivityHome.putExtra("From Third Activity", "To Main Activity");
                startActivity(intentActivityHome);
                return true;
            case R.id.action_activity_two:
                Intent intentActivityTwo = new Intent(DebtsActivity.this, ContactActivity.class);
                intentActivityTwo.putExtra("From Third Activity", "To Second Activity");
                startActivity(intentActivityTwo);
                return true;
            case R.id.action_activity_four:
                Intent intentActivityFour = new Intent(DebtsActivity.this, BudgetCreatorActivity.class);
                intentActivityFour.putExtra("From Third Activity", "To Fourth Activity");
                startActivity(intentActivityFour);
                return true;
            case R.id.action_salex_tax:
                Intent intentSalesTax = new Intent(DebtsActivity.this, SalesTaxCalcActivity.class);
                intentSalesTax.putExtra("From Third Activity", "To Sales Tax Calculator");
                startActivity(intentSalesTax);
                return true;
            case R.id.action_tip_calc:
                Intent intentTipCalc = new Intent(DebtsActivity.this, TipCalcActivity.class);
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

}