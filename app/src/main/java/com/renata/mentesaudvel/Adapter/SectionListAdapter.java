package com.renata.mentesaudvel.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.renata.mentesaudvel.Model.Reading;
import com.renata.mentesaudvel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SectionListAdapter extends ArrayAdapter<Reading> {

    private final Activity context;
    List<Reading> readings;

    public SectionListAdapter(Activity context, List<Reading> readings) {
        super(context, R.layout.main_list,readings);
        this.context = context;
        this.readings = readings;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.main_list, null,true);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.sectionImage);
        TextView extratxt = (TextView) rowView.findViewById(R.id.sectiontitle);

        Reading Item = readings.get(position);
        if(Item.getreading_image().equals( "default" )){
            Picasso.get().load(R.drawable.newitem).into(imageView);
        }
        else {
            Picasso.get().load(Item.getreading_image()).into(imageView);
        }
        extratxt.setText(Item.getreading_name());
        return rowView;

    }
}