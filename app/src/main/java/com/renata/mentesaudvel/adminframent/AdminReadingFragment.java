package com.renata.mentesaudvel.adminframent;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.renata.mentesaudvel.Adapter.SectionListAdapter;
import com.renata.mentesaudvel.List.EightListActivity;
import com.renata.mentesaudvel.List.FavourListActivity;
import com.renata.mentesaudvel.List.FiveListActivity;
import com.renata.mentesaudvel.List.FourListActivity;
import com.renata.mentesaudvel.List.NineListActivity;
import com.renata.mentesaudvel.List.OneListActivity;
import com.renata.mentesaudvel.List.SevenListActivity;
import com.renata.mentesaudvel.List.SixListActivity;
import com.renata.mentesaudvel.List.ThreeListActivity;
import com.renata.mentesaudvel.List.TwoListActivity;
import com.renata.mentesaudvel.MainListActivity;
import com.renata.mentesaudvel.Model.Reading;
import com.renata.mentesaudvel.R;
import com.renata.mentesaudvel.ReadingListAdminActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link com.renata.mentesaudvel.adminframent.AdminReadingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdminReadingFragment extends Fragment {

    ListView list;
    Button addBtn;
    DatabaseReference databaseReference;
    List<Reading> readings = new ArrayList<>();
    private SectionListAdapter ReadingAdapter;
    Boolean scrollKeyParent = true;

    Parcelable state;

    String[] itemname ={
            "Alimentação consciente",
            "Autoestima",
            "Felicidade",
            "Finanças",
            "Gratidão",
            "Meditação",
            "Quarentena",
            "Controlar a ansiedade",
            "Melhorar o sono"
    };
    Integer[] imgid={
            R.drawable.helthyfood,
            R.drawable.esteen,
            R.drawable.happy,
            R.drawable.money,
            R.drawable.gratitude,
            R.drawable.medifcation,
            R.drawable.quarentena,
            R.drawable.anxiety,
            R.drawable.sleep
    };

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public AdminReadingFragment() {
        // Required empty public constructor
    }
    public static com.renata.mentesaudvel.adminframent.AdminReadingFragment newInstance(String param1, String param2) {
        com.renata.mentesaudvel.adminframent.AdminReadingFragment fragment = new com.renata.mentesaudvel.adminframent.AdminReadingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fregment_admin_reading, container, false);
        list=(ListView) root.findViewById(R.id.list);
        state = list.onSaveInstanceState();
        addBtn=(Button) root.findViewById(R.id.buttonAdd) ;

        databaseReference = FirebaseDatabase.getInstance().getReference("Readings");

//        Button favour = (Button) root.findViewById(R.id.favourite);
//        favour.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), FavourListActivity.class);
//                startActivity(intent);
//            }
//        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = databaseReference.push().getKey();

                Reading Item = new Reading(id, "default","default","default","default"," / / / / / / / ");
                //Saving the Item
                databaseReference.child(id).setValue(Item);
                scrollKeyParent = false;

//                Toast.makeText(getActivity(),"An Item Added.",Toast.LENGTH_SHORT).show();
            }
        });
        ReadingAdapter = new SectionListAdapter(getActivity(), readings );

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Reading Item = readings.get(position);
                String readingID= Item.getreading_id();
                Intent intent = new Intent(getActivity(), ReadingListAdminActivity.class);
                intent.putExtra("readingid",readingID);
                startActivity(intent);
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
                builder1.setTitle("Deseja excluir este conteúdo?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "sim",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Reading Item = readings.get(position);
                                String readingID= Item.getreading_id();
                                deleteItem(readingID);
                            }
                        });

                builder1.setNegativeButton(
                        "não",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.setIcon(R.drawable.warning);
                alert11.show();

                return true;
            }
        });



        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(mValueEventListener);

    }

    ValueEventListener mValueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            //clearing the previous Item list
            readings.clear();
            //getting all nodes
            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                //getting Item from firebase console
                Reading Item = postSnapshot.getValue( Reading.class);

                readings.add( Item );
            }
            if(!scrollKeyParent){

                list.post(new Runnable(){
                    public void run() {
                        list.setSelection(list.getCount() - 1);
                    }});
            }

            list.setAdapter(ReadingAdapter);
            list.onRestoreInstanceState(state);
//            pd.dismiss();

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }

    };

    private boolean deleteItem(String id) {
        //getting the specified Item reference
        DatabaseReference DeleteReference = FirebaseDatabase.getInstance().getReference("Readings").child(id);
        //removing Item
        DeleteReference.removeValue();
        Toast.makeText(getContext(), "Excluído!", Toast.LENGTH_LONG).show();
        return true;

    }
}

