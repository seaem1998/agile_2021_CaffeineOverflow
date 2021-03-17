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

public class BudgetCreatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
    }


    protected void onStart() {
        super.onStart();

        Button createBudgetButton = findViewById(R.id.create_budget_button);

        createBudgetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String listOfCategories[] = {String.valueOf(R.id.userCategory1), String.valueOf(R.id.userCategory2), String.valueOf(R.id.userCategory3), String.valueOf(R.id.userCategory4)};
                Integer listOfCapacities[] = {R.id.categoryCap1, R.id.categoryCap2, R.id.categoryCap3, R.id.categoryCap4};

                Intent categoryIntent = new Intent(getApplicationContext(), BudgetChartActivity.class);
                categoryIntent.putExtra("categories_key", listOfCategories);

                Intent capacityIntent = new Intent(getApplicationContext(), BudgetChartActivity.class);
                capacityIntent.putExtra("categories_key", listOfCapacities);


                // This act like Navigation, Takes you to the second activity
                startActivity(new Intent(BudgetCreatorActivity.this, BudgetChartActivity.class));

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
                Intent intentActivityMain = new Intent(BudgetCreatorActivity.this, MainActivity.class);
                intentActivityMain.putExtra("From Fourth Activity", "To Main Activity");
                startActivity(intentActivityMain);
                return true;
            case R.id.action_activity_three:
                Intent intentActivityThree = new Intent(BudgetCreatorActivity.this, DebtsActivity.class);
                intentActivityThree.putExtra("From Fourth Activity", "To Third Activity");
                startActivity(intentActivityThree);
                return true;
            case R.id.action_activity_two:
                Intent intentActivityTwo = new Intent(BudgetCreatorActivity.this, ContactActivity.class);
                intentActivityTwo.putExtra("From Fourth Activity", "To Second Activity");
                startActivity(intentActivityTwo);
                return true;
            case R.id.action_salex_tax:
                Intent intentSalesTax = new Intent(BudgetCreatorActivity.this, SalesTaxCalcActivity.class);
                intentSalesTax.putExtra("From Fourth Activity", "To Sales Tax Calculator");
                startActivity(intentSalesTax);
                return true;
            case R.id.action_tip_calc:
                Intent intentTipCalc = new Intent(BudgetCreatorActivity.this, TipCalcActivity.class);
                intentTipCalc.putExtra("From Fourth Activity", "To Tip Calculator");
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