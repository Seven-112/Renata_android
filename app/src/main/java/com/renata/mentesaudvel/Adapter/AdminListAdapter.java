package com.renata.mentesaudvel.Adapter;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.R;

import java.util.List;

public class AdminListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final List<String> username;
    private final List<String> email;
    private final List<String> gender;
    private final List<String> age;

    public AdminListAdapter(Activity context, List<String> username, List<String> email, List<String> gender, List<String> age) {
        super(context, R.layout.admin_list, username);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.username=username;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final LayoutInflater inflater=context.getLayoutInflater();
        final View rowView=inflater.inflate(R.layout.admin_list, null,true);
        final TextView usernameinfo = (TextView) rowView.findViewById(R.id.username);
        final TextView emailinfo = (TextView) rowView.findViewById(R.id.email);
        final TextView genderinfo = (TextView) rowView.findViewById(R.id.gender);
        final TextView ageinfo = (TextView) rowView.findViewById(R.id.age);
        usernameinfo.setText(username.get(position));
        emailinfo.setText(email.get(position));
        genderinfo.setText(gender.get(position));
        ageinfo.setText(age.get(position));
        return rowView;

    }

}