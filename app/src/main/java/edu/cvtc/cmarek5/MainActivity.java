package edu.cvtc.cmarek5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Key to send contact info to ThirdActivity --Josh
     String mContactInfo =" Test test";
    public static final String EXTRA_MESSAGE = "edu.cvtc.cmarek5.secondactivity.extra.MESSAGE";



    private static final String TAG = "The App Has Been Created";
    private TextView mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This is set up to make the HOME button work --Chantelle
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Component Has Started");
        Button submitButton = findViewById(R.id.button_home_submit);
        Button debtsButton = findViewById(R.id.button_debts);
        //Button budgetButton = findViewById(R.id.create_budget_button);

        // This is the button listener --Chantelle
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Log.d(TAG, "Button Clicked");
                // This act like Navigation, Takes you to the second activity
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        // This act like Navigation, Takes you to the debts activity
        // This is the button listener for debts -- Josh

        debtsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d(TAG, "Debts button Clicked");

                //EditText NameText = ((View)view.getParent()).findViewById(R.id.editText_Name);
                //EditText TotalText = ((View)view.getParent()).findViewById(R.id.editText_Total);

                // Convert Variables to a String
                //an issue with converting the edit texts to strings
                // will crash the whole app

                //String userName = NameText.getText().toString();
               // String userTotal = TotalText.getText().toString();



                // Sends contact info to ThirdActivity -- Josh
                mContactInfo = "Contacts: " ;


                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mContactInfo);

                startActivity(intent);
            }
        });



//        budgetButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View view) {
//
//                Log.d(TAG, "Button Clicked");
//                // This act like Navigation, Takes you to the second activity
//                //startActivity(new Intent(MainActivity.this, FourthActivity.class));
//            }
//        });

    }

    public void LaunchFourthActivity(View view) {
        startActivity(new Intent(MainActivity.this, FourthActivity.class));
    }

    // For the Main Menu --Chantelle
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    // The intent that takes us to the specific activity (Main Menu) --Chantelle
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_activity_two:
                Intent intentActivityTwo = new Intent(MainActivity.this, SecondActivity.class);
                intentActivityTwo.putExtra(TAG, "To Second Activity");
                startActivity(intentActivityTwo);
                return true;
            case R.id.action_activity_three:
                Intent intentActivityThree = new Intent(MainActivity.this, ThirdActivity.class);
                intentActivityThree.putExtra(TAG, "To Third Activity");
                startActivity(intentActivityThree);
                return true;
            case R.id.action_activity_four:
                Intent intentActivityFour = new Intent(MainActivity.this, FourthActivity.class);
                intentActivityFour.putExtra(TAG, "To Fourth Activity");
                startActivity(intentActivityFour);
                return true;
            case R.id.action_salex_tax:
                Intent intentSalesTax = new Intent(MainActivity.this, SalesTaxCalcActivity.class);
                intentSalesTax.putExtra(TAG, "To Sales Tax Calculator");
                startActivity(intentSalesTax);
                return true;
            case R.id.action_tip_calc:
                Intent intentTipCalc = new Intent(MainActivity.this, TipCalcActivity.class);
                intentTipCalc.putExtra(TAG, "To Tip Calculator");
                startActivity(intentTipCalc);
                return true;
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }
}