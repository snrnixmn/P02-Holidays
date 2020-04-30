package com.example.p02_holidays;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvTypes;
    ArrayList<Holidays> hols;
    ArrayAdapter aa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lvHolidays);
        tvTypes = (TextView) findViewById(R.id.tvTypes);

        Intent i = getIntent();
        String types = i.getStringExtra("holTypes");
        tvTypes.setText(types);

        // Create a few moduke objects in given years array
        hols = new ArrayList<Holidays>();

        if (types == "Secular") {
            hols.add(new Holidays("New Year's Day", "1 January 2020"));
            hols.add(new Holidays("Chinese New Year", "25 January 2020 - 26 January 2020"));
            hols.add(new Holidays("Good Friday", "10 April 2020"));
            hols.add(new Holidays("Labour Day", "1 May 2020"));
            hols.add(new Holidays("Vesak Day", "7 May 2020"));
            hols.add(new Holidays("Hari Raya Puasa", "24 May 2020"));
            hols.add(new Holidays("Hari Raya Haji", "31 July 2020"));
            hols.add(new Holidays("National Day", "9 August"));
            hols.add(new Holidays("Deepavali", "14 November 2020"));
            hols.add(new Holidays("Christmas", "25 December 2020"));
            aa = new HolidayAdapter(this, R.layout.row, hols);
            lv.setAdapter(aa);

        } else {
            hols.add(new Holidays("New Year's Day", "1 January 2020"));
            hols.add(new Holidays("Chinese New Year", "25 January 2020 - 26 January 2020"));
            hols.add(new Holidays("Good Friday", "10 April 2020"));
            hols.add(new Holidays("Vesak Day", "7 May 2020"));
            hols.add(new Holidays("Hari Raya Puasa", "24 May 2020"));
            hols.add(new Holidays("Hari Raya Haji", "31 July 2020"));
            hols.add(new Holidays("Deepavali", "14 November 2020"));
            hols.add(new Holidays("Christmas", "25 December 2020"));
            aa = new HolidayAdapter(this, R.layout.row, hols);
            lv.setAdapter(aa);
        }


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holidays selectedHols = hols.get(position);

                Toast.makeText(SecondActivity.this, selectedHols.getHoliday()
                                + ": " + selectedHols.getDate(),
                        Toast.LENGTH_LONG).show();
            }

        });
    }

}
