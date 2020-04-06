package com.renata.mentesaudvel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.Adapter.ReadDetailUserAdapter;
import com.renata.mentesaudvel.Model.ReadItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ReadingListUserActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    Button addChildBtn,editTxtBtn;
    ImageView sectionImage;
    ListView listChild;
    TextView nameTV;
    List<ReadItem> readitems= new ArrayList<>();
    private ReadDetailUserAdapter readDetailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readinglistuser);

        Bundle extra = getIntent().getExtras();
        String readingID = extra.getString("readindid");


        databaseReference = FirebaseDatabase.getInstance().getReference("Readings").child(readingID);

        addChildBtn = (Button) findViewById(R.id.buttonAddChild);
        editTxtBtn = (Button) findViewById(R.id.editTxtBtn);
        sectionImage = (ImageView) findViewById(R.id.sectionImage);
        listChild = (ListView) findViewById(R.id.listChild);
        nameTV = (TextView) findViewById(R.id.sectiontitle);

        nameTV.setEnabled(false);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String imgID = dataSnapshot.child("reading_image").getValue(String.class);
                String name = dataSnapshot.child("reading_name").getValue(String.class);
                if(imgID.equals( "default" )){
                    Picasso.get().load(R.drawable.newitem).into(sectionImage);
                }
                else {
                    Picasso.get().load(imgID).into(sectionImage);
                }
                nameTV.setText(name);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        readDetailAdapter = new ReadDetailUserAdapter(ReadingListUserActivity.this, readitems );

    }
    @Override
    public void onStart() {
        super.onStart();
        databaseReference.child("items").addValueEventListener(mValueEventListener);

    }

    ValueEventListener mValueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            //clearing the previous Item list
            readitems.clear();
            //getting all nodes
            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                //getting Item from firebase console
                ReadItem Item = postSnapshot.getValue(ReadItem.class);

                readitems.add( Item );
            }

            listChild.setAdapter(readDetailAdapter);
//            pd.dismiss();

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };
}

