package com.renata.mentesaudvel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.Adapter.AdminListAdapter;
import com.renata.mentesaudvel.List.SecondFeelListActivity;

import java.util.ArrayList;
import java.util.List;

public class AdminActivity extends AppCompatActivity {
    ListView list;
    TextView usernumber;
    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference
    List<String> username = new ArrayList<String>();
    List<String> email = new ArrayList<String>();
    List<String> gender = new ArrayList<String>();
    List<String> age = new ArrayList<String>();
    List<String> feelStatus = new ArrayList<String>();
    List<String> selectedUserid = new ArrayList<String>();
    List<String> user_num = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //getSupportActionBar().hide();
        setContentView(R.layout.activity_admin);
        list = (ListView)findViewById(R.id.list);
        usernumber = (TextView)findViewById(R.id.usernumber);

        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference usersRef = mDatabase.child("USER");
        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists())
                {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren())
                    {
                        String title = (String) dataSnapshot1.getKey();
                        user_num.add(title);
                        Log.v("tag", title);
                        DatabaseReference reference = usersRef.child(title);
                        Log.v("tag", String.valueOf(reference));
                        reference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                String name = dataSnapshot.child("userName").getValue(String.class);
                                String emailinfo = dataSnapshot.child("emailAddress").getValue(String.class);
                                String genderinfo = dataSnapshot.child("gender").getValue(String.class);
                                String ageinfo = dataSnapshot.child("age").getValue(String.class);
                                String feelstate = dataSnapshot.child("feelStatus").getValue(String.class);
                                String id = dataSnapshot.child("userId").getValue(String.class);

                                    username.add(name);
                                    email.add(emailinfo);
                                    gender.add(genderinfo);
                                    age.add(ageinfo);
                                    feelStatus.add(feelstate);
                                    selectedUserid.add(id);
                                    Log.v("name", String.valueOf(username));
                                AdminListAdapter adapter = new AdminListAdapter(AdminActivity.this, username, email, gender, age);
                                list.setAdapter(adapter);
//                                Log.i("user_number", String.valueOf(user_num.size()));
                                usernumber.setText(user_num.size()+" members");

                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(AdminActivity.this, FragmentAdminActivity.class);
                intent.putExtra("id", selectedUserid.get(position));
                intent.putExtra("userName", username.get(position));

                startActivity(intent);
            }
        });

    }
}
