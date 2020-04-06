package com.renata.mentesaudvel.DetailList;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.renata.mentesaudvel.DetailAdapter.SlideListAdapter;
import com.renata.mentesaudvel.R;

public class OneDetailList extends AppCompatActivity {
    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference
    String[] itemname ={
            "A forma mais comum de controlar a ansiedade é a prática de exercícios. Praticar atividades físicas ajuda a lidar com estados de ansiedade, porque eleva a produção de serotonina, substância que aumenta a sensação de prazer. Caminhar três vezes por semana, por pelo menos meia hora, já pode ajudar a lidar com a ansiedade. O momento da caminhada, além de ser um exercício para o corpo, também pode ser aproveitado para trabalhar a mente, sob a forma da meditação ativa. Quando você anda, pensa.",
            "Pessoas com tendência à ansiedade precisam reduzir o seu estresse diário e existem diversas formas de fazer isso. A ioga oferece ao praticante a possibilidade de aprender a controlar sua mente e seu corpo. Este controle, que é obtido através de uma combinação de técnicas respiratórias, corporais e de meditação. Tem como resultados o aumento da flexibilidade, fortalecimento dos músculos, aumento de vitalidade e maior controle sobre o estresse.",
            "Para reduzir as reações do sistema nervoso autônomo, devemos fazer o controle da respiração. Isto pode ser feito compassando a respiração e inspirando lentamente pelo nariz, com a boca fechada.\n" +
                    "Ao inspirar, deixar o abdômen expandir-se, ou seja, estufar a barriga e não o peito. Depois, expirar lentamente, expelindo o ar pela boca. Isto pode ser feito em qualquer lugar, a qualquer hora.",
            "Em situações de ansiedade que se estendem por longos períodos, recomenda-se que a pessoa evite os pensamentos negativos ou catastróficos.\n" +
                    "Deve-se tentar dimensionar a gravidade da situação, questionando a si mesmo se existe uma forma alternativa de análise, se estamos superestimando o grau de responsabilidade que temos nos fatos ou se estamos subestimando o grau de controle que podemos ter.\n" +
                    "Uma vez avaliada a situação, devemos substituir os pensamentos sobre o evento temido, principalmente os negativos. Sempre que um pensamento negativo se iniciar, devesse substituí-lo por outro pensamento qualquer, preferencialmente, agradável.\n" +
                    "Isto certamente não é fácil de ser feito, mas é possível e trata-se de um aspecto importante, pois os pensamentos e as falas negativas agravam a situação, intensificando as respostas autonômicas, como o mal-estar e o descontrole respiratório.",
            "Quando sua mente está dedicada integralmente ao momento atual, você tem total capacidade de análise, julgamento e ação; portanto, esta é uma boa forma de controlar a ansiedade.\n" +
                    "\n" +
                    "Quando a mente passeia aleatoriamente entre passado e futuro sem direcionamento para um planejamento, você pode se perder nas ideias e a ansiedade pode iniciar ou piorar.",
            "Quem vive na bagunça gasta tempo para achar o que precisa, acumula coisas sem utilidade, dificultando o bem-estar e acaba por criar sentimentos de ansiedade. Trabalhar, estudar e viver em ambiente minimamente organizado ajuda no equilíbrio emocional e controle da ansiedade.Além disso, pessoas com uma organização maior do seu tempo conseguem aproveitá-lo melhor, o que reduz muitos fatores causadores de ansiedade.",
            "Conviver com pessoas queridas da família, amigos e conhecimentos que se tenha afinidade faz toda diferença na qualidade de vida. A companhia de quem amamos é especial para nosso emocional. Quem está bem vive mais relaxado e menos ansioso",
            "Reservar algum tempo do dia para você e ser capaz de ouvir suas reais necessidades pode contribuir diretamente para o controle da ansiedade.\n" +
                    "Saber olhar para si, atender e contribuir para sua meta de vida é uma ação de grande poder para sua vida. Seja capaz de dedicar um pouco de tempo e energia a você mesmo.",
            "Atenção ao que você pensa, pois isso terá impacto direto no seu humor. Avalie suas ideias. Ponha um ponto final em \"filmes mentais\" de assuntos negativos sem resolução. Seja capaz de se planejar, programar e ser forte, sem precisar montar um cenário terrível em sua mente. \n" +
                    "Com pensamentos mais leves, você perceberá o mundo de outra forma e isso lhe ajudará a sorrir mais. O riso, o sorriso faz bem para a cura emocional, relaxa e diminui a ansiedade.",
            "Quem se conhece bem, sabe respeitar seus limites, consegue dizer \"não\" e é capaz de se proteger, tem menos ansiedade que outras pessoas que estão ainda aprendendo a se conhecer. Quem tem total aceitação de si mesmo pode pensar, dizer e agir sem culpa, com total alinhamento das suas necessidades."

    };
    String[] titlename ={
            "Pratique atividades físicas (bastam x minutos diários)",
            "Reduza seu estresse diário",
            "Experimente controlar a respiração",
            "Evite pensamentos negativos",
            "Mantenha o foco de atenção no presente",
            "Seja mais organizado",
            "Esteja com quem você ama",
            "Dedique tempo para se cuidar",
            "Cuide dos pensamentos para sorrir mais",
            "Fortaleça o autoconhecimento"
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
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        auth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        SlideListAdapter adapter=new SlideListAdapter(this, itemname, titlename);
        recyclerView.setAdapter(adapter);

    }
}
