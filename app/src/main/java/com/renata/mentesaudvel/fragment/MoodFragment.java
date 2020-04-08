package com.renata.mentesaudvel.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String getDate(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        String date = DateFormat.format("dd/MM/yyyy", cal).toString();
        return date;
    }
    DatabaseReference datehisCheck;
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
        Calendar startTime = Calendar.getInstance();

        long timestamp = startTime.getTimeInMillis();


        final DatabaseReference userTable = mDatabase.child("USER").child(userID).child("feelStatus");
        final DatabaseReference datehis = mDatabase.child("USER").child(userID).child("dateHistory").child(String.valueOf(timestamp));
        datehisCheck = mDatabase.child("USER").child(userID).child("dateHistory");

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datehisCheck.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                String key = (String) dataSnapshot1.getKey();
                                long key1 = Long.parseLong(key);
                                String time = getDate(key1);
                                String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
                                if(time.equals(currentDate)){
                                    datehisCheck.child(key).removeValue();
                                    userTable.setValue(title1);
                                    datehis.setValue(title1);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title1, Toast.LENGTH_SHORT).show();
                                }else {
                                    userTable.setValue(title1);
                                    datehis.setValue(title1);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title1, Toast.LENGTH_SHORT).show();
                                }

                            }
                        }else {
                            userTable.setValue(title1);
                            datehis.setValue(title1);
                            Toast.makeText(getActivity(), "Hoje o humor era "+ title1, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datehisCheck.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                String key = (String) dataSnapshot1.getKey();
                                long key1 = Long.parseLong(key);
                                String time = getDate(key1);
                                String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
                                if(time.equals(currentDate)){
                                    datehisCheck.child(key).removeValue();
                                    userTable.setValue(title2);
                                    datehis.setValue(title2);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title2, Toast.LENGTH_SHORT).show();
                                }else {
                                    userTable.setValue(title2);
                                    datehis.setValue(title2);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title2, Toast.LENGTH_SHORT).show();
                                }

                            }
                        }else {
                            userTable.setValue(title2);
                            datehis.setValue(title2);
                            Toast.makeText(getActivity(), "Hoje o humor era "+ title2, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datehisCheck.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                String key = (String) dataSnapshot1.getKey();
                                long key1 = Long.parseLong(key);
                                String time = getDate(key1);
                                String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
                                if(time.equals(currentDate)){
                                    datehisCheck.child(key).removeValue();
                                    userTable.setValue(title3);
                                    datehis.setValue(title3);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title3, Toast.LENGTH_SHORT).show();
                                }else {
                                    userTable.setValue(title3);
                                    datehis.setValue(title3);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title3, Toast.LENGTH_SHORT).show();

                                }

                            }
                        }else {
                            userTable.setValue(title3);
                            datehis.setValue(title3);
                            Toast.makeText(getActivity(), "Hoje o humor era "+ title3, Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datehisCheck.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                String key = (String) dataSnapshot1.getKey();
                                long key1 = Long.parseLong(key);
                                String time = getDate(key1);
                                String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
                                if(time.equals(currentDate)){
                                    datehisCheck.child(key).removeValue();
                                    userTable.setValue(title4);
                                    datehis.setValue(title4);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title4, Toast.LENGTH_SHORT).show();

                                }else {
                                    userTable.setValue(title4);
                                    datehis.setValue(title4);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title4, Toast.LENGTH_SHORT).show();

                                }

                            }
                        }else {
                            userTable.setValue(title4);
                            datehis.setValue(title4);
                            Toast.makeText(getActivity(), "Hoje o humor era "+ title4, Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        fifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datehisCheck.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                String key = (String) dataSnapshot1.getKey();
                                long key1 = Long.parseLong(key);
                                String time = getDate(key1);
                                String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
                                if(time.equals(currentDate)){
                                    datehisCheck.child(key).removeValue();
                                    userTable.setValue(title5);
                                    datehis.setValue(title5);
                                    Toast.makeText(getActivity(), "Hoje o humor era " + title5, Toast.LENGTH_SHORT).show();
                                }else {
                                    userTable.setValue(title5);
                                    datehis.setValue(title5);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title5, Toast.LENGTH_SHORT).show();

                                }

                            }
                        }else {
                            userTable.setValue(title5);
                            datehis.setValue(title5);
                            Toast.makeText(getActivity(), "Hoje o humor era " + title5, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        sixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datehisCheck.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                String key = (String) dataSnapshot1.getKey();
                                long key1 = Long.parseLong(key);
                                String time = getDate(key1);
                                String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
                                if(time.equals(currentDate)){
                                    datehisCheck.child(key).removeValue();
                                    userTable.setValue(title6);
                                    datehis.setValue(title6);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title6, Toast.LENGTH_SHORT).show();
                                }else {
                                    userTable.setValue(title6);
                                    datehis.setValue(title6);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title6, Toast.LENGTH_SHORT).show();
                                }

                            }
                        }else {
                            userTable.setValue(title6);
                            datehis.setValue(title6);
                            Toast.makeText(getActivity(), "Hoje o humor era "+ title6, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        seventh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datehisCheck.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                String key = (String) dataSnapshot1.getKey();
                                long key1 = Long.parseLong(key);
                                String time = getDate(key1);
                                String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
                                if(time.equals(currentDate)){
                                    datehisCheck.child(key).removeValue();
                                    userTable.setValue(title7);
                                    datehis.setValue(title7);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title7, Toast.LENGTH_SHORT).show();
                                }else {
                                    userTable.setValue(title7);
                                    datehis.setValue(title7);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title7, Toast.LENGTH_SHORT).show();
                                }

                            }
                        }else {
                            userTable.setValue(title7);
                            datehis.setValue(title7);
                            Toast.makeText(getActivity(), "Hoje o humor era "+ title7, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datehisCheck.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                String key = (String) dataSnapshot1.getKey();
                                long key1 = Long.parseLong(key);
                                String time = getDate(key1);
                                String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
                                if(time.equals(currentDate)){
                                    datehisCheck.child(key).removeValue();
                                    userTable.setValue(title8);
                                    datehis.setValue(title8);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title8, Toast.LENGTH_SHORT).show();
                                }else {
                                    userTable.setValue(title8);
                                    datehis.setValue(title8);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title8, Toast.LENGTH_SHORT).show();
                                }

                            }
                        }else {
                            userTable.setValue(title8);
                            datehis.setValue(title8);
                            Toast.makeText(getActivity(), "Hoje o humor era "+ title8, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        nineth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datehisCheck.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                                String key = (String) dataSnapshot1.getKey();
                                long key1 = Long.parseLong(key);
                                String time = getDate(key1);
                                String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
                                if(time.equals(currentDate)){
                                    datehisCheck.child(key).removeValue();
                                    userTable.setValue(title9);
                                    datehis.setValue(title9);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title9, Toast.LENGTH_SHORT).show();
                                }else {
                                    userTable.setValue(title9);
                                    datehis.setValue(title9);
                                    Toast.makeText(getActivity(), "Hoje o humor era "+ title9, Toast.LENGTH_SHORT).show();
                                }

                            }
                        }
                        userTable.setValue(title9);
                        datehis.setValue(title9);
                        Toast.makeText(getActivity(), "Hoje o humor era "+ title9, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        
        return root;
    }
//    public void checkDate(){
//        datehisCheck.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if(dataSnapshot.exists()){
//                    for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
//                        String key = (String) dataSnapshot1.getKey();
//                        long key1 = Long.parseLong(key);
//                        String time = getDate(key1);
//                        String currentDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
//                        if(time.equals(currentDate)){
//                            datehisCheck.child(key).removeValue();
//                        }else {
//                            Toast.makeText(getActivity(), "xxxxxx", Toast.LENGTH_SHORT).show();
//
//                        }
//
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }

    @Override
    public void onStart() {
        super.onStart();

    }
    @Override
    public void onPause() {
        super.onPause();

    }

}
