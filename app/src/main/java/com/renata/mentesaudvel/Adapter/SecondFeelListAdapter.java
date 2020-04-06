package com.renata.mentesaudvel.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.renata.mentesaudvel.List.SecondFeelListActivity;
import com.renata.mentesaudvel.R;
import com.renata.mentesaudvel.fragment.HistoryFragment;

import java.util.List;

public class SecondFeelListAdapter extends RecyclerView.Adapter<SecondFeelListAdapter.MyViewHolder> {

    private final List<String> date;
    private final List<String> stauts;
    private final Integer[] imgid;
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView time, moody;
        ImageView feel;
        MyViewHolder(View view) {
            super(view);
            time = view.findViewById(R.id.currentDate);
            moody = view.findViewById(R.id.currentMood);
            feel = view.findViewById(R.id.feelImg);
        }
    }


    public SecondFeelListAdapter(HistoryFragment historyFragment, List<String> date, List<String> stauts, Integer[] imgid) {

        this.date=date;
        this.stauts=stauts;
        this.imgid=imgid;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.feel_list2, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.time.setText(date.get(position));
        holder.moody.setText(stauts.get(position));
//        holder.feel.setImageResource(R.drawable.profile_image);

        if (position == 0) {
            holder.time.setTextColor(Color.parseColor("#0066ff"));
            holder.moody.setTextColor(Color.parseColor("#0066ff"));
        }

        if (holder.moody.getText().toString().equals("Cansado")) {
            holder.feel.setImageResource(R.drawable.tired_emoji);
        }

        if (holder.moody.getText().toString().equals("Calm")) {
            holder.feel.setImageResource(R.drawable.calm_emoji);
        }

        if (holder.moody.getText().toString().equals("Irritado")) {
            holder.feel.setImageResource(R.drawable.angry_emoji);
        }

        if (holder.moody.getText().toString().equals("Ansioso")) {
            holder.feel.setImageResource(R.drawable.anxious_emoji);
        }

        if (holder.moody.getText().toString().equals("Feliz")) {
            holder.feel.setImageResource(R.drawable.happy_emoji);
        }

        if (holder.moody.getText().toString().equals("Triste")) {
            holder.feel.setImageResource(R.drawable.sad_emoji);
        }

        if (holder.moody.getText().toString().equals("Assustado")) {
            holder.feel.setImageResource(R.drawable.sacred_emoji);
        }

        if (holder.moody.getText().toString().equals("Estressado")) {
            holder.feel.setImageResource(R.drawable.stressed_emoji);
        }

        if (holder.moody.getText().toString().equals("Agitado")) {
            holder.feel.setImageResource(R.drawable.agitated_emoji);
        }

    }

    @Override
    public int getItemCount() {
        return stauts.size();
    }

}
