package com.renata.mentesaudvel.DetailList;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.renata.mentesaudvel.DetailAdapter.TwoSlideListAdapter;
import com.renata.mentesaudvel.R;

public class TwoDetailList extends AppCompatActivity {
    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference
    String[] itemname ={
            "Um estudo conduzido pelas Universidades de Harvard e Columbia mostrou que apostar na força da linguagem corporal para simbolizar poder realmente afeta as decisões do nosso inconsciente. De acordo com a pesquisa, quem faz isso tem chances 45% maiores de se arriscar na vida e de experimentar!",
            "Não precisa ser nenhuma musa fitness, não. Fazer exercícios físicos é imporante para liberar endorfinas no corpo – e isso também dá a sensação de cuidado. Na yoga, existem posições específicas para aumentar a autoconfiança, como as retroflexões, e também o equilíbrio emocional, como todas aquelas que fortalecem o abdômen.",
            "Permita-se uns agradinhos de vez em quando. Nem que seja uma paçoca depois do almoço, aquela blusinha linda que você encontrou na promoção ou um almoço no quilo mais gostosinho das redondezas…",
            "É óbvio que ser crítica consigo mesma é importante – caso contrário, as pessoas simplesmente sairiam por aí, inconsequentes, fazendo um monte de asneiras. Mas perfeito ninguém é.",
            "Desacelere para cuidar de si mesma: pode ser através do alongamento da coluna, a cada uma hora de trabalho; de uma caminhada silenciosa, depois do almoço; do preparo de um cházinho para acalmar o coração; de um sorvetinho especial naquele dia de sol ou da leitura diária, antes de dormir…",
            "Toda noite, tente escrever três caracerísticas suas que, ao longo do dia, te ajudaram ou deixaram feliz. Pode parecer bobo, mas esse exercício ajuda a valorizar traços da sua personalidade que, ao longo do tempo, você simplesmente esquece e passa a achar “normais”.",
            "Não fique se martirizando: errar é preciso. Só erra quem tenta – e que bom que você está tentando. Tente perdoar e cuidar de si mesma da mesma forma como um pai ou mãe faz com seu filho. Quebrar a cara é importante também, porque é assim aprendemos – além de evitar que o problema se repita no futuro.",
            "Cada um é bonito, interessante e feliz à sua própria maneira – e criar rankings imaginários de pessoas não vai te levar a lugar algum."

    };
    String[] titlename ={
            "Mantenha a postura ereta",
            "Faça exercício físico",
            "Dê agradinhos a si mesmo",
            "Imponha limites mais aceitáveis à sua autocrítica",
            "Faça pausas em meio às obrigações do cotidiano",
            "Valorize-se",
            "Lide com os erros como parte da vida",
            "Pare de se comparar com as outras pessoas"

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

        TwoSlideListAdapter adapter=new TwoSlideListAdapter(this, itemname, titlename);
        recyclerView.setAdapter(adapter);
    }
}
