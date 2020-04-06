package com.renata.mentesaudvel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.renata.mentesaudvel.Adapter.CustomListAdapter;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;

public class MoodActivity extends AppCompatActivity {
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
    Button selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_select_mood);
        first = findViewById(R.id.first_mood);
        second = findViewById(R.id.second_mood);
        third = findViewById(R.id.third_mood);
        fourth = findViewById(R.id.fourth_mood);
        fifth = findViewById(R.id.fifth_mood);
        sixth = findViewById(R.id.sixth_mood);
        seventh = findViewById(R.id.seventh_mood);
        eight = findViewById(R.id.eighth_mood);
        nineth= findViewById(R.id.nineth_mood);
        selected = findViewById(R.id.buttonVisible);
         first_title= findViewById(R.id.first_title);
        second_title= findViewById(R.id.second_title);
         third_title= findViewById(R.id.third_title);
        fourth_title= findViewById(R.id.fourth_title);
         fifth_title= findViewById(R.id.fifth_title);
         sixth_title= findViewById(R.id.sixth_title);
       seventh_title= findViewById(R.id.seventh_title);
         eight_title= findViewById(R.id.eighth_title);
        nineth_title= findViewById(R.id.nineth_title);
        name = findViewById(R.id.helloName);
        final String title1 = first_title.getText().toString();
        final String title2 = second_title.getText().toString();
        final String title3 = third_title.getText().toString();
        final String title4 = fourth_title.getText().toString();
        final String title5 = fifth_title.getText().toString();
        final String title6 = sixth_title.getText().toString();
        final String title7 = seventh_title.getText().toString();
        final String title8 = eight_title.getText().toString();
        final String title9 = nineth_title.getText().toString();
        Bundle extras = getIntent().getExtras();
        String value = extras.getString("name");
        name.setText(value + ", how do you feel?");
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseUser currentUser = auth.getCurrentUser();
        String userID = currentUser.getUid();
        final Date currentTime = Calendar.getInstance().getTime();
        final DatabaseReference userTable = mDatabase.child("USER").child(userID).child("feelStatus");
        final DatabaseReference datehis = mDatabase.child("USER").child(userID).child("dateHistory").child(String.valueOf(currentTime));
        selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MoodActivity.this, selected.getText().toString(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MoodActivity.this, SubmitActivity.class);
                intent.putExtra("nowTime", String.valueOf(currentTime));
                startActivity(intent);
            }
        });
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title1);
                datehis.setValue(title1);
                Toast.makeText(MoodActivity.this, "Your today mood status is "+ title1, Toast.LENGTH_SHORT).show();
                selected.setVisibility(View.VISIBLE);
                selected.setText("Record " + title1);
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title2);
                datehis.setValue(title2);
                Toast.makeText(MoodActivity.this, "Your today mood status is "+ title2, Toast.LENGTH_SHORT).show();
                selected.setVisibility(View.VISIBLE);
                selected.setText("Record " + title2);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title3);
                datehis.setValue(title3);
                Toast.makeText(MoodActivity.this, "Your today mood status is "+ title3, Toast.LENGTH_SHORT).show();
                selected.setVisibility(View.VISIBLE);
                selected.setText("Record " + title3);
            }
        });
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title4);
                datehis.setValue(title4);
                Toast.makeText(MoodActivity.this, "Your today mood status is "+ title4, Toast.LENGTH_SHORT).show();
                selected.setVisibility(View.VISIBLE);
                selected.setText("Record " + title4);
            }
        });
        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title5);
                datehis.setValue(title5);
                Toast.makeText(MoodActivity.this, "Your today mood status is "+ title5, Toast.LENGTH_SHORT).show();
                selected.setVisibility(View.VISIBLE);
                selected.setText("Record " + title5);
            }
        });
        sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title6);
                datehis.setValue(title6);
                Toast.makeText(MoodActivity.this, "Your today mood status is "+ title6, Toast.LENGTH_SHORT).show();
                selected.setVisibility(View.VISIBLE);
                selected.setText("Record " + title6);
            }
        });
        seventh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title7);
                datehis.setValue(title7);
                Toast.makeText(MoodActivity.this, "Your today mood status is "+ title7, Toast.LENGTH_SHORT).show();
                selected.setVisibility(View.VISIBLE);
                selected.setText("Record " + title7);
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title8);
                datehis.setValue(title8);
                Toast.makeText(MoodActivity.this, "Your today mood status is "+ title8, Toast.LENGTH_SHORT).show();
                selected.setVisibility(View.VISIBLE);
                selected.setText("Record " + title8);
            }
        });
        nineth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userTable.setValue(title9);
                datehis.setValue(title9);
                Toast.makeText(MoodActivity.this, "Your today mood status is "+ title9, Toast.LENGTH_SHORT).show();
                selected.setVisibility(View.VISIBLE);
                selected.setText("Record " + title9);
            }
        });

    }



}
