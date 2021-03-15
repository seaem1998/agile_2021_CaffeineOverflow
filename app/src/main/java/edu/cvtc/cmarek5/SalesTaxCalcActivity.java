package edu.cvtc.cmarek5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SalesTaxCalcActivity extends AppCompatActivity {

    // Variables
    private EditText cost;
    private EditText tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_tax_calc);
    }

    protected void onStart() {
        super.onStart();

        // The Sales Tax Button
        Button taxButton = findViewById(R.id.button_sales_tax_submit);

        taxButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cost = (EditText) findViewById(R.id.cost_text);
                tax = (EditText) findViewById(R.id.tax_text);

                // Convert to string
                String sCost = cost.getText().toString();
                String sTax = tax.getText().toString();

                // Convert to Double
                Double dCost = Double.parseDouble(sCost);
                Double dTax = Double.parseDouble(sTax);

                    // Calculate the Cost of the Bill
                    double taxPercent = (dTax / 100);
                    double calcPercent = dCost * taxPercent;
                    double payment = dCost + calcPercent;

                    // Convert Payment to a String
                    String billDue = (String.valueOf(payment));

                    // Send to Toast to show the user their amount
                    Toast.makeText(SalesTaxCalcActivity.this, "Your Total is " + billDue, Toast.LENGTH_LONG).show();
            }
        });
    }
}