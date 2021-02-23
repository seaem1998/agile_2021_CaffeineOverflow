package edu.cvtc.cmarek5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

          Intent intent = getIntent();
          String contactInfoText = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
          TextView textView = findViewById(R.id.textView_contact_info);
          textView.setText(contactInfoText);

    }
}