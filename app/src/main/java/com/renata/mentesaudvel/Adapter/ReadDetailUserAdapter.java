package com.renata.mentesaudvel.Adapter;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
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
import com.renata.mentesaudvel.Model.ReadItem;
import com.renata.mentesaudvel.R;

import java.util.List;

public class ReadDetailUserAdapter extends ArrayAdapter<ReadItem> {

    private final Activity context;
    List<ReadItem> readitems;

    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference

    public ReadDetailUserAdapter(Activity context, List<ReadItem> readitems) {
        super(context, R.layout.read_detail_listuser,readitems);
        this.context = context;
        this.readitems = readitems;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.read_detail_listuser, null,true);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.sectionImage);
        TextView extratxt = (TextView) rowView.findViewById(R.id.detailText);

        final ImageView readStatus = (ImageView) rowView.findViewById(R.id.readyStatus);
        final ImageView bookmark = (ImageView) rowView.findViewById(R.id.bookmark);
        ImageView copyToClipboard = rowView.findViewById(R.id.copied);

        final ReadItem Item = readitems.get(position);

        extratxt.setText(Item.getreaditem_detail());

        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = auth.getCurrentUser();
        final String userID = user.getUid();

        final DatabaseReference statusRef = mDatabase.child("HISTORY").child(userID).child(Item.getreaditem_id());
        final DatabaseReference bookRef = mDatabase.child("HISTORY").child(userID).child(Item.getreaditem_id());
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

                mRef.child(Item.getreaditem_id()).child("readStatus").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            String readingStatus = (String) dataSnapshot.getValue();
                            if (readingStatus.equals("1")){
                                readStatus.setImageResource(R.drawable.check);
                                mRef.child(Item.getreaditem_id()).child("readStatus").setValue("0");
                                Toast.makeText(v.getContext(), "Marcado como não lido", Toast.LENGTH_SHORT).show();
                            }else {
                                readStatus.setImageResource(R.drawable.checked);
                                mRef.child(Item.getreaditem_id()).child("readStatus").setValue("1");
                                Toast.makeText(v.getContext(), "Marcado como lido", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            readStatus.setImageResource(R.drawable.checked);
                            mRef.child(Item.getreaditem_id()).child("readStatus").setValue("1");
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

                mRef.child(Item.getreaditem_id()).child("bookmark").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()){
                            String readingStatus = (String) dataSnapshot.getValue();
                            if (readingStatus.equals("1")){
                                bookmark.setImageResource(R.drawable.book);
                                mRef.child(Item.getreaditem_id()).child("bookmark").setValue("0");
                                bookmarkRef.child(Item.getreaditem_id()).removeValue();
                                Toast.makeText(v.getContext(), "Removido dos Favoritos", Toast.LENGTH_SHORT).show();
                            }else {
                                bookmark.setImageResource(R.drawable.booked);
                                mRef.child(Item.getreaditem_id()).child("bookmark").setValue("1");
                                bookmarkRef.child(Item.getreaditem_id()).setValue(readitems.get(position));
                                Toast.makeText(v.getContext(), "Adicionar aos favoritos", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            bookmark.setImageResource(R.drawable.booked);
                            mRef.child(Item.getreaditem_id()).child("bookmark").setValue("1");
                            bookmarkRef.child(Item.getreaditem_id()).setValue(readitems.get(position));
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
                String detail = readitems.get(position).getreaditem_detail();
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("text", detail);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(v.getContext(), "Copiado para a área de transferência", Toast.LENGTH_SHORT).show();
                Log.d("clip", "" + clip);
            }
        });
        return rowView;

    }
}
