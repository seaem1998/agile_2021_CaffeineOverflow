package edu.cvtc.cmarek5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
//   // Key to send contact info to ThirdActivity --Josh
//    private String mContactInfo ="Testing123";
//    public static final String EXTRA_MESSAGE = "edu.cvtc.cmarek5.secondactivity.extra.MESSAGE";

    private static final String TAG = "Activity 2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Activity 2 - onCreate Method");
        setContentView(R.layout.activity_second);
    }

    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Component Has Started");
        Button submitButton = findViewById(R.id.button_contact_submit);
        Button resultButton = findViewById(R.id.button_calcPayment);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Log.d(TAG, "Button Clicked");
                //Takes User back to the Home Page
                startActivity(new Intent(SecondActivity.this, MainActivity.class));


                // Get the Edit Texts --Chantelle
                EditText NameText = ((View)view.getParent()).findViewById(R.id.editText_Name);
                EditText TotalText = ((View)view.getParent()).findViewById(R.id.editText_Total);

                // Toast to Display the User Inputs
                Toast.makeText(SecondActivity.this, "Your name is " + NameText + ". Your" +
                        " total is " + TotalText, Toast.LENGTH_LONG).show();
            }
        });

        resultButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//                // Sends contact info to ThirdActivity -- Josh
//                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
//                intent.putExtra(EXTRA_MESSAGE, mContactInfo);



                Log.d(TAG, "Button Clicked");
                // Get the Edit Texts --Chantelle
                EditText NameText = ((View)view.getParent()).findViewById(R.id.editText_Name);
                EditText TotalText = ((View)view.getParent()).findViewById(R.id.editText_Total);

                // Toast to Display the User Inputs
                Toast.makeText(SecondActivity.this, "Your name is " + NameText + ". Your" +
                        " total is " + TotalText, Toast.LENGTH_LONG).show();
            }
        });
    }
}