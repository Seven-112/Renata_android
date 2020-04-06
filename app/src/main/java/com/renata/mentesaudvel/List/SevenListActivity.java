package com.renata.mentesaudvel.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.renata.mentesaudvel.Adapter.DetailListAdapter;
import com.renata.mentesaudvel.DetailList.SevenDetailList;
import com.renata.mentesaudvel.DetailList.SixDetailList;
import com.renata.mentesaudvel.R;

public class SevenListActivity extends AppCompatActivity {
    ListView list;
    String[] itemname ={
            "Crie uma rotina - Troque seu pijama, tome banho e faça todas as coisas que você deseja alcançar todos os dias para criar uma sensação de normalidade e produtividade. \n"+
                    "A interrupção em suas rotinas diárias normais pode ser um dos aspectos mais difíceis da quarentena. Isso pode fazer com que você se sinta sem direção enquanto tenta descobrir como preencher todas as horas do dia.\n"+
                    "Se você estiver trabalhando em casa, pode ser útil estruturar seu tempo como um dia de trabalho regular. No entanto, isso pode ser um desafio se você estiver em casa com outros membros da família, incluindo crianças, que agora ficam em casa o dia todo. Deixadas sem a estrutura de um dia escolar normal, as crianças podem se sentir tão incomuns quanto os adultos.",

            "Se você está tentando manter as crianças pequenas entretidas enquanto está preso em casa, ou mesmo tentando continuar trabalhando em meio a tudo isso, é importante encontrar uma rotina que funcione para você. Planeje atividades que manterão todos ocupados para que você possa fazer algum trabalho. Tente criar uma programação diária, mas não fique muito envolvido em seguir uma rotina estrita. Faça suas próprias rotinas e termine o dia para evitar a monotonia",

            "Divida o seu dia - encontre tarefas para o seu dia e, sempre que possível, mude o seu ambiente para diferentes atividades",

            "Cuide do seu corpo - Coma saudavelmente, durma bem e faça exercícios diariamente. Isso pode incluir a realização de aulas de ginástica, alongamento e prática de meditação.",

            "Ajude os outros - Se você não estiver sob regras estritas de isolamento, e estiver em condições de fazê-lo, encontre maneiras de apoiar os necessitados oferecendo-se para coletar suprimentos para os idosos, por exemplo. Oferecer ajuda a outras pessoas pode ajudar a criar um senso de comunidade.",

            "Mantenha-se conectado - Aproveite ao máximo a tecnologia e mantenha contato com colegas, amigos e familiares por meio de telefonemas, textos, mídias sociais e videoconferência. Em tempos de isolamento, podemos nos apoiar proporcionando conforto, mesmo de longe.",

            "Limitar o consumo de mídia - Mantenha-se informado sobre a situação por fontes confiáveis, mas limite suas notícias e o consumo de mídia social para evitar sentir-se sobrecarregado.",

            "Faça consultas com seu psiquiatra por videochamadas. \n"+
                    "Felizmente, existem maneiras de encontrar alguém com quem conversar sem sair de casa. Cada vez mais, as opções de telessaúde permitem que as pessoas conversem com médicos on-line e existem várias opções de terapia on-line que permitem que as pessoas falem com um terapeuta profissional on-line, por telefone, texto, e-mail ou videochamada. Pode ser uma ótima maneira de obter suporte extra durante um período difícil.",

            "Lute contra o tédio - Aproveite ao máximo seu tempo, assista séries, leia e explore projetos que você está adiando para vencer o tédio e permanecer mentalmente ativo.",

            "Evitar esgotamento - Defina limites estritos ao seu trabalho para evitar sobrecarregar-se e ter tempo para relaxar.",

            "Concentre-se nos aspectos positivos - Amplie boas notícias e honre os profissionais que trabalham incansavelmente para resolver a situação.",

            "Tire um dia de cada vez - tente não projetar muito longe no futuro. Lembre-se de que são medidas temporárias e você não está sozinho.",

            "No entanto, à medida que mais e mais pessoas enfrentam as perspectivas de várias semanas de quarentena ou distanciamento social, os indivíduos também terão que estabelecer suas próprias maneiras de preservar sua saúde mental em casa.",

            "As preocupações de saúde mental podem ser inflamadas pelos estressores associados à quarentena, como medos por infecção, frustração, tédio, suprimentos inadequados, falta de informação e perda financeira associada à contração da doença.",

            "Para aqueles que não estão acostumados a essa introspecção e ruminação, a experiência pode levar a emoções negativas e, em casos extremos, um embaçamento dos limites entre o que está acontecendo na própria mente e o que realmente está acontecendo ao seu redor.",

            "Projetos criativos como desenho, compilação de fotografias ou sudoku podem ajudar a manter a mente ativa.",

            "A solidão é um sério risco à saúde de idosos vulneráveis ao vírus e obrigados a evitar o contato social.",

            "Grupos on-line que oferecem recados e mantimentos podem ajudar aqueles que sofrem o pior isolamento.",

            "Podemos ser mais fortes se conseguirmos manter nossos recursos externos (hobbies, esportes, etc.) mais diversificados e robustos contra o estresse.",

            "A quarentena em casa pode desempenhar um papel importante na prevenção da propagação de doenças infecciosas. Mas isso não significa que é fácil lidar com a interrupção em sua rotina normal. Cuidar de sua saúde mental é essencial, mesmo que seu tempo em quarentena seja relativamente breve.",

            "Além da incerteza e do estresse do surto global, passar um tempo em quarentena pode causar sérios transtornos mentais. Parte da razão disso é o impacto da quarentena em três elementos-chave da saúde mental: autonomia, competência e conexão.",

            "Embora a quarentena possa ser apenas temporária, mesmo breves períodos de isolamento e solidão podem ter consequências negativas no bem-estar físico e mental.",

            "Sentir-se isolado pode levar a um sono ruim, problemas cardiovasculares, baixa imunidade, sintomas depressivos e função executiva prejudicada. Quando as habilidades da função executiva são prejudicadas, você pode achar mais difícil se concentrar, gerenciar suas emoções, lembrar informações e seguir instruções.",

            "As condições de saúde mental anteriormente existentes, incluindo transtornos depressivos e de ansiedade, pioram nesse período de incertezas.",

            "Se você tende a ser bastante resiliente diante do estresse, pode ter habilidades de enfrentamento que permitirão gerenciar a quarentena sem muitos efeitos negativos.",

            "As diferenças de personalidade podem afetar a maneira como você lida com a quarentena. Extrovertidos, por exemplo, podem lutar mais com os sentimentos de solidão que o isolamento traz. A extroversão é caracterizada por uma grande necessidade de interação social. Os extrovertidos podem sentir mais solidão ou achar mais difícil ficar em casa.",

            "Pessoas com personalidades mais introvertidas tendem a desfrutar da solidão, portanto podem ter mais facilidade para lidar com interações sociais reduzidas ou limitadas. Os introvertidos tendem a se sentir esgotados após a socialização, para que possam realmente lidar muito bem durante a quarentena - pelo menos por um tempo. Até os introvertidos precisam de contato social, por isso ainda é essencial encontrar maneiras de se conectar com outras pessoas.",

            "A duração da quarentena é um fator-chave para determinar o quão bem as pessoas lidam. Pesquisas sugerem que minimizar o tempo de quarentena pode ajudar. Quanto mais longas as restrições durarem, mais pronunciados serão os efeitos.",

            "Seja o mais ativo possível\n"+
                    "Mesmo períodos relativamente curtos de inatividade física podem afetar sua saúde, tanto mental quanto fisicamente. Um estudo descobriu que apenas duas semanas de inatividade podem levar a reduções na massa muscular e efeitos metabólicos.\n"+
                    "Felizmente, existem muitas ideias de exercícios em casa que podem ajudar a mantê-lo em movimento, mesmo quando você está dentro de casa. Sua quarentena pode ser breve, mas permanecer ativo pode ajudá-lo a se sentir melhor e manter seus níveis de condicionamento físico. É também uma ótima maneira de ajudar a combater a sensação de mal-estar e tédio que pode advir de ficar preso dentro de dia após dia.",

            "Combate à frustração e ao tédio\n"+
                    "Algumas das angústias de ficar em quarentena decorre de tédio e frustração. É importante encontrar maneiras de se manter ocupado; portanto, tente manter o máximo de rotinas possível. Continue trabalhando em projetos ou encontre novas atividades para preencher seu tempo, seja organizando seu armário ou tentando um novo hobby criativo.\n"+
                    "Fazer as coisas pode fornecer um senso de propósito e competência. Dá a você algo pelo que trabalhar e algo pelo qual ansiar a cada dia. Portanto, faça um plano, liste algumas coisas que gostaria de realizar e comece a verificar algumas coisas da sua lista todos os dias.",

            "Lembre-se de que as crianças também estão estressadas\n"+
                    "A pesquisa descobriu que as crianças que passaram pela quarentena apresentaram sintomas de TEPT quatro vezes mais do que as crianças que não foram colocadas em quarentena.",

            "Lembre-se de por que você está fazendo isso\n"+
                    "Quando você está se sentindo frustrado ou confuso, pode ser útil pensar nas razões pelas quais você está se colocando em quarentena. Se você foi potencialmente exposto a vírus, evitar outros é uma ação altruísta. Você minimiza a chance de espalhar a doença sem saber para outras pessoas, mesmo se atualmente estiver assintomático.",

            "Ao fazer sua parte para impedir a propagação da doença, você está protegendo outras pessoas e assegurando que os doentes possam ter maior acesso aos recursos de saúde disponíveis. Lembrar-se dessas razões às vezes pode facilitar um pouco os seus dias de quarentena.",

            "ESTOU (SEMPRE) em casa! Se você mora com um parceiro ou colega de quarto, a quarentena de vírus não se resume a gerenciar suas próprias necessidades e ansiedades. Trata-se de encontrar uma maneira de coexistir com alguém e todas as suas necessidades e ansiedades, a cada minuto de cada dia em um espaço confinado por um período não revelado. Se você acha que isso deve ser fácil, provavelmente você não está respeitando o espaço do outro. ",

            "Embora a experiência seja mais fácil para alguns (desculpe, extrovertidos), a quarentena mexerá com a cabeça de todos. Pesquisas mostram que você ficará entediado, frustrado, solitário, irritado e estressado. Os seres humanos não gostam de ser expulsos de suas rotinas, principalmente quando as mudanças os deixam se sentindo presos. Se você estiver com outra pessoa e você a ouvir tossir, também entrará em pânico com a saúde deles e com a sua.\n"+
                    "O mais preocupante é que existem evidências de que as pessoas em quarentena têm maior probabilidade de relatar sintomas de depressão, ansiedade e estresse pós-traumático. Se você estiver isolado por tempo suficiente - meses a fio -, uma experiência adversa de quarentena pode até alterar suas ondas cerebrais.",

            "Quando exposto a luz restrita e estímulos ambientais limitados, o cérebro diminui a velocidade para economizar energia.",

            "Assistir filmes antigos costumava ser muito popular nos centros de pesquisa da Antártica. Dá às pessoas a chance de interagir socialmente por um período estruturado e, em seguida, lhes dá um período para recuar. ",

            "Entretenimento fácil não é uma indulgência nessa situação. É um requisito. Se você se deparar com um padrão de conflito com seu parceiro, mude as coisas. A quarentena também pode ser um momento para adotar uma rotina compartilhada de exercícios físicos ou uma busca criativa ou intelectual com seu parceiro - faça abdominais, pinte, aprenda um novo jogo de tabuleiro, leia o livro que ele está falando para você ler. As pessoas dirão que esta é uma ótima oportunidade para aprender um novo idioma ou ler uma pilha de livros. Novos desafios podem ser úteis, mas também precisam ser mantidos alinhados às expectativas razoáveis, para que você não comece a se sentir culpado por perder tempo. Lembre-se, você precisa reconhecer que ficar em quarentena é difícil por si só."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_seven_list);
        list=(ListView)findViewById(R.id.list);
        DetailListAdapter adapter=new DetailListAdapter(this, itemname, "7");
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // TODO Auto-generated method stub
//                String Selecteditem = itemname[+position];
//                Log.d("Position", Selecteditem);
//                Intent intent = new Intent(SevenListActivity.this, SevenDetailList.class);
//                startActivity(intent);

            }
        });
    }
}