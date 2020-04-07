package com.renata.mentesaudvel;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoPlayActivity extends AppCompatActivity {
    String audioCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplay);

        Bundle extra = getIntent().getExtras();
        String videoID = extra.getString("videoID");
        audioCheck = extra.getString("audioCheck");

        VideoView videoView =(VideoView)findViewById(R.id.vdVw);
        if(audioCheck.equals("1")){
            videoView.setBackgroundResource(R.drawable.green);
        }

        //Set MediaController  to enable play, pause, forward, etc options.
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        //Location of Media File
        Uri uri = Uri.parse(videoID);
        //Starting VideView By Setting MediaController and URI
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }
}