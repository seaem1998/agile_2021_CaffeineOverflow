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

public class BudgetCreatorActivity extends AppCompatActivity {

    EditText category1, category2, category3, category4, categoryCap1, categoryCap2, categoryCap3, categoryCap4;
    boolean areCategoriesValid = false, areCategoriesCapValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        //adding category variables for validation
        category1 = (EditText) findViewById(R.id.userCategory1);
        category2 = (EditText) findViewById(R.id.userCategory2);
        category3 = (EditText) findViewById(R.id.userCategory3);
        category4 = (EditText) findViewById(R.id.userCategory4);
        categoryCap1 = (EditText) findViewById(R.id.categoryCap1);
        categoryCap2 = (EditText) findViewById(R.id.categoryCap2);
        categoryCap3 = (EditText) findViewById(R.id.categoryCap3);
        categoryCap4 = (EditText) findViewById(R.id.categoryCap4);

    }


    protected void onStart() {
        super.onStart();

        Button createBudgetButton = findViewById(R.id.create_budget_button);

        createBudgetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                SetValidation();

                String listOfCategories[] = {category1.getText().toString(), category2.getText().toString(), category3.getText().toString(), category4.getText().toString()};
                String listOfCapacities[] = {categoryCap1.getText().toString(), categoryCap2.getText().toString(), categoryCap3.getText().toString(), categoryCap4.getText().toString()};

                Intent categoryIntent = new Intent(getApplicationContext(), BudgetChartActivity.class);
                Intent failedIntent = new Intent(getApplicationContext(), BudgetCreatorActivity.class);
                categoryIntent.putExtra("categories_key", listOfCategories);
                categoryIntent.putExtra("capacities_key", listOfCapacities);

//                Intent capacityIntent = new Intent(getApplicationContext(), FifthActivity.class);
//                capacityIntent.putExtra("categories_key", listOfCapacities);

                if (areCategoriesValid != false && areCategoriesCapValid != false) {
                    startActivity(categoryIntent);
                }
            }
        });

    }

    private void SetValidation() {
        // Check and validate

        if (category1.getText().toString().isEmpty()) {
            category1.setError("Category cannot be empty");
            category1.requestFocus();
            Toast.makeText(getApplicationContext(), "Please add a category", Toast.LENGTH_LONG).show();
            areCategoriesValid = false;
        } else if (category2.getText().toString().isEmpty()) {
            category2.setError("Category cannot be empty");
            category2.requestFocus();
            Toast.makeText(getApplicationContext(), "Please add a category", Toast.LENGTH_LONG).show();
            areCategoriesValid = false;
        } else if (category3.getText().toString().isEmpty()) {
            category3.setError("Category cannot be empty");
            category3.requestFocus();
            Toast.makeText(getApplicationContext(), "Please add a category", Toast.LENGTH_LONG).show();
            areCategoriesValid = false;
        } else if (category4.getText().toString().isEmpty()) {
            category4.setError("Category cannot be empty");
            category4.requestFocus();
            Toast.makeText(getApplicationContext(), "Please add a category", Toast.LENGTH_LONG).show();
            areCategoriesValid = false;
        } else {
            areCategoriesValid = true;
        }

        if (categoryCap1.getText().toString().isEmpty()) {
            categoryCap1.setError("Please enter a budget for this category");
            categoryCap1.requestFocus();
            Toast.makeText(getApplicationContext(), "Please enter a budget for this category", Toast.LENGTH_LONG).show();
            areCategoriesCapValid = false;
        } else if (categoryCap2.getText().toString().isEmpty()) {
            categoryCap2.setError("Please enter a budget for this category");
            categoryCap2.requestFocus();
            Toast.makeText(getApplicationContext(), "Please enter a budget for this category", Toast.LENGTH_LONG).show();
            areCategoriesCapValid = false;
        } else if (categoryCap3.getText().toString().isEmpty()) {
            categoryCap3.setError("Please enter a budget for this category");
            categoryCap3.requestFocus();
            Toast.makeText(getApplicationContext(), "Please enter a budget for this category", Toast.LENGTH_LONG).show();
            areCategoriesCapValid = false;
        } else if (categoryCap4.getText().toString().isEmpty()) {
            categoryCap4.setError("Please enter a budget for this category");
            categoryCap4.requestFocus();
            Toast.makeText(getApplicationContext(), "Please enter a budget for this category", Toast.LENGTH_LONG).show();
            areCategoriesCapValid = false;
        } else {
            areCategoriesCapValid = true;
        }

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
//
//    // The intent that takes us to the specific activity (Main Menu) --Chantelle
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_home:
                Intent intentActivityMain = new Intent(getApplicationContext(), MainActivity.class);
                intentActivityMain.putExtra("From Fourth Activity", "To Main Activity");
                startActivity(intentActivityMain);
                return true;
            case R.id.action_activity_three:
                Intent intentActivityThree = new Intent(getApplicationContext(), DebtsActivity.class);
                intentActivityThree.putExtra("From Fourth Activity", "To Third Activity");
                startActivity(intentActivityThree);
                return true;
            case R.id.action_activity_two:
                Intent intentActivityTwo = new Intent(getApplicationContext(), ContactActivity.class);
                intentActivityTwo.putExtra("From Fourth Activity", "To Second Activity");
                startActivity(intentActivityTwo);
                return true;
            case R.id.action_salex_tax:
                Intent intentSalesTax = new Intent(getApplicationContext(), SalesTaxCalcActivity.class);
                intentSalesTax.putExtra("From Fourth Activity", "To Sales Tax Calculator");
                startActivity(intentSalesTax);
                return true;
            case R.id.action_tip_calc:
                Intent intentTipCalc = new Intent(getApplicationContext(), TipCalcActivity.class);
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