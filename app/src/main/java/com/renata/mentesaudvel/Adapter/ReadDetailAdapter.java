package com.renata.mentesaudvel.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.renata.mentesaudvel.Model.ReadItem;
import com.renata.mentesaudvel.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ReadDetailAdapter extends ArrayAdapter<ReadItem> {

    private final Activity context;
    List<ReadItem> readitems;

    public ReadDetailAdapter(Activity context, List<ReadItem> readitems) {
        super(context, R.layout.read_detail_list,readitems);
        this.context = context;
        this.readitems = readitems;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.read_detail_list, null,true);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.sectionImage);
        TextView extratxt = (TextView) rowView.findViewById(R.id.detailChildText);

        ReadItem Item = readitems.get(position);
//        if(Item.getreading_image().equals( "default" )){
//            Picasso.get().load(R.drawable.newitem).into(imageView);
//        }
//        else {
//            Picasso.get().load(Item.getreading_image()).into(imageView);
//        }
        extratxt.setText(Item.getreaditem_detail());
        return rowView;

    }
}