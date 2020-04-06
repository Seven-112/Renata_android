package com.renata.mentesaudvel.adminframent;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.Adapter.SecondFeelListAdapter;
import com.renata.mentesaudvel.R;
import com.renata.mentesaudvel.fragment.HistoryFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AdminHistoryFragment extends Fragment {

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
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AdminHistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AdminHistoryFragment newInstance(String param1, String param2) {
        AdminHistoryFragment fragment = new AdminHistoryFragment();
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
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_admin_history, container, false);
        final RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        final TextView textViewname = root.findViewById(R.id.nameTV);
        final TextView textViewgender = root.findViewById(R.id.genderTV);
        final TextView textViewage = root.findViewById(R.id.ageTV);
        final TextView textViewemail = root.findViewById(R.id.emailTV);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mDatabase = FirebaseDatabase.getInstance().getReference();

        final Date currentTime = Calendar.getInstance().getTime();
//        Bundle extras = getIntent().getExtras();
        String id = mParam1;
        DatabaseReference mref = mDatabase.child("USER").child(id);
        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("userName").getValue().toString();
                String gender = dataSnapshot.child("gender").getValue().toString();
                String age = dataSnapshot.child("age").getValue().toString();
                String email = dataSnapshot.child("emailAddress").getValue().toString();
                textViewname.setText(name);
                textViewgender.setText(gender);
                textViewage.setText(age);
                textViewemail.setText(email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        if (!id.equals("")) {

            final DatabaseReference dateHistory = mDatabase.child("USER").child(id).child("dateHistory");
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
                                    if (i > 30) {
                                        date.subList(0,i-30).clear();

                                    }
                                    status.add(keyvalue);
                                    int j = status.size();
                                    if (j > 30) {
                                        status.subList(0, j-30).clear();
                                    }
                                    Log.v("date", String.valueOf(date));
                                    Collections.reverse(date);
                                    Collections.reverse(status);
                                    SecondFeelListAdapter adapter=new SecondFeelListAdapter(HistoryFragment.newInstance("",""), date, status, imgid);
                                    recyclerView.setAdapter(adapter);

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
        return root;
    }
}
