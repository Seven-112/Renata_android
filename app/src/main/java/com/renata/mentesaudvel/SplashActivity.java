package com.renata.mentesaudvel;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class SplashActivity extends AppCompatActivity {
    Handler handler;
    private int notificationId = 1;
    private FirebaseAuth auth;
    private DatabaseReference mDatabase,datehis; //TODO; database reference
    private static final String PREF_LOGIN = "LOGIN_PREF";
    private static final String KEY_CREDENTIALS = "LOGIN_CREDENTIALS";
    private StringBuilder dates = new StringBuilder();
    private String userID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        final FirebaseUser user = auth.getCurrentUser();
        if (user != null) {
            userID = user.getUid();
            datehis = mDatabase.child("USER").child(userID).child("dateHistory");
            gotoNotification();
        }



        DatabaseReference str = mDatabase.child("STRING");
        str.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String string = (String) dataSnapshot.getValue();
                Log.v("str", string);
                if (string.equals("0")) {
                    //TODO; splash screen control
                    handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            SharedPreferences preferences = getSharedPreferences(PREF_LOGIN, MODE_PRIVATE);

                            Intent intent = null;
                            if(preferences.contains(KEY_CREDENTIALS)){
                                intent = new Intent(SplashActivity.this, AdminActivity.class);
                                startActivity(intent);
                                finish();
                            }else {
                                if (user != null){
                                    Intent intent1 = new Intent(SplashActivity.this, SigninActivity.class);
                                    startActivity(intent1);
                                    finish();
                                }else {
                                    Intent intent2 = new Intent(SplashActivity.this, SignUpActivity.class);
                                    startActivity(intent2);
                                    finish();
                                }
                            }

                        }
                    },3000);
                }else {
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




    }

    private void gotoNotification() {
        final String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        datehis.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        final String key = (String) dataSnapshot1.getKey();
                        dates.append(key);

                    }
                    if (!dates.toString().contains(currentDate)) {
                        Intent intent = new Intent(SplashActivity.this, AlarmReceiver.class);
                        intent.putExtra("notificationId", notificationId);
//        intent.putExtra("todo", eventid);

                        // getBroadcast(context, requestCode, intent, flags)
                        PendingIntent alarmIntent = PendingIntent.getBroadcast(SplashActivity.this, 0,
                                intent, PendingIntent.FLAG_CANCEL_CURRENT);

                        AlarmManager alarm = (AlarmManager) SplashActivity.this.getSystemService(ALARM_SERVICE);

                        Calendar startTime = Calendar.getInstance();
//        startTime.set(Calendar.DAY_OF_YEAR,year);
//        startTime.set(Calendar.DAY_OF_MONTH,month);
//        startTime.set(Calendar.DATE,day);

                        startTime.set(Calendar.HOUR_OF_DAY, 20);
                        startTime.set(Calendar.MINUTE, 0);
                        startTime.set(Calendar.SECOND, 0);
                        long alarmStartTime = startTime.getTimeInMillis();

                        alarm.set(AlarmManager.RTC_WAKEUP, alarmStartTime, alarmIntent);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
