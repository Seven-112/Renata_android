package com.renata.mentesaudvel.List;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SecondFeelListActivity extends AppCompatActivity {
    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference
    List<String> date = new ArrayList<String>();
    List<String> status = new ArrayList<String>();
    Integer[] imgid = {
            R.drawable.calm_emoji,
            R.drawable.angry_emoji,
            R.drawable.anxious_emoji,
            R.drawable.happy_emoji,
            R.drawable.sad_emoji,
            R.drawable.stressed_emoji,
            R.drawable.tired_emoji,
            R.drawable.sacred_emoji,
            R.drawable.agitated_emoji
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_feel2);
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());

        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        final Date currentTime = Calendar.getInstance().getTime();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("id");
            final DatabaseReference dateHistory = mDatabase.child("USER").child(value).child("dateHistory");
            dateHistory.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            final String key = (String) dataSnapshot1.getKey();
                            Log.v("key", key);
                            DatabaseReference keyRef = dateHistory.child(key);
                            keyRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String keyvalue = (String) dataSnapshot.getValue();
                                    Log.v("value", keyvalue);
                                    date.add(key);
                                    int i = date.size();
                                    Log.v("size", String.valueOf(i));
//                                    if (i > 7) {
//                                        date.subList(0,i-7).clear();
//
//                                    }
                                    status.add(keyvalue);
//                                    int j = status.size();
//                                    if (j > 7) {
//                                        status.subList(0, j-7).clear();
//                                    }
                                    Log.v("date", String.valueOf(date));
//                                    SecondFeelListAdapter adapter=new SecondFeelListAdapter(SecondFeelListActivity.this, date, status, imgid);
//                                    recyclerView.setAdapter(adapter);

                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
