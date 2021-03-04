package edu.cvtc.cmarek5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class FourthActivity extends AppCompatActivity {

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

                Intent categoryIntent = new Intent(getApplicationContext(), SecondActivity.class);
                categoryIntent.putExtra("categories_key", listOfCategories);

                Intent capacityIntent = new Intent(getApplicationContext(), SecondActivity.class);
                capacityIntent.putExtra("categories_key", listOfCapacities);


                // This act like Navigation, Takes you to the second activity
                startActivity(new Intent(FourthActivity.this, FifthActivity.class));

            }
        });

    }

//    // For the Main Menu --Chantelle
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.main_menu,menu);
//        return true;
//    }
//
//    // The intent that takes us to the specific activity (Main Menu) --Chantelle
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.action_home:
//                Intent intentActivityMain = new Intent(FourthActivity.this, MainActivity.class);
//                intentActivityMain.putExtra("From Fourth Activity", "To Main Activity");
//                startActivity(intentActivityMain);
//                return true;
//            case R.id.action_activity_three:
//                Intent intentActivityThree = new Intent(FourthActivity.this, ThirdActivity.class);
//                intentActivityThree.putExtra("From Fourth Activity", "To Third Activity");
//                startActivity(intentActivityThree);
//                return true;
//            case R.id.action_activity_two:
//                Intent intentActivityTwo = new Intent(FourthActivity.this, SecondActivity.class);
//                intentActivityTwo.putExtra("From Fourth Activity", "To Second Activity");
//                startActivity(intentActivityTwo);
//                return true;
//            default:
//                // Do nothing
//        }
//        return super.onOptionsItemSelected(item);
//    }

}