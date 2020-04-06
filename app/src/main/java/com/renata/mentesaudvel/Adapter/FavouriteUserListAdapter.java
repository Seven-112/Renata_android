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

public class FavouriteUserListAdapter extends ArrayAdapter<ReadItem> {

    private final Activity context;
    List<ReadItem> readitems;
    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference
    public FavouriteUserListAdapter(Activity context, List<ReadItem> readItems) {
        super(context, R.layout.favour_list2);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.readitems=readItems;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final LayoutInflater inflater=context.getLayoutInflater();
        final View rowView = inflater.inflate(R.layout.favour_list2, null,true);
        final TextView extratxt = (TextView) rowView.findViewById(R.id.detailText);
        final TextView titletxt = (TextView) rowView.findViewById(R.id.titleTextView);
        final ImageView readStatus = (ImageView) rowView.findViewById(R.id.readyStatus);
        final ImageView bookmark = (ImageView) rowView.findViewById(R.id.bookmark);
        final ImageView copyToClipboard = rowView.findViewById(R.id.copied);
//        readStatus.setVisibility(View.GONE);
//        bookmark.setVisibility(View.GONE);
//        copyToClipboard.setVisibility(View.GONE);
//        extratxt.setText(itemname[position]);
//        titletxt.setText(titlename[position]);

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

        //TODO; read status check !
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
        //TODO; bookmark status check!
        bookRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    if (dataSnapshot.child("bookmark").exists()){
                        String book = (String) dataSnapshot.child("bookmark").getValue();
                        if (book.equals("1")){
                            bookmark.setImageResource(R.drawable.booked);
                            extratxt.setText(readitems.get(position).getreaditem_detail());
//                            titletxt.setText(titlename.get(position));
//                            readStatus.setVisibility(View.VISIBLE);
//                            bookmark.setVisibility(View.VISIBLE);
//                            copyToClipboard.setVisibility(View.VISIBLE);
                            return;
                        }else {
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
                            readStatus.setImageResource(R.drawable.check);
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
                            bookmark.setImageResource(R.drawable.book);
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
                ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("text", readitems.get(position).getreaditem_detail());
                clipboard.setPrimaryClip(clip);
                Toast.makeText(v.getContext(), "Copiado para a área de transferência", Toast.LENGTH_SHORT).show();
                Log.d("clip", "" + clip);
            }
        });

        return rowView;

    }

}