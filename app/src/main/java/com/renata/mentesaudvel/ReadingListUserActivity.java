package com.renata.mentesaudvel;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadingListUserActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    Button addChildBtn,editTxtBtn,audioFileBtn1,audioFileBtn2,videoFileBtn;
    ImageView sectionImage;
    ListView listChild;
    TextView nameTV;
    List<ReadItem> readitems= new ArrayList<>();
    private ReadDetailUserAdapter readDetailAdapter;

    MediaPlayer player;
    String firstFile,secondFile,thirdFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readinglistuser);

        Bundle extra = getIntent().getExtras();
        String readingID = extra.getString("readingid");


        databaseReference = FirebaseDatabase.getInstance().getReference("Readings").child(readingID);

        addChildBtn = (Button) findViewById(R.id.buttonAddChild);
        editTxtBtn = (Button) findViewById(R.id.editTxtBtn);
        sectionImage = (ImageView) findViewById(R.id.sectionImage);
        listChild = (ListView) findViewById(R.id.listChild);
        nameTV = (TextView) findViewById(R.id.sectiontitle);

        audioFileBtn1 = (Button) findViewById(R.id.firstAudioFile) ;
        audioFileBtn2 = (Button) findViewById(R.id.secondAudioFile) ;
        videoFileBtn = (Button) findViewById(R.id.videoFile) ;

        player = new MediaPlayer();

        nameTV.setEnabled(false);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String imgID = dataSnapshot.child("reading_image").getValue(String.class);
                String name = dataSnapshot.child("reading_name").getValue(String.class);
                firstFile = dataSnapshot.child("reading_first_file").getValue(String.class);
                secondFile = dataSnapshot.child("reading_second_file").getValue(String.class);
                thirdFile = dataSnapshot.child("reading_third_file").getValue(String.class);

                if(imgID.equals( "default" )){
                    Picasso.get().load(R.drawable.newitem).into(sectionImage);
                }
                else {
                    Picasso.get().load(imgID).into(sectionImage);
                }
                nameTV.setText(name);
                if(firstFile.equals( "default" )){
                    audioFileBtn1.setVisibility(View.GONE);
                    audioFileBtn2.setText("Audio");
                }
                if(secondFile.equals( "default" )){
                    audioFileBtn2.setVisibility(View.GONE);
                    audioFileBtn1.setText("Audio");
                }
                if(thirdFile.equals( "default" )){
                    videoFileBtn.setVisibility(View.GONE);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        readDetailAdapter = new ReadDetailUserAdapter(ReadingListUserActivity.this, readitems );

        audioFileBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                try {
//                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
//                    if (player.isPlaying()){
//                        player.stop();
//                        player.reset();
//                    }
//                    player.setDataSource(ReadingListUserActivity.this, Uri.parse(firstFile));
//                    player.prepare();
//                    player.start();
//                } catch(Exception e) {
//                    System.out.println(e.toString());
//                }
                Intent intent = new Intent(ReadingListUserActivity.this, VideoPlayActivity.class);
                intent.putExtra("videoID",firstFile);
                intent.putExtra("audioCheck","1");
                startActivity(intent);
            }
        });

        audioFileBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadingListUserActivity.this, VideoPlayActivity.class);
                intent.putExtra("videoID",secondFile);
                intent.putExtra("audioCheck","1");
                startActivity(intent);
            }
        });

        videoFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadingListUserActivity.this, VideoPlayActivity.class);
                intent.putExtra("videoID",thirdFile);
                intent.putExtra("audioCheck","0");
                startActivity(intent);
            }
        });

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

