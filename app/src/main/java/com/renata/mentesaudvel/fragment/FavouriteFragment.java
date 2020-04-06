package com.renata.mentesaudvel.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.Adapter.FavourListAdapter;
import com.renata.mentesaudvel.Adapter.FavouriteUserListAdapter;
import com.renata.mentesaudvel.List.FavourListActivity;
import com.renata.mentesaudvel.Model.ReadItem;
import com.renata.mentesaudvel.R;

import java.util.ArrayList;
import java.util.List;

public class FavouriteFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    ListView list;
    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference
    List<ReadItem> readItems = new ArrayList<ReadItem>();
    
    public FavouriteFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static FavouriteFragment newInstance(String param1, String param2) {
        FavouriteFragment fragment = new FavouriteFragment();
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
        View root = inflater.inflate(R.layout.fragment_favourite, container, false);
        list=(ListView) root.findViewById(R.id.list);
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = auth.getCurrentUser();
        final String userID = user.getUid();
        final DatabaseReference favourRef = mDatabase.child("FAVOURITE").child(userID);
        favourRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    readItems.clear();
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        ReadItem readItem = dataSnapshot1.getValue(ReadItem.class);
                        readItems.add(readItem);
                    }
                    Log.v(":", String.valueOf(readItems));
                    final FavouriteUserListAdapter favouriteUserListAdapter=new FavouriteUserListAdapter(getActivity(), readItems);
                    list.setAdapter(favouriteUserListAdapter);
                }else {
                    Toast.makeText(getActivity(), " There aren't any favourite", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub

                Log.v("position", ""+position + id);

            }
        });
        return root;
    }
}
