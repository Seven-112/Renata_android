package com.renata.mentesaudvel.DetailList;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.renata.mentesaudvel.DetailAdapter.FourListAdapter;
import com.renata.mentesaudvel.DetailAdapter.TwoSlideListAdapter;
import com.renata.mentesaudvel.R;

public class FourDetailList extends AppCompatActivity {
    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference
    String[] itemname ={
            "Evite ações que levam à agitação, preocupação e desgaste. Nem sempre podemos prever o que pode acontecer pouco antes de dormir, mas aquilo que depende de nós devemos fazer bem feito.\n" +
                    "Procure conversar assuntos mais sérios fora do horário de ir para cama. Ponha um freio mental em pensamentos de tomada de decisão em momentos de relaxamento. Mudar a vida dentro da cabeça na hora de ir dormir só gera ansiedade e perda de sono.",
            "Procure dormir e acordar sempre no mesmo horário, inclusive nos finais de semana.\n" +
                    "Não coma muito, nem tome grandes quantidades de líquido na hora de dormir. Faça, no máximo, uma refeição leve cerca de uma antes do seu horário habitual de ir para a cama, evitando temperos picantes e alimentos gordurosos.\n" +
                    "Evite nicotina e cafeína, pois são substâncias estimulantes.",
            "Pratique exercícios regularmente. Atividades aeróbicas aumentam o grau de relaxamento do corpo durante o sono. Mas atenção: os exercícios devem ser feito no mínimo duas horas antes do seu horário habitual de dormir. Praticar exercícios imediatamente antes de ir para cama podem dificultar a chegada do sono.\n" +
                    "Transforme seu quarto em um ambiente propício para o sono.",
            "O travesseiro e o colchão devem ser bem confortáveis. Nada de crianças ou animais no meio da cama no seu horário de dormir.\n" +
                    "Mantenha uma rotina relaxante antes do horário de ir para a cama. Por exemplo: tome um banho morno, leia um livro ou ouça uma música relaxante. Estas atividades, quando feitas à meia luz, estimulam a produção de hormônios relaxantes e preparam o corpo para uma boa noite de sono.",
            "Assim que sentir o sono se aproximando, deite-se na cama e apague as luzes. Se você não estiver dormindo após 30 minutos, levante-se e retome alguma atividade relaxante. Volte para a cama quando estiver sentindo sono novamente. O importante é não ficar agonizando na cama, angustiado por não estar dormindo – isto apenas afastará mais o sono.",
            "Comprimidos para dormir devem ser utilizados apenas com prescrição médica, ele quem avaliará a causa dessa insônia.\n" +
                    "Na hora de acordar, espreguice bastante, abra as cortinas ou as janelas e permita que o sol invada o quarto. \n" +
                    "Isso estimulará a produção dos hormônios que mantém o corpo no estado de vigília."


    };
    String[] titlename ={
            "",
            "",
            "",
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

        FourListAdapter adapter=new FourListAdapter(this, itemname, titlename);
        recyclerView.setAdapter(adapter);
    }
}
