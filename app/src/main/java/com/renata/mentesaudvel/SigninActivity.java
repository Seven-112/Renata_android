package com.renata.mentesaudvel;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.Model.User;
import com.renata.mentesaudvel.fragment.MoodFragment;

public class SigninActivity extends AppCompatActivity{
    DatabaseReference ref;
    private EditText email, pass;
    private Button login;
    private TextView tosignup;
    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference
    public static final String PREF_LOGIN = "LOGIN_PREF";
    public static final String KEY_CREDENTIALS = "LOGIN_CREDENTIALS";
    public String user_name = "";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //getSupportActionBar().hide();
        setContentView(R.layout.activity_signin);
        email = findViewById(R.id.emailAddress);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.login);
        tosignup = findViewById(R.id.toSignupBtn);

        tosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SigninActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseUser stateUser = auth.getCurrentUser();
        if (stateUser == null) {
            checkAdmin();
        } else {
            String userid = stateUser.getUid();
            ref = mDatabase.child("USER").child(userid);
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    User user = dataSnapshot.getValue(User.class);
                    String emailAddress = (String) dataSnapshot.child("emailAddress").getValue();
                    String passInfo = (String) dataSnapshot.child("password").getValue();
                    user_name = (String) dataSnapshot.child("userName").getValue();
                    email.setText(emailAddress);
                    pass.setText(passInfo);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String emailaddress = email.getText().toString();
                final String password = pass.getText().toString();
                if (TextUtils.isEmpty(emailaddress)) {
                    Toast.makeText(getApplicationContext(), R.string.empty_email, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), R.string.empty_password, Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(emailaddress, password)
                        .addOnCompleteListener(SigninActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Intent intent = new Intent(SigninActivity.this, FragmentActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {

                                    Toast.makeText(SigninActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    public void checkAdmin()
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(SigninActivity.this);
        alertDialog.setTitle("Are you Admin?");
        alertDialog.setMessage("Enter Password");

        final EditText input = new EditText(SigninActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);

        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String password;
                        password = input.getText().toString();
                        if (password.equals("123"))
                        {
                            SharedPreferences.Editor editor = getSharedPreferences(PREF_LOGIN, MODE_PRIVATE).edit();
                            editor.putString(KEY_CREDENTIALS, password);
                            editor.commit();
                            Intent intent = new Intent(SigninActivity.this, AdminActivity.class);
                            startActivity(intent);
                            finish();
                        }else
                        {
                            checkAdmin();
                        }
                    }
                });

        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        FirebaseUser user = auth.getCurrentUser();
                        if (user == null)
                        {
                            return;
                        }else
                        {
                            String userid = user.getUid();
                            DatabaseReference ref = mDatabase.child("USER").child(userid);
                            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String emailinfo = (String) dataSnapshot.child("emailAddress").getValue();
                                    String password = (String) dataSnapshot.child("password").getValue();
                                    email.setText(emailinfo);
                                    pass.setText(password);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                        }

                    }
                });

        alertDialog.show();
    }

}
