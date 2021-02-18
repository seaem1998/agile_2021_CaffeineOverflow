package edu.cvtc.cmarek5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

        // This is the button listener --Chantelle
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Log.d(TAG, "Button Clicked");
                // This act like Navigation, Takes you to the second activity
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
}