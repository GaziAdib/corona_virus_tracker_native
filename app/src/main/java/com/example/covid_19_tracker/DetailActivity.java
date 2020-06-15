package com.example.covid_19_tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = "DetailActivity";
    private int positionCountry;
    TextView tvCountry,tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths, recoveryRate, deathRate;
    double total_cases_occured,total_deaths_ocurred,total_recovered_ocuured;
    double total_rec_rate,total_death_rate;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);

        getSupportActionBar().setTitle("Details of "+AffectedCountries.countryModelList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        recoveryRate = findViewById(R.id.recoveryRate);
        deathRate = findViewById(R.id.deathRate);
        pieChart = findViewById(R.id.piechartDetail);


        tvCountry.setText(AffectedCountries.countryModelList.get(positionCountry).getCountry());
        tvCases.setText(AffectedCountries.countryModelList.get(positionCountry).getCases());
        tvRecovered.setText(AffectedCountries.countryModelList.get(positionCountry).getRecovered());
        tvCritical.setText(AffectedCountries.countryModelList.get(positionCountry).getCritical());
        tvActive.setText(AffectedCountries.countryModelList.get(positionCountry).getActive());
        tvTodayCases.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayCases());
        tvTotalDeaths.setText(AffectedCountries.countryModelList.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(AffectedCountries.countryModelList.get(positionCountry).getTodayDeaths());

       String total_case = AffectedCountries.countryModelList.get(positionCountry).getCases();
        Log.i(TAG, "Recovery Rate: "+total_case);
       String total_recovered = AffectedCountries.countryModelList.get(positionCountry).getRecovered();
       String total_deaths = AffectedCountries.countryModelList.get(positionCountry).getDeaths();

       if(total_case != "0" && total_recovered != "0" && total_deaths != "0") {


//           total_cases_occured = Integer.parseInt(total_case);
//           total_deaths_ocurred  = Integer.parseInt(total_deaths);
//           total_recovered_ocuured = Integer.parseInt(total_recovered);

           total_cases_occured = Double.parseDouble(total_case);
           total_deaths_ocurred  = Double.parseDouble(total_deaths);
           total_recovered_ocuured = Double.parseDouble(total_recovered);


//           int i = total_recovered_ocuured/total_cases_occured;
//           System.out.println(i);
//


           Log.i(TAG, "total cased occured int "+String.valueOf(total_cases_occured));

           total_rec_rate = (total_recovered_ocuured / total_cases_occured) * 100.0;
           total_death_rate = (total_deaths_ocurred / total_cases_occured) * 100.0;

           int t_rec = (int) total_rec_rate;
           int d_rate = (int) total_death_rate;

          //total_rec_rate =

//           String r_rate = String.valueOf(total_rec_rate);
//           String d_rate = String.valueOf(total_death_rate);
//
//           Log.i(TAG, "onCreate: Rate "+r_rate);


           //recoveryRate.setText(String.format(":2" + total_rec_rate, 2));
           recoveryRate.setText(""+t_rec+" %");
           deathRate.setText(""+d_rate+" %");

           pieChart.addPieSlice((new PieModel("Recovery Rate", t_rec, Color.parseColor("#66BB6A"))));
           pieChart.addPieSlice((new PieModel("Death Rate", d_rate,Color.parseColor("#EF5350"))));



//           int final_recovery_rate = (total_recovered_ocuured/total_cases_occured)*100;
//           int final_death_rate = (total_deaths_ocurred/total_cases_occured)*100;

//           Log.i(TAG, "final recover_rate int "+String.valueOf(final_recovery_rate));
//
//           Log.i(TAG, "Recovery Rate: "+final_recovery_rate);
//           Log.i(TAG, "Deaths Rate: "+final_death_rate);
//
//           String rr = String.valueOf(final_recovery_rate);
//           String dr = String.valueOf(final_death_rate);

//           recoveryRate.setText(String.valueOf(Integer.parseInt( AffectedCountries.countryModelList.get(positionCountry).getRecovered() / AffectedCountries.countryModelList.get(positionCountry).getRecovered())));
//           deathRate.setText(String.valueOf((total_deaths_ocurred/total_cases_occured)*100));
//           Log.i(TAG, "total cased occured int "+String.valueOf(total_cases_occured));
       }







    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);

    }

}
