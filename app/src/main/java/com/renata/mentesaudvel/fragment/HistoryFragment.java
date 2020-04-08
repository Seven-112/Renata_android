package com.renata.mentesaudvel.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.Adapter.SecondFeelListAdapter;
import com.renata.mentesaudvel.List.SecondFeelListActivity;
import com.renata.mentesaudvel.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {

    private String getDate(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        String date = DateFormat.format("dd/MM/yyyy", cal).toString();
        return date;
    }

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

    public HistoryFragment() {
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
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
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
        View root = inflater.inflate(R.layout.fragment_history, container, false);
        final RecyclerView recyclerView = root.findViewById(R.id.recyclerView);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());

        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        final Date currentTime = Calendar.getInstance().getTime();
//        Bundle extras = getIntent().getExtras();
        String id = auth.getCurrentUser().getUid();
        if (!id.equals("")) {

            final DatabaseReference dateHistory = mDatabase.child("USER").child(id).child("dateHistory");
            dateHistory.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            String key = (String) dataSnapshot1.getKey();
<<<<<<< HEAD
                            String value = (String) dataSnapshot1.getValue();
                            date.add(key);
                            status.add(value);
                        }
                        int i = date.size();
                        int j = status.size();
                        if (i > 30) {
                            date.subList(0,i-30).clear();
                        }
                        if (j > 30) {
                            status.subList(0, j-30).clear();
                        }
=======
                            long key1 = Long.parseLong(key);
                            String time = getDate(key1);
                            String value = (String) dataSnapshot1.getValue();
                            date.add(time);
                            status.add(value);
                        }
                        int i = date.size();
                        int j = status.size();
                        if (i > 30) {
                            date.subList(0,i-30).clear();
                        }
                        if (j > 30) {
                            status.subList(0, j-30).clear();
                        }
>>>>>>> 65eeeb8fe232116fd0559facf6f83e9c4640c96c
                        Collections.reverse(date);
                        Collections.reverse(status);
                        SecondFeelListAdapter adapter=new SecondFeelListAdapter(HistoryFragment.newInstance("",""), date, status, imgid);
                        recyclerView.setAdapter(adapter);
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
