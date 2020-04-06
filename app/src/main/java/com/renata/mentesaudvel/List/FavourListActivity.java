package com.renata.mentesaudvel.List;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.Adapter.FavourListAdapter;
import com.renata.mentesaudvel.R;

import java.util.ArrayList;
import java.util.List;

public class FavourListActivity extends AppCompatActivity {
    ListView list;
    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference
    List<String> itemname = new ArrayList<String>();
    List<String> titlename = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_favourite);
        list=(ListView)findViewById(R.id.list);
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = auth.getCurrentUser();
        final String userID = user.getUid();
        final DatabaseReference favourRef = mDatabase.child("FAVOURITE").child(userID);
        favourRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        String title = (String) dataSnapshot1.getKey();
                        String item = (String) dataSnapshot1.getValue();
                        titlename.add(title);
                        itemname.add(item);
                    }
                    Log.v("title", String.valueOf(titlename));
                    final FavourListAdapter adapter=new FavourListAdapter(FavourListActivity.this, itemname, titlename);
                    list.setAdapter(adapter);
                    list.deferNotifyDataSetChanged();
                }else {
                    Toast.makeText(FavourListActivity.this, " There aren't any favourite", Toast.LENGTH_LONG).show();
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

    }

}
