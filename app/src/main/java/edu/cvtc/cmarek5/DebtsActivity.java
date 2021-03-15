package edu.cvtc.cmarek5;

import androidx.appcompat.app.AppCompatActivity;

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
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }

}