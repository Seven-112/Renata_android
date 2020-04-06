package com.renata.mentesaudvel.fragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.renata.mentesaudvel.AlarmReceiver;
import com.renata.mentesaudvel.Model.User;
import com.renata.mentesaudvel.MoodActivity;
import com.renata.mentesaudvel.R;
import com.renata.mentesaudvel.SubmitActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Handler;

import static android.content.Context.ALARM_SERVICE;

public class MoodFragment extends Fragment {

    private FirebaseAuth auth;//TODO; firebase

    private DatabaseReference mDatabase; //TODO; database reference
    LinearLayout first, second, third, fourth, fifth, sixth, seventh, eight, nineth;
    TextView first_title,
            second_title,
            third_title,
            fourth_title,
            fifth_title,
            sixth_title,
            seventh_title,
            eight_title,
            nineth_title,
            name;
    String user_name = "";
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public MoodFragment() {

    }

    public static MoodFragment newInstance(String param1, String param2) {
        MoodFragment fragment = new MoodFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String nameInfo = getArguments().getString("name");
        View root = inflater.inflate(R.layout.fragment_mood, container, false);

        first = root.findViewById(R.id.first_mood);
        second = root.findViewById(R.id.second_mood);
        third = root.findViewById(R.id.third_mood);
        fourth = root.findViewById(R.id.fourth_mood);
        fifth = root.findViewById(R.id.fifth_mood);
        sixth = root.findViewById(R.id.sixth_mood);
        seventh = root.findViewById(R.id.seventh_mood);
        eight = root.findViewById(R.id.eighth_mood);
        nineth= root.findViewById(R.id.nineth_mood);
        first_title= root.findViewById(R.id.first_title);
        second_title= root.findViewById(R.id.second_title);
        third_title= root.findViewById(R.id.third_title);
        fourth_title= root.findViewById(R.id.fourth_title);
        fifth_title= root.findViewById(R.id.fifth_title);
        sixth_title= root.findViewById(R.id.sixth_title);
        seventh_title= root.findViewById(R.id.seventh_title);
        eight_title= root.findViewById(R.id.eighth_title);
        nineth_title= root.findViewById(R.id.nineth_title);
        name = root.findViewById(R.id.helloName);
        final String title1 = first_title.getText().toString();
        final String title2 = second_title.getText().toString();
        final String title3 = third_title.getText().toString();
        final String title4 = fourth_title.getText().toString();
        final String title5 = fifth_title.getText().toString();
        final String title6 = sixth_title.getText().toString();
        final String title7 = seventh_title.getText().toString();
        final String title8 = eight_title.getText().toString();
        final String title9 = nineth_title.getText().toString();

        name.setText(mParam1 + ", Como você se sentiu hoje?");
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseUser currentUser = auth.getCurrentUser();
        String userID = currentUser.getUid();
        String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        final DatabaseReference userTable = mDatabase.child("USER").child(userID).child("feelStatus");
        final DatabaseReference datehis = mDatabase.child("USER").child(userID).child("dateHistory").child(String.valueOf(currentDate));

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title1);
                datehis.setValue(title1);
                Toast.makeText(getActivity(), "Hoje o humor era "+ title1, Toast.LENGTH_SHORT).show();
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title2);
                datehis.setValue(title2);
                Toast.makeText(getActivity(), "Hoje o humor era "+ title2, Toast.LENGTH_SHORT).show();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title3);
                datehis.setValue(title3);
                Toast.makeText(getActivity(), "Hoje o humor era "+ title3, Toast.LENGTH_SHORT).show();
            }
        });
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title4);
                datehis.setValue(title4);
                Toast.makeText(getActivity(), "Hoje o humor era "+ title4, Toast.LENGTH_SHORT).show();
            }
        });
        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title5);
                datehis.setValue(title5);
                Toast.makeText(getActivity(), "Hoje o humor era "+ title5, Toast.LENGTH_SHORT).show();
            }
        });
        sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title6);
                datehis.setValue(title6);
                Toast.makeText(getActivity(), "Hoje o humor era "+ title6, Toast.LENGTH_SHORT).show();
            }
        });
        seventh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title7);
                datehis.setValue(title7);
                Toast.makeText(getActivity(), "Hoje o humor era "+ title7, Toast.LENGTH_SHORT).show();
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title8);
                datehis.setValue(title8);
                Toast.makeText(getActivity(), "Hoje o humor era "+ title8, Toast.LENGTH_SHORT).show();
            }
        });
        nineth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title9);
                datehis.setValue(title9);
                Toast.makeText(getActivity(), "Hoje o humor era "+ title9, Toast.LENGTH_SHORT).show();
            }
        });


        
        return root;
    }
    @Override
    public void onStart() {
        super.onStart();

    }
    @Override
    public void onPause() {
        super.onPause();

    }

}
