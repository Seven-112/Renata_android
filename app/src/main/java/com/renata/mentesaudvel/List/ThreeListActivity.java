package com.renata.mentesaudvel.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.renata.mentesaudvel.Adapter.DetailListAdapter;
import com.renata.mentesaudvel.DetailList.ThreeDetailList;
import com.renata.mentesaudvel.DetailList.TwoDetailList;
import com.renata.mentesaudvel.R;

public class ThreeListActivity extends AppCompatActivity {
    ListView list;
    String[] itemname ={
            "Sinta-se nostálgico, isso te ajudará a se sentir menos sozinho e mais feliz. Veja fotos antigas.  Pesquisadores descobriram que memórias passadas ajudam a manter sentimentos de autoestima e promovem otimismo para o que está por vir.",

            "A felicidade não existe para nós encontrarmos. A razão de não estar lá fora é porque está dentro de nós.",

            " Gaste mais dinheiro com pessoas e experiências novas. É comprovado que gastar dinheiro em experiências proporciona mais felicidade do que posses.\n Gastar dinheiro com seus entes queridos ou amigos produz mais felicidade e satisfação do que gastá-lo consigo mesmo.",

            "Orgulhe-se das conquistas. A educação e a inteligência não o tornam mais feliz do que qualquer outra pessoa, mas a satisfação própria sim.",

            "A maneira mais poderosa de aumentar seus sentimentos de felicidade a longo prazo é entender seus pontos fortes e talentos, ou propósito de vida, e trabalhar para compartilhar essas partes de si mesmo com os outros.",

            "A maneira mais poderosa de aumentar seus sentimentos de felicidade a curto prazo é realizar atos aleatórios de bondade com os outros ou enviar uma carta de gratidão a alguém de quem você gosta. Cinco desses atos em uma semana aumentarão sua felicidade por até três meses. Seja ajudando a caridade ou apenas um pequeno ato de bondade, o altruísmo nos faz sentir bem. Um estudo até descobriu que a felicidade adquirida com o voluntariado pode aumentar sua longevidade e felicidade.\n"
                    + "Os voluntários estão significativamente mais satisfeitos com suas vidas do que os não voluntários.",

            "As pessoas mais felizes têm maior probabilidade de manter relacionamentos. Seja feliz e os outros vão querer estar com você. As pessoas amam pessoas felizes porque querem ser felizes. As pessoas em relacionamentos geralmente são mais felizes do que as solteiras.",
            "Sorria. Sorrir é mais atraente do que usar maquiagem.",

            "Dance. Foi comprovado que a dança cria confiança e libera estresse. Dança e outras formas de arte aumentam a felicidade.",

            "Dinheiro só traz felicidade para aqueles que normalmente não tem para necessidades materiais básicas. Dinheiro não compra felicidade. Depois de atender às suas necessidades materiais básicas, dinheiro adicional não afeta os seus níveis de felicidade.",

            "Beije mais! Beijar e abraçar liberam ocitocina no cérebro, um hormônio que fortalece o vínculo emocional entre duas pessoas para aumentar a felicidade em sua vida.",

            "Beijar, mascar chiclete, comer chocolates e bananas foram comprovados para ajudar as pessoas a relaxar e melhorar o humor.",

            "Faça atividade física. Mínimo de 20 minutos de exercício, três dias por semana, aumentará sua felicidade em 10 a 20% (mas isso não será imediato) após seis meses.",

            "Forçar um sorriso em seu rosto quando você se olha no espelho estimula seu cérebro a produzir produtos químicos que o fazem feliz. Nosso corpo libera endomorfismo quando sorrimos, mesmo quando o forçamos.",

            "Pessoas felizes geralmente ganham mais do que pessoas infelizes, mas a felicidade que vem antes.",

            "Alimente-se bem. A chave para um rápido impulso de felicidade pode estar na sua dieta. Alimentos como nozes, frango e leite contêm níveis mais altos de triptofano, o que pode levar à produção de serotonina, um neurotransmissor que ajuda a induzir a calma e a felicidade. Emoções positivas podem torná-lo mais resistente e mais feliz.",

            "Rir diminui o estresse e fortalece o sistema imunológico. Pessoas felizes sorriem 40-50 vezes por dia, nossa média é de apenas 20 vezes.",

            "A sua visão sobre a vida e o que você escolhe fazer com sua vida responde por 40 por cento dos seus níveis de felicidade. Isso inclui suas amizades, trabalho e participação em sua comunidade.",

            "Quanto mais você abraçar seus filhos, mais felizes eles serão quando adultos.",

            "Se você vive em clima temperado, há uma chance de ser um indivíduo mais alegre. As pessoas que passam mais tempo ao sol tendem a ser mais felizes.",

            "Cantar exercita seu coração, pulmões e libera endorfinas, fazendo você se sentir bem.",

            "Apenas 10% da sua felicidade vem de circunstâncias externas. 90% restantes vêm com seus pensamentos e sentimentos internos, de acordo com a psicologia.",

            "O riso foi clinicamente comprovado para ajudar as pessoas a perder peso.",

            "Se você sorri quando ninguém está por perto, você realmente fala sério.",

            "Estudos mostraram que a felicidade é contagiosa. Pode ser difícil para as pessoas se afastarem de alguém que é feliz ou não amar alguém que é feliz simplesmente porque é muito agradável estar por perto.",

            "A gratidão pode aumentar a dopamina e a serotonina, assim como os antidepressivos e tornar a vida mais feliz.",

            "Sorrir pode reduzir nossa pressão arterial.",
            "Sorrir pode fazer você se sentir mais feliz.",

            "A felicidade é contagiosa e, quando você é positivo, as pessoas são naturalmente atraídas por você.",

            "Pessoas felizes preferem ter conversas mais profundas.",

            "Ser feliz não significa que tudo está perfeito. Isso significa que você decidiu olhar além das imperfeições.",

            "Tenha senso de humor. É geralmente associado à inteligência e honestidade. É por isso que a maioria das mulheres é atraída por homens que possuem um forte senso de humor."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_three_list);
        list=(ListView)findViewById(R.id.list);
        DetailListAdapter adapter=new DetailListAdapter(this, itemname, "3");
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // TODO Auto-generated method stub
//                String Selecteditem = itemname[+position];
//                Log.d("Position", Selecteditem);
//                Intent intent = new Intent(ThreeListActivity.this, ThreeDetailList.class);
//                startActivity(intent);

            }
        });
    }
}
