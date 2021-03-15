package edu.cvtc.cmarek5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class BudgetChartActivity extends AppCompatActivity {


    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        Intent categoryIntent = getIntent();
        String [] userCategories = categoryIntent.getStringArrayExtra("categories_key");

        pieChart = (PieChart) findViewById(R.id.idPieChart);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Example Chart");
        pieChart.setCenterTextSize(16);
        pieChart.setUsePercentValues(true);
        //pieChart.setDrawEntryLabels(true);

        addDataSet();

    }

    private void addDataSet() {

        List<PieEntry> entries = new ArrayList<>();

        

        entries.add(new PieEntry(18.5f, "Groceries"));
        entries.add(new PieEntry(20.0f, "Entertainment"));
        entries.add(new PieEntry(24.0f, "Insurance"));
        entries.add(new PieEntry(18.4f, "Gas"));
        entries.add(new PieEntry(12.4f, "Utilities"));
        entries.add(new PieEntry(6.7f, "Clothing"));
        PieDataSet set = new PieDataSet(entries, "User Budget");
        PieData data = new PieData(set);
        data.setValueTextColor(Color.BLACK);
        data.setValueTextSize(14f);
        set.setValueTextColor(Color.BLACK);
        set.setColors(Color.RED, Color.GREEN, Color.MAGENTA, Color.BLUE, Color.CYAN, Color.LTGRAY);

        pieChart.setData(data);
        pieChart.invalidate(); // refresh

//        ArrayList<PieEntry> yEntries = new ArrayList<>();
//        ArrayList<String> xEntries = new ArrayList<>();
//
//        for (int i = 0; i < yData.length; i++){
//            yEntries.add(new PieEntry(yData[i], i));
//        }
//
//        for (int i = 1; i < xData.length; i++){
//            xEntries.add(xData[i]);
//        }
//
//        PieDataSet pieDataSet = new PieDataSet(yEntries, "Example");
//        pieDataSet.setSliceSpace(2);
//        pieDataSet.setValueTextSize(12);
//
//        //adding colors
//        ArrayList<Integer> colors = new ArrayList<>();
//        colors.add(Color.GRAY);
//        colors.add(Color.BLUE);
//        colors.add(Color.RED);
//        colors.add(Color.YELLOW);
//        colors.add(Color.GREEN);
//        colors.add(Color.CYAN);
//        colors.add(Color.MAGENTA);
//
//        //adding legend to chart
//        Legend legend = pieChart.getLegend();
//        legend.setForm(Legend.LegendForm.CIRCLE);
//
//        //PieData pieData = new PieDataSet(pieDataSet);
//        //pieChart.setData(pieData);
//        pieChart.invalidate();

    }
}