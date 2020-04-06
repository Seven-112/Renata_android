package com.renata.mentesaudvel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class SubmitActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private DatabaseReference mDatabase; //TODO; database reference
    private static final String PREF_LOGIN = "LOGIN_PREF";
    private static final String KEY_CREDENTIALS = "LOGIN_CREDENTIALS";
    EditText situ, thin, act;
    Button sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //getSupportActionBar().hide();
        setContentView(R.layout.activity_submit);
        situ = findViewById(R.id.situationDescription);
        thin = findViewById(R.id.thoughtDescrioption);
        act = findViewById(R.id.actionDescrioption);
        sub = findViewById(R.id.clickBtn);
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseUser me = auth.getCurrentUser();
        String myId = me.getUid();
        final Date currentTime = Calendar.getInstance().getTime();

        Bundle time = getIntent().getExtras();
        final String nowtime = time.getString("nowTime");
        final DatabaseReference subRef = mDatabase.child("USER").child(myId);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subRef.child("situation").child(nowtime).setValue(situ.getText().toString());
                subRef.child("thought").child(nowtime).setValue(thin.getText().toString());
                subRef.child("action").child(nowtime).setValue(act.getText().toString());
                Intent intent = new Intent(SubmitActivity.this, MainListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
