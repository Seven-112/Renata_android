package com.renata.mentesaudvel.DetailAdapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.DetailList.ThreeDetailList;
import com.renata.mentesaudvel.DetailList.TwoDetailList;
import com.renata.mentesaudvel.R;

import static android.content.Context.CLIPBOARD_SERVICE;

public class ThreeListAdapter extends RecyclerView.Adapter<ThreeListAdapter.MyViewHolder> {

    private final String[] itemname;
    private final String[] titlename;
    TextView extratxt, titletxt;
    ImageView readStatus, bookmark, copyToClipboard;
    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference
    class MyViewHolder extends RecyclerView.ViewHolder {

        MyViewHolder(View view) {
            super(view);
            extratxt = (TextView) view.findViewById(R.id.detailText);
            titletxt = (TextView) view.findViewById(R.id.titleTextView);
            readStatus = (ImageView) view.findViewById(R.id.readyStatus);
            bookmark = (ImageView) view.findViewById(R.id.bookmark);
            copyToClipboard = view.findViewById(R.id.copied);



        }
    }


    public ThreeListAdapter(ThreeDetailList ThreeDetailList, String[] itemname, String[] titlename) {

        this.itemname=itemname;
        this.titlename=titlename;
    }
    @NonNull
    @Override
    public ThreeListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.slide_list, parent, false);
        return new ThreeListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ThreeListAdapter.MyViewHolder holder, final int position) {
        extratxt.setText(itemname[position]);
        titletxt.setText(titlename[position]);
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = auth.getCurrentUser();
        final String userID = user.getUid();
        final DatabaseReference statusRef = mDatabase.child("HISTORY").child(userID).child(titlename[position]);
        final DatabaseReference bookRef = mDatabase.child("HISTORY").child(userID).child(titlename[position]);
        final DatabaseReference mRef = mDatabase.child("HISTORY").child(userID);
        final DatabaseReference bookmarkRef = mDatabase.child("FAVOURITE").child(userID);
        statusRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    if (dataSnapshot.child("readStatus").exists()){
                        String read = (String) dataSnapshot.child("readStatus").getValue();

                        if (read.equals("1")){
                            readStatus.setImageResource(R.drawable.checked);
                            return;
                        }
                    }
                    else {
                        return;
                    }

                }else {
                    return;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        bookRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    if (dataSnapshot.child("bookmark").exists()){
                        String book = (String) dataSnapshot.child("bookmark").getValue();
                        if (book.equals("1")){
                            bookmark.setImageResource(R.drawable.booked);
                            return;
                        }
                    }
                    else {
                        return;
                    }

                }else {
                    return;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        readStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mRef.child(titlename[position]).child("readStatus").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            String readingStatus = (String) dataSnapshot.getValue();
                            if (readingStatus.equals("1")){
                                readStatus.setImageResource(R.drawable.check);
                                mRef.child(titlename[position]).child("readStatus").setValue("0");
                            }else {
                                readStatus.setImageResource(R.drawable.checked);
                                mRef.child(titlename[position]).child("readStatus").setValue("1");
                            }
                        }else {
                            readStatus.setImageResource(R.drawable.checked);
                            mRef.child(titlename[position]).child("readStatus").setValue("1");
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mRef.child(titlename[position]).child("bookmark").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            String readingStatus = (String) dataSnapshot.getValue();
                            if (readingStatus.equals("1")){
                                bookmark.setImageResource(R.drawable.book);
                                mRef.child(titlename[position]).child("bookmark").setValue("0");
                                bookmarkRef.child(titlename[position]).removeValue();
                            }else {
                                bookmark.setImageResource(R.drawable.booked);
                                mRef.child(titlename[position]).child("bookmark").setValue("1");
                                bookmarkRef.child(titlename[position]).setValue(itemname[position]);
                            }
                        }else {
                            bookmark.setImageResource(R.drawable.booked);
                            mRef.child(titlename[position]).child("bookmark").setValue("1");
                            bookmarkRef.child(titlename[position]).setValue(itemname[position]);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        copyToClipboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager) v.getContext().getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("text", titlename[position] + "\n" + itemname[position]);
                clipboard.setPrimaryClip(clip);
                Log.d("clip", "" + clip);
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemname.length;
    }

}
