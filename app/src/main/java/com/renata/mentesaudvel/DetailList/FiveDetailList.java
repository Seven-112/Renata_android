package com.renata.mentesaudvel.DetailList;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.renata.mentesaudvel.DetailAdapter.FiveListAdapter;
import com.renata.mentesaudvel.DetailAdapter.FourListAdapter;
import com.renata.mentesaudvel.R;

public class FiveDetailList extends AppCompatActivity {
    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference
    String[] itemname ={
            "Inclua alimentos anti-inflamatórios na sua dieta, eles podem te livrar de várias doenças.\n" +
                    "Não faça uma alimentação baseada em um único tipo de alimento ou nutriente. Tente variar ao máximo os alimentos.\n" +
                    "Inclua de 1 a 2 porções de frutas diariamente.\n" +
                    "Com relação às carnes, tente variar os tipos durante a semana (peixe, frango, peru, contrafilé, porco) e de preferência consuma apenas uma vez ao dia.",
            "Diminua a quantidade de bebidas açucaradas, inclua mais suco verde, chás, suco de fruta e água.\n" +
                    "Quer deixar de consumir algum alimento? Não compre-o! \n" +
                    "Tome pelo menos 1,5 litro de água ao dia.",
            "Gosta de comer um docinho? Pode comer, mas inclua fibras na alimentação. As fibras ajudam absorver o açúcar do organismo. Ou opte por doces caseiros como por exemplo brigadeiro com cacau.\n" +
                    "Não se esqueça de ter uma dieta rica em proteínas. A proteína é super importante para o bom funcionamento do corpo.\n" +
                    "Inclua legumes e verduras nas principais refeições. Inclua suplementos anti-inflamatórios como por exemplo o resveratrol"

    };
    String[] titlename ={
            "",
            "",
            ""

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_slide);
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        recyclerView.setLayoutManager(mLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());

        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        FiveListAdapter adapter=new FiveListAdapter(this, itemname, titlename);
        recyclerView.setAdapter(adapter);
    }
}

