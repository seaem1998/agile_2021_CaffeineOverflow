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
import android.widget.Toast;

import java.util.jar.Attributes;

public class SecondActivity extends AppCompatActivity {

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
        return true;
    }

    // The intent that takes us to the specific activity (Main Menu) --Chantelle
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_home:
                Intent intentActivityTwo = new Intent(SecondActivity.this, MainActivity.class);
                intentActivityTwo.putExtra(TAG, "To Main Activity");
                startActivity(intentActivityTwo);
                return true;
            case R.id.action_activity_three:
                Intent intentActivityThree = new Intent(SecondActivity.this, ThirdActivity.class);
                intentActivityThree.putExtra(TAG, "To Third Activity");
                startActivity(intentActivityThree);
                return true;
            case R.id.action_activity_four:
                Intent intentActivityFour = new Intent(SecondActivity.this, FourthActivity.class);
                intentActivityFour.putExtra(TAG, "To Fourth Activity");
                startActivity(intentActivityFour);
                return true;
            default:
                // Do nothing
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    THE BUTTON IS NOT WORKING ON THE CONTACT PAGE! NOT SURE WHY IT HAS SUDDENLY STOPPED!
    I will get back to work on why it doesn't want to work. --Chantelle
     */

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
//                EditText dFirstName = ((View)view.getParent()).findViewById(R.id.debt_first_name_text);
//                EditText dLastName = ((View)view.getParent()).findViewById(R.id.debt_last_name_text);
//                EditText dEmail = ((View)view.getParent()).findViewById(R.id.debt_email_text);
//                EditText dPhone = ((View)view.getParent()).findViewById(R.id.debt_phone_number);

                // Convert Variables to a String
                String firstName = cFirstName.getText().toString();
                String lastName = cLastName.getText().toString();
                String userTotal = TotalText.getText().toString();
//                String nameFirst = dFirstName.getText().toString();
//                String nameLast = dLastName.getText().toString();
//                String email = dEmail.getText().toString();
//                String phone = dPhone.getText().toString();

//                // Toast to Display the User Inputs
//                Toast.makeText(SecondActivity.this,"Your name is " +
//                        firstName + " " + lastName + "." + "\n" + "And " + nameFirst + " " +
//                        nameLast + " owes you " + userTotal + "." + "\n" + "There contact information is " +
//                        email + " , and their phone number is " + phone, Toast.LENGTH_LONG).show();

                Toast.makeText(view.getContext(), "First Name: " + firstName + "Last Name: " +
                        lastName + "Total = " + userTotal,Toast.LENGTH_LONG).show();

            }
        });
    }

}