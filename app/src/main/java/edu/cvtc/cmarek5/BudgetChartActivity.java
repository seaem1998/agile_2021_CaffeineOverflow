package edu.cvtc.cmarek5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BudgetChartActivity extends AppCompatActivity {


    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        Intent categoryIntent = getIntent();
        String [] userCategories = categoryIntent.getStringArrayExtra("categories_key");
        String [] userCapacities = categoryIntent.getStringArrayExtra("capacities_key");

        // tests for user input
//        String categoryString = Arrays.toString(userCategories);
//        String capacitiesString = Arrays.toString(userCapacities);
//        Toast.makeText(getApplicationContext(), capacitiesString, Toast.LENGTH_LONG).show();

        pieChart = (PieChart) findViewById(R.id.idPieChart);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("User Budget");
        pieChart.setCenterTextSize(16);
        pieChart.setUsePercentValues(true);
        //pieChart.setDrawEntryLabels(true);

        addDataSet(userCategories, userCapacities);

    }

    private void addDataSet(String [] categories, String [] capacities) {


        List<PieEntry> entries = new ArrayList<>();

        entries.add(new PieEntry(Integer.parseInt(capacities[0]), categories[0]));
        entries.add(new PieEntry(Integer.parseInt(capacities[1]), categories[1]));
        entries.add(new PieEntry(Integer.parseInt(capacities[2]), categories[2]));
        entries.add(new PieEntry(Integer.parseInt(capacities[3]), categories[3]));
        PieDataSet set = new PieDataSet(entries, "User Budget");
        PieData data = new PieData(set);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextColor(Color.BLACK);
        data.setValueTextSize(18f);
        set.setValueTextColor(Color.BLACK);
        set.setColors(Color.RED, Color.GREEN, Color.MAGENTA, Color.BLUE, Color.CYAN, Color.LTGRAY);

        pieChart.setData(data);
        pieChart.invalidate(); // refresh


    }
}