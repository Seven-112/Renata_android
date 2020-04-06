package com.renata.mentesaudvel.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.Adapter.SectionListAdapter;
import com.renata.mentesaudvel.List.EightListActivity;
import com.renata.mentesaudvel.List.FavourListActivity;
import com.renata.mentesaudvel.List.FiveListActivity;
import com.renata.mentesaudvel.List.FourListActivity;
import com.renata.mentesaudvel.List.NineListActivity;
import com.renata.mentesaudvel.List.OneListActivity;
import com.renata.mentesaudvel.List.SevenListActivity;
import com.renata.mentesaudvel.List.SixListActivity;
import com.renata.mentesaudvel.List.ThreeListActivity;
import com.renata.mentesaudvel.List.TwoListActivity;
import com.renata.mentesaudvel.MainListActivity;
import com.renata.mentesaudvel.Model.Reading;
import com.renata.mentesaudvel.R;
import com.renata.mentesaudvel.ReadingListAdminActivity;
import com.renata.mentesaudvel.ReadingListUserActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReadingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReadingFragment extends Fragment {

    ListView list;
    DatabaseReference databaseReference;
    List<Reading> readings = new ArrayList<>();
    private SectionListAdapter ReadingAdapter;
    
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    
    private String mParam1;
    private String mParam2;

    public ReadingFragment() {
        // Required empty public constructor
    }
    public static ReadingFragment newInstance(String param1, String param2) {
        ReadingFragment fragment = new ReadingFragment();
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
        View root = inflater.inflate(R.layout.fragment_reading, container, false);
        list=(ListView) root.findViewById(R.id.list);
        Button favour = (Button) root.findViewById(R.id.favourite);

        databaseReference = FirebaseDatabase.getInstance().getReference("Readings");
        ReadingAdapter = new SectionListAdapter(getActivity(), readings );
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Reading Item = readings.get(position);
                String readingID= Item.getreading_id();
                Intent intent = new Intent(getActivity(), ReadingListUserActivity.class);
                intent.putExtra("readindid",readingID);
                startActivity(intent);

            }
        });
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(mValueEventListener);

    }

    ValueEventListener mValueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            //clearing the previous Item list
            readings.clear();
            //getting all nodes
            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                //getting Item from firebase console
                Reading Item = postSnapshot.getValue( Reading.class);

                readings.add( Item );
            }

            list.setAdapter(ReadingAdapter);
//            pd.dismiss();

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }

    };
}
