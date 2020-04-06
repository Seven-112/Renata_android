package com.renata.mentesaudvel.Adapter;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.R;

public class DetailListAdapter extends ArrayAdapter<String> {


    private final Activity context;
    private final String[] itemname;
    private final String order;
    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference
    public DetailListAdapter(Activity context, String[] itemname, String order) {
        super(context, R.layout.detail_list, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.order = order;
    }

    public View getView(final int position, final View view, ViewGroup parent) {
        final LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.detail_list, null,true);
        TextView extratxt = (TextView) rowView.findViewById(R.id.detailText);
        final ImageView readStatus = (ImageView) rowView.findViewById(R.id.readyStatus);
        final ImageView bookmark = (ImageView) rowView.findViewById(R.id.bookmark);
        ImageView copyToClipboard = rowView.findViewById(R.id.copied);
        extratxt.setText(itemname[position]);
        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = auth.getCurrentUser();
        final String userID = user.getUid();
        final DatabaseReference statusRef = mDatabase.child("HISTORY").child(userID).child(order + "-" + position);
        final DatabaseReference bookRef = mDatabase.child("HISTORY").child(userID).child(order + "-" + position);
        final DatabaseReference mRef = mDatabase.child("HISTORY").child(userID);
        final DatabaseReference bookmarkRef = mDatabase.child("FAVOURITE").child(userID);
        statusRef.addValueEventListener(new ValueEventListener() {
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
        bookRef.addValueEventListener(new ValueEventListener() {
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
            public void onClick(final View v) {

                mRef.child(order + "-" + position).child("readStatus").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            String readingStatus = (String) dataSnapshot.getValue();
                            if (readingStatus.equals("1")){
                                readStatus.setImageResource(R.drawable.check);
                                mRef.child(order + "-" + position).child("readStatus").setValue("0");
                                Toast.makeText(v.getContext(), "Marcado como não lido", Toast.LENGTH_SHORT).show();
                            }else {
                                readStatus.setImageResource(R.drawable.checked);
                                mRef.child(order + "-" + position).child("readStatus").setValue("1");
                                Toast.makeText(v.getContext(), "Marcado como lido", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            readStatus.setImageResource(R.drawable.checked);
                            mRef.child(order + "-" + position).child("readStatus").setValue("1");
                            Toast.makeText(v.getContext(), "Marcado como lido", Toast.LENGTH_SHORT).show();
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
            public void onClick(final View v) {

                mRef.child(order + "-" + position).child("bookmark").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            String readingStatus = (String) dataSnapshot.getValue();
                            if (readingStatus.equals("1")){
                                bookmark.setImageResource(R.drawable.book);
                                mRef.child(order + "-" + position).child("bookmark").setValue("0");
                                bookmarkRef.child(order + "-" + position).removeValue();
                                Toast.makeText(v.getContext(), "Removido dos Favoritos", Toast.LENGTH_SHORT).show();
                            }else {
                                bookmark.setImageResource(R.drawable.booked);
                                mRef.child(order + "-" + position).child("bookmark").setValue("1");
                                bookmarkRef.child(order + "-" + position).setValue(itemname[position]);
                                Toast.makeText(v.getContext(), "Adicionar aos favoritos", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            bookmark.setImageResource(R.drawable.booked);
                            mRef.child(order + "-" + position).child("bookmark").setValue("1");
                            bookmarkRef.child(order + "-" + position).setValue(itemname[position]);
                            Toast.makeText(v.getContext(), "Adicionar aos favoritos", Toast.LENGTH_SHORT).show();
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
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("text", itemname[position]);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(v.getContext(), "Copiado para a área de transferência", Toast.LENGTH_SHORT).show();
                Log.d("clip", "" + clip);
            }
        });

        return rowView;

    }

}