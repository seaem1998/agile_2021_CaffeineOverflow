package edu.cvtc.cmarek5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SalesTaxCalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_tax_calc);
    }

    // I need to multiply the decimal by one hundred to get the right calculations --Chantelle
}