package com.renata.mentesaudvel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.SettingInjectorService;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
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

public class SignUpActivity extends AppCompatActivity {
    private EditText name, email, pass, confirm, age;
    private Button register;
    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;

    public static final String PREF_LOGIN = "LOGIN_PREF";
    public static final String KEY_CREDENTIALS = "LOGIN_CREDENTIALS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //getSupportActionBar().hide();
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.ownerName);
        email = findViewById(R.id.emailAddress);
        pass = findViewById(R.id.password);
        confirm = findViewById(R.id.confirmPassword);
        age = findViewById(R.id.age);
        TextView tosignin = findViewById(R.id.toSignipBtn);
        tosignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(SignUpActivity.this, SigninActivity.class);
                    startActivity(intent);
                    finish();

            }
        });
        TextView terms = findViewById(R.id.terms);
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, TermsActivity.class);
                startActivity(intent);
            }
        });

        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
        register = findViewById(R.id.register);
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseUser stateUser = auth.getCurrentUser();

        checkAdmin();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                if (radioSexGroup.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(getApplicationContext(), R.string.empty_gender, Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    Log.d("gender", radioSexButton.getText().toString());
                    creatUser();
                }

            }
        });
    }
    public void creatUser(){
        final String emailinfo = email.getText().toString();
        final String passwordinfo = pass.getText().toString();
        final String nameinfo = name.getText().toString();
        final String confirmStatus = confirm.getText().toString();
        final String ageinfo = age.getText().toString();
        if (TextUtils.isEmpty(nameinfo)) {
            Toast.makeText(getApplicationContext(), R.string.empty_name, Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(emailinfo)) {
            Toast.makeText(getApplicationContext(), R.string.empty_email, Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(passwordinfo)) {
            Toast.makeText(getApplicationContext(), R.string.empty_password, Toast.LENGTH_SHORT).show();
            return;
        }
        if (passwordinfo.length() < 6) {
            Toast.makeText(getApplicationContext(), R.string.shorter_password, Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(confirmStatus) || !confirmStatus.equals(passwordinfo)) {
            Toast.makeText(getApplicationContext(), R.string.diff_password, Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(ageinfo)) {
            Toast.makeText(getApplicationContext(), R.string.empty_age, Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(emailinfo, passwordinfo)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = auth.getCurrentUser();
                            String userID = user.getUid();
                            final DatabaseReference mRef = mDatabase.child("USER").child(userID);
                            User mUser = new User(userID, ageinfo, radioSexButton.getText().toString(), nameinfo, emailinfo, passwordinfo, "", "", "", "","");
                            mRef.setValue(mUser).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    mRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            User mUser = dataSnapshot.getValue(User.class);
                                            String name = mUser.getUserName();
                                            Log.v("tag", name);
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                }
                            });
                            Toast.makeText(SignUpActivity.this, "Register is successful!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SignUpActivity.this, FragmentActivity.class);
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(SignUpActivity.this, "authentication failed", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
    public void checkAdmin()
    {
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(SignUpActivity.this);
        alertDialog.setTitle("Você é administrador?");
        alertDialog.setMessage("Digite a senha do administrador");

        final EditText input = new EditText(SignUpActivity.this);
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
                            Intent intent = new Intent(SignUpActivity.this, AdminActivity.class);
                            startActivity(intent);
                            finish();
                        }else
                        {
                            SharedPreferences.Editor editor = getSharedPreferences(PREF_LOGIN, MODE_PRIVATE).edit();
                            editor.clear();
                            editor.commit();
                            checkAdmin();
                        }
                    }
                });

        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }

}

