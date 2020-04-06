package com.renata.mentesaudvel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.SearchEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.renata.mentesaudvel.Adapter.AdminListAdapter;
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


public class MainListActivity extends AppCompatActivity {

    ListView list;

    String[] itemname ={
            "Alimentacaoconsciente",
            "autoestima",
            "Felicidade",
            "Financas",
            "Gratidao",
            "meditacao",
            "Quarentenaport",
            "reduziransiedade",
            "Sono"

    };
    Integer[] imgid={
            R.drawable.gratitude,
            R.drawable.anxiety,
            R.drawable.esteen,
            R.drawable.medifcation,
            R.drawable.sleep,
            R.drawable.helthyfood,
            R.drawable.money,
            R.drawable.happy,
            R.drawable.happy
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_main_list);
        list=(ListView)findViewById(R.id.list);
        Button favour = (Button) findViewById(R.id.favourite);
        favour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainListActivity.this, FavourListActivity.class);
                startActivity(intent);
            }
        });
//        SectionListAdapter adapter=new SectionListAdapter(MainListActivity.this, itemname, imgid);
//        list.setAdapter(adapter);
//        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                String Selecteditem= itemname[+position];
                Log.d("Position",Selecteditem);
                switch(position){
                    case 0:
                        Intent intent = new Intent(MainListActivity.this, OneListActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(MainListActivity.this, TwoListActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(MainListActivity.this, ThreeListActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(MainListActivity.this, FourListActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(MainListActivity.this, FiveListActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(MainListActivity.this, SixListActivity.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(MainListActivity.this, SevenListActivity.class);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(MainListActivity.this, EightListActivity.class);
                        startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(MainListActivity.this, NineListActivity.class);
                        startActivity(intent8);
                        break;

                    default: //For all other cases, do this
                        break;
                }

            }
        });

    }
}
