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
    private String mContactInfo ="";
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

                EditText NameText = ((View)view.getParent()).findViewById(R.id.editText_Name);
                EditText TotalText = ((View)view.getParent()).findViewById(R.id.editText_Total);

                mContactInfo = "Contact name is " ;




                // Sends contact info to ThirdActivity -- Josh
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mContactInfo);

                startActivity(intent);
            }
        });








    }
}