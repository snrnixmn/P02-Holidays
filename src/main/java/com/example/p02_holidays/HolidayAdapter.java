package com.example.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holidays> {

    private Context context;
    private ArrayList<Holidays> holidays;
    private TextView tvName, tvDate;
    private ImageView ivHols;

    public HolidayAdapter(Context context, int resource, ArrayList<Holidays> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holidays = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvName = (TextView) rowView.findViewById(R.id.tvHolsName);
        tvDate = (TextView) rowView.findViewById(R.id.tvHolsDate);

        // Get the ImageView object
        ivHols = (ImageView) rowView.findViewById(R.id.ivHols);

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holidays currentHoliday = holidays.get(position);
        // Set the TextView to show the food

        tvName.setText(currentHoliday.getHoliday());
        tvDate.setText(currentHoliday.getDate());

        // Set the image to prog or nonprog accordingly
        if (currentHoliday.getHoliday() == "New Year's Day") {
            ivHols.setImageResource(R.drawable.newyear);
        }
        else if (currentHoliday.getHoliday() == "Chinese New Year") {
            ivHols.setImageResource(R.drawable.cny);
        }
        else if (currentHoliday.getHoliday() == "Good Friday") {
            ivHols.setImageResource(R.drawable.goodfriday);
        }
        else if (currentHoliday.getHoliday() == "Labour Day") {
            ivHols.setImageResource(R.drawable.labourday);

        }  else if (currentHoliday.getHoliday() == "Vesak Day") {
            ivHols.setImageResource(R.drawable.vesakday);

        } else if (currentHoliday.getHoliday() == "Hari Raya Puasa") {
            ivHols.setImageResource(R.drawable.harirayapuasa);

        } else if (currentHoliday.getHoliday() == "Hari Raya Haji") {
            ivHols.setImageResource(R.drawable.harirayahaji);

        } else if (currentHoliday.getHoliday() == "National Day") {
            ivHols.setImageResource(R.drawable.nationalday);

        } else if (currentHoliday.getHoliday() == "Deepavali") {
            ivHols.setImageResource(R.drawable.deepavali);

        } else {
            ivHols.setImageResource(R.drawable.christmas);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
