package com.renata.mentesaudvel.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.renata.mentesaudvel.Adapter.DetailListAdapter;
import com.renata.mentesaudvel.DetailList.SixDetailList;
import com.renata.mentesaudvel.DetailList.ThreeDetailList;
import com.renata.mentesaudvel.R;

public class SixListActivity extends AppCompatActivity {
    ListView list;
    String[] itemname ={
            "Reduz os níveis de cortisol. Pesquisas mostram que o Mindfulness reduz os níveis de cortisol, hormônio responsável pelo estresse. \n"+
                    "Reduzir o cortisol pode diminuir o estresse geral, ansiedade e depressão.\n",

            "Ensina lidar melhor com o estresse. \n"+
                    "A meditação traz uma sensação de calma à mente e ao corpo. Quando a mente relaxa, o corpo também relaxa. ",

            "Alivia a ansiedade.  \n"+
                    "Dedicar apenas alguns minutos para fechar os olhos e fazer exercícios respiratórios pode desativar os mecanismos cerebrais que causam ansiedade. Ajuda a lidar com o estresse, a ansiedade e com as situações difíceis, o que faz você mais feliz.",

            "Reduz os sintomas de depressão. A depressão é uma condição de saúde mental em série, muitas vezes desencadeada por estresse e ansiedade. \n"+
                    "Pesquisas sugerem que a meditação pode alterar áreas do cérebro, que estão ligados à depressão. As pessoas que meditam também mostram aumento da massa cinzenta no hipocampo do cérebro, responsável pela memória.",

            "Reduz a impulsividade e a raiva nas situações difíceis. \n"+
                    " A meditação pode treinar o cérebro para usar melhor o córtex pré-frontal e regular a amígdala, ajuda a concentrar no presente. \n"+
                    "Diante de uma situação de estresse quem medita poderá pensar com mais calma e nitidez, em vez de deixar as reações impulsivas tomarem conta. Aprender a controlar e processar suas emoções no momento.",

            "Faz bem ao seu coração. \n"+
                    "Pesquisas mostram que a meditação pode reduzir o risco de doenças cardiovasculares. A meditação afeta positivamente a pressão arterial, a eficácia do músculo cardíaco e a reduz a mortalidade cardiovascular geral.",

            "Aumenta os níveis de serotonina. \n"+
                    "A serotonina é um neurotransmissor produzido nas células nervosas que funciona como um um antidepressivo natural.",

            "Fortalece relacionamentos. Boa comunicação, empatia e respeito são as características de um relacionamento forte, e a meditação ajuda a melhorar todas essas qualidades. Criar uma conexão mais profunda com você mesmo torna os relacionamentos mais fáceis e mais gratificantes. A meditação muda a maneira como as pessoas interagem e ajuda algumas pessoas a entender melhor o que outras pessoas estão passando. Isso também pode te abrir para o perdão.",

            "Aumenta a concentração. Quando tantas coisas correm em nossas mentes a qualquer momento, pode ser difícil se concentrar em tarefas no trabalho ou até em hobbies como ler um livro. A meditação concentra sua mente para que você possa se concentrar no que precisa ser feito.",

            "Ajuda a construir a força interior. \n"+
                    "Praticar meditação e atenção ajuda a construir força e resistência internas para superar calmamente essas situações. Isso cria a capacidade de estar no momento, não importa como seja.",

            "Você aprenderá a estar presente. Pesquisas mostram que a meditação pode diminuir a atividade cerebral na rede de modo padrão, a parte do cérebro associada a lapsos de atenção e distúrbios como ansiedade, deficit de atenção e hiperatividade, e até acúmulo de placas senis na doença de Alzheimer.",

            "Você ficará confortável na quietude. Hoje em dia, a maioria das pessoas está sempre em movimento e raramente tira um tempo para se acalmar. A meditação pode fazer você se sentir à vontade com a quietude.",

            "Ajuda a clarear as ideias. Se você luta com a concentração, esquece as coisas facilmente e tem dificuldade em se concentrar. Isso geralmente é causado pelo estresse, e uma prática de meditação pode acalmar sua mente e permitir que você se concentre na respiração para se sentir mais presente.",

            "Ajuda a lidar com a dor. A meditação ativa áreas do cérebro associadas ao processamento da dor, de modo que a respiração consciente pode ajudar as pessoas a gerenciar a dor crônica. Pesquisas mostram que mesmo uma pequena quantidade de meditação pode aumentar a tolerância à dor e reduzir a ansiedade relacionada à dor - e isso poderia aliviar a necessidade de analgésicos.",

            "Você vai dormir melhor. Quando você medita, você pode adormecer mais facilmente e obter um sono de melhor qualidade. Reduz a ansiedade e treina novamente o cérebro para desacelerar e responder de maneira diferente aos estressores.",

            "Reduz a inflamação. A capacidade da meditação para ajudar a reduzir o estresse é bem conhecida. Mas, o estresse crônico cria inflamação no corpo, que está ligada a doenças cardíacas, derrame, diabetes e obesidade.",

            "Você será mais produtivo. Trazer mais concentração, em vez de pular de um projeto para outro - e isso aumenta a produtividade.",

            "Melhora o funcionamento mental. Pratique meditação regularmente e você verá uma \"reação em cadeia\" que leva a um melhor funcionamento mental. Isso pode incluir ficar mais relaxado, dormir melhor e melhorar a concentração, o raciocínio, o desempenho e a produtividade.",

            "Você se sentirá mais criativo. A meditação ajuda a aumentar sua criatividade, o que pode ser estendido à sua vida diária. A criatividade oferece benefícios como resolução de problemas, adaptabilidade e autoconfiança.",

            "Faz você ser gentil. Todos nós precisamos de um pouco mais de bondade em nossas vidas, e a meditação pode fazer isso.",

            "Melhora a memória. A meditação melhora a função cognitiva, que pode melhorar o humor e ajudar a prevenir a perda de memória",

            "Você terá um despertar espiritual. A meditação nos leva a um lugar profundo dentro de nós mesmos, que pode trazer sentimentos de amor e paz. Para alguns, isso pode levar a um despertar espiritual.",

            "Meditação constrói resiliência. O foco em todas as emoções - felicidade, fracasso e arrependimento - permite que você observe esses sentimentos e experimente uma posição de consciência. Enquanto está sentado com esses sentimentos e experiências, a força interior é cultivada e a resiliência emerge.",

            "Sua vida sexual vai esquentar. A atenção plena permite que você entre em um relacionamento mais autêntico, compassivo e honesto com o sexo. Estudos mostram que praticar a atenção plena aumenta a excitação sexual e a satisfação sexual geral, porque melhora a sua conexão com o corpo.",

            "Promove a alimentação consciente. Nosso relacionamento com os alimentos pode ser complexo, e fazer dieta ou comer demais pode ser prejudicial à nossa saúde física e mental.",

            "Ajuda a lidar com situações desconfortáveis. Sair da sua zona de conforto cria força e leva ao crescimento pessoal. A meditação ensina você a sentir desconforto \"sem se preocupar com isso\", abrindo a porta para novas possibilidades, onde você se sentirá mais confortável pedindo um aumento, tendo uma conversa difícil ou enfrentando qualquer outra coisa que esteja evitando.",

            "Pode alterar a expressão do gene. Pesquisas mostram que a meditação baseada na atenção plena pode levar a alterações moleculares no corpo, o que pode reduzir os níveis de genes pró-inflamatórios. Isso significa que você pode se recuperar mais rapidamente de situações estressantes.",

            "A meditação pode ajudar a combater o vício. Praticar a atenção plena permite controlar melhor as emoções, pensamentos e comportamentos, proporcionando maior controle sobre hábitos e vícios subconscientes. Pesquisas sugerem que intervenções baseadas na atenção plena podem tratar vícios, incluindo álcool, tabagismo, opióides e outras drogas.",

            "A meditação promove a responsabilidade. A auto-exploração leva à autoconsciência. A meditação ensina você a reconhecer ações e comportamentos e parar de viver em negação ou mentir para si mesmo sobre questões de sua vida.",

            "Você tomará melhores decisões. Estar constantemente em movimento significa que frequentemente tomamos decisões impulsivas. Como a meditação ajuda a diminuir a velocidade, você pode tomar melhores decisões e menos erros em sua vida doméstica e profissional.",

            "Aumenta a auto-estima. A meditação ajuda a reprimir pensamentos negativos, acalma a mente e reduz a ansiedade, ajudando você a se sentir bem consigo mesmo e com as decisões que toma.",

            "A meditação alivia a solidão. Um estudo publicado na revista Brain, Behavior, and Immunity mostrou adultos mais velhos, que participaram de um programa de redução de estresse de oito semanas baseado em mindfulness, observando uma diminuição na expressão gênica pró-inflamatória - e isso reduzia os sentimentos de solidão.",

            "Melhora a memória. Foi demonstrado que um breve treinamento em meditação melhora o “processamento visuo-espacial, a memória de trabalho e o funcionamento executivo”.\n"+
                    "Após apenas quatro dias de treinamento em meditação, as pessoas mostraram uma capacidade mais forte de prestar atenção por mais tempo.",

            "Pode aliviar a TPM Dores de cabeça, cãibras, ondas de calor e retenção de água - a meditação demonstrou aliviar os sintomas da Tensão pré-menstrual e mudar a maneira como você percebe a dor do período.",

            "A meditação pode melhorar os sintomas da artrite. Vários estudos demonstraram que a meditação e a redução do estresse com base na atenção plena podem ajudar a gerenciar a dor crônica, o que é uma boa notícia para as pessoas que sofrem de artrite. Abraçar a meditação pode ajudar a diminuir a intensidade da dor, melhorar a funcionalidade e melhorar o humor e a qualidade de vida.",

            "A meditação incentiva o movimento. A meditação promove uma conexão mente-corpo que o incentivará a se levantar e se mover. Combinada com ioga, tai chi ou uma caminhada casual, a meditação se concentra em estar presente em seu próprio corpo e em expandir a consciência durante a atividade física.",

            "Ajuda você a se concentrar. Tendo problemas para se concentrar em uma tarefa específica? Meditação pode mudar isso. Poderia ser o simples ato de sentar-se para uma boa refeição ou fazer uma sessão de treino, mas a intenção é focar-se simplesmente nessa tarefa em mãos e não deixar a mente vagar",

            "Você se tornará mais autoconfiante. O foco na sua prática de meditação ajuda a encontrar estabilidade, paz de espírito e auto-aceitação.",

            "Promove estabilidade emocional. A meditação permite que você se concentre em sua mente e identifique padrões de pensamento, para que você possa resolvê-lo. Você descobrirá maneiras saudáveis de lidar com suas emoções e sentimentos reprimidos.",

            "Você terá um desempenho melhor. Tanto o foco está na produtividade e o máximo possível em um dia. A meditação pode melhorar o desempenho em todas as áreas da sua vida.",

            "Você aprenderá a focar sua respiração. A respiração é uma função natural do corpo, é claro, mas com que frequência você realmente se concentra em cada respiração?",

            "Você fará uma conexão mente-corpo. Com que frequência nos permitimos realmente sentir as sensações mais sutis dentro do corpo? Se ouvirmos, nosso corpo nos informará o que precisa ser curado",

            "A meditação mantém seu cérebro mais jovem. Quando você se concentra na respiração durante a meditação, também está estimulando o cérebro. Pesquisas publicadas no Journal of Cognitive Enhancement mostram que a prática regular de Mindfulness pode até retardar o processo de envelhecimento e reverter o envelhecimento do cérebro.",

            "Ajuda a lidar com o trauma. A morte de um ente querido ou a recuperação de abusos passadospode significar lidar diariamente com trauma e tristeza. A meditação pode proporcionar segurança emocional e foco, para que você possa processar esses sentimentos.",

            "Mantém as distrações afastadas. A necessidade de multitarefa constante pode ter nossas mentes dispersas. Uma prática de Mindfulness afasta as distrações para que você possa lidar com sua lista de tarefas de maneira calculada.",

            "Você simplificará sua vida. Viver em paz no momento não apenas ajuda você a se sentir mais presente, mas também alivia a pressão de ter que fazer muito.  Essa percepção permite simplificar sua vida e encontrar alegria.",

            "Você se tornará mais paciente. Paciência é verdadeiramente uma virtude, principalmente quando se trata de pessoas difíceis. A meditação permite que você se torne mais hábil em lidar com distrações mentais, mantendo a calma em momentos de caos, melhorando os níveis de paciência, aumentando sua tolerância em relação aos outros (e a si mesmo) e respondendo de forma calma em vez de reagir impulsivamente ao longo do dia. Você aprenderá a centralizar sua mente e a se concentrar na respiração, o que ajuda a controlar suas emoções e impulsos.",

            "Você será mais tolerante com os outros. Pode ser difícil encarar os colegas de trabalho ou parentes com visões políticas diferentes. Uma prática regular de meditação o manterá calmo nesses casos, para que você possa abraçar a tolerância. É uma parte importante da construção de relacionamentos.",

            "A meditação melhora seu metabolismo. Praticar meditação provavelmente o inspirará a se mover mais ou a praticar ioga ou outra rotina de exercícios. A pesquisa também mostrou uma ligação entre a atenção plena e um metabolismo aprimorado.",

            "Melhora a digestão. O equilíbrio mente-corpo e o estresse reduzido que você experimentará da meditação são ótimos para o seu sistema digestivo. Pode aliviar os sintomas de indigestão, síndrome do intestino irritável, constipação e outros problemas de saúde.",

            "Você terá mais energia. Manter uma conexão mente-corpo e reduzir o estresse proporcionará um aumento de energia. A meditação ajuda você a se sentir menos oprimido por suas emoções e pronto para se mover ou assumir novos projetos.",

            "A meditação libera endorfinas. A prática da meditação libera endorfinas e reduz os níveis de cortisol, fazendo você se sentir mais feliz e com mais energia.",

            "A meditação ajuda a conter os desejos de comida e reduz os casos de compulsão alimentar. O autocontrole e o gerenciamento do estresse que você aprende praticando a atenção plena podem ajudar a reduzir os desejos de comida e a quebrar hábitos alimentares pouco saudáveis. Ele permite que você explique o que está levando você a alimentos específicos. “A meditação permite que você domine sua própria mente, para que você possa fazer uma pausa e se perguntar: 'Por que esse sorvete é importante' e permitir que sua mente conecte pontos.",

            "Meditação pode ajudá-lo a perder peso. A pesquisa associou a meditação a uma alimentação mais consciente, um aumento no metabolismo e aumento dos níveis de energia, o que sugere que isso poderia ajudar na perda de peso.",

            "Ajuda a esquecer os erros do passado. A meditação ajuda a deixar o passado no passado e a abafar o barulho que o impede de experimentar a paz interior. Você cortará qualquer apego a erros passados e seguirá em frente.",

            "A meditação ajuda a criar sua melhor realidade. Agendas ocupadas e responsabilidades de vida às vezes podem fazer você se sentir fora de controle com a trajetória de sua vida. Dominar sua mente através da meditação o ajuda a criar conscientemente qualquer realidade que você deseja e viver sua melhor vida. \n"+
                    "\"Quando você domina sua mente, controla o que pensa, acredita, sente, cria e atrai\". \"Quando você cria conscientemente, suas necessidades e desejos são atendidos com rapidez e facilidade.\"\n",

            "A meditação ajuda a rastrear emoções. Manter o controle das emoções e sensações corporais pode ajudar alguém a gerenciar o estresse, a ansiedade ou as condições de saúde mental, como o transtorno bipolor.",

            "Você se tornará mais observador. Acalmar e centralizar seus pensamentos pode ajudar a desenvolver habilidades de observação. \n"+
                    "\"As técnicas meditativas ajudam a manter a cabeça fora das nuvens e atenta ao que está acontecendo bem na sua frente\".",

            "Ajuda a visualizar seus objetivos. A visualização positiva permite que você veja o que deseja, crie metas e se concentre em alcançá-las. A meditação ajuda a expulsar pensamentos negativos e estimula-se para que você possa atingir seus objetivos.“Durante a meditação, imaginar um objetivo, repetir um mantra ou se envolver em comportamentos que levam a seus objetivos, são ótimas maneiras de fazer essas coisas realmente acontecerem”.",

            "A meditação permite que você se harmonize com a sua realidade. \"Muitas vezes, estamos infelizes ou zangados porque não queremos aceitar situações específicas, eventos ou mesmo a maneira como reagimos\".A meditação permite que você se conecte consigo mesmo e aprenda a estar em harmonia com a sua realidade. Isso lhe dá espaço para se ver e aceitar o que realmente está acontecendo sem julgamento.",

            "Você se sentirá seguro. A meditação ajuda a regular o centro de medo do cérebro, e respirar fundo e profundamente pode estimular o nervo vago, o que reduz sentimentos de ansiedade e opressão, Isso pode ajudar a reduzir o medo e fazer você se sentir seguro.",

            "A meditação aumenta a massa cinzenta no cérebro. Pesquisas sugerem que a meditação aumenta a quantidade de substância cinzenta no cérebro, de acordo com um estudo publicado na Psychiatry Research. Os praticantes de meditação a longo prazo podiam ter mais atenção sustentada, mais compaixão e melhor autoconsciência.",

            "Você se sentirá mais grato. A meditação pode estimular sentimentos de gratidão, diz Schroeder. Geralmente, sentir-se mais grato pode nos fazer sentir mais felizes e ter mais compaixão pelos outros.",

            "A meditação pode melhorar seu treino. Uma prática regular de meditação aumenta os níveis de energia e melhora nosso humor, o que pode realmente melhorar seus exercícios. A integração de elementos de meditação no exercício físico pode tornar seu treino mais significativo.",

            "Você pode aprender a gerenciar dinheiro. Praticar a atenção plena traz intenção às suas ações, o que melhora todos os aspectos da vida. A meditação pode aliviar o estresse e a ansiedade relacionados a finanças e aprender hábitos de dinheiro mais saudáveis.",

            "Você pode gerenciar o TDAH. O treinamento em Mindfulness ajuda a aliviar os sintomas do transtorno do déficit de atenção e hiperatividade (TDAH) em adultos, de acordo com uma pesquisa publicada no Journal of Attention Disorders.",

            "A meditação pode ajudar nas condições de saúde mental. A maneira como a meditação interage com o cérebro pode ajudar a aliviar alguns dos sintomas e efeitos de algumas condições de saúde mental. Em alguns casos, isso poderia aliviar ou reduzir a necessidade de medicação.",

            "Ajuda a evitar doenças. A meditação mostra um impacto positivo em nosso estado mental, o que poderia manter a doença afastada. ",

            "Ajudará você a encontrar um senso de propósito. A meditação permite que você toque em seu eu interior e mergulhe em sua verdadeira paixão, ajudando a definir o que o faz feliz e encontrar um senso de propósito.",

            "A meditação lhe dá uma fuga. É provável que você encontre regularmente situações estressantes e continue assumindo mais trabalho e responsabilidade. A meditação - incluindo focar na respiração e olhar para dentro - oferece uma rara fuga para seus pensamentos.",

            "Você aprenderá a realmente respirar. A meditação ensina a respirar com atenção. Uma técnica de respiração é a respiração 4-7-8: 1 Coloque a ponta da língua no céu da boca, atrás dos dentes, e não a mova durante o exercício. 2 Expire apenas pela boca, permitindo com que o ar saia emitindo o som da brisa.3 Feche a boca - ainda com a língua pressionando o céu - e inspire devagar, contando até quatro. 4 Segure o ar e conte até sete. 5 Solte o ar suavemente pela boca durante oito segundos, da mesma forma indicada na primeira expiração. 6 Inspire novamente e repita o ciclo mais três vezes."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_six_list);
        list=(ListView)findViewById(R.id.list);
        DetailListAdapter adapter=new DetailListAdapter(this, itemname, "6");
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // TODO Auto-generated method stub
//                String Selecteditem = itemname[+position];
//                Log.d("Position", Selecteditem);
//                Intent intent = new Intent(SixListActivity.this, SixDetailList.class);
//                startActivity(intent);

            }
        });
    }
}
