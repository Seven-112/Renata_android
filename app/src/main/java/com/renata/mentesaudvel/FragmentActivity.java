package com.renata.mentesaudvel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.Model.Messages;
import com.renata.mentesaudvel.fragment.FavouriteFragment;
import com.renata.mentesaudvel.fragment.MessageFragment;
import com.renata.mentesaudvel.fragment.MoodFragment;
import com.renata.mentesaudvel.fragment.ReadingFragment;
import com.renata.mentesaudvel.fragment.HistoryFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentActivity extends AppCompatActivity {

    String name = "";
    Intent extra;
    DatabaseReference userData;
    BottomNavigationView bottomNavigation;
    private DatabaseReference rootRef;
    Boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            getSupportActionBar().hide();
        }
        catch (Exception e) {

        }
        setContentView(R.layout.activity_fragment);

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        userData = FirebaseDatabase.getInstance().getReference().child("USER").child(userId);
        userData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                name = (String) dataSnapshot.child("userName").getValue();
                openFragment(MoodFragment.newInstance(name, ""));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.navigation_mood:
                            openFragment(MoodFragment.newInstance(name, ""));
                            return true;
                        case R.id.navigation_reading:
                            openFragment(ReadingFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_message:
                            openFragment(MessageFragment.newInstance("", ""));
                            return true;
                        case R.id.navigation_favourite:
                            openFragment(FavouriteFragment.newInstance("",""));
                            return true;
                        case R.id.navigation_history:
                            openFragment(HistoryFragment.newInstance("", ""));
                            return true;
                    }
                    return false;
                }
            };

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish();
        } else {
            Toast.makeText(this, this.getString(R.string.press_back_again_to_exit), Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3000);
        }

    }
}