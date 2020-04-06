package com.renata.mentesaudvel.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.renata.mentesaudvel.Adapter.DetailListAdapter;
import com.renata.mentesaudvel.DetailList.FiveDetailList;
import com.renata.mentesaudvel.DetailList.ThreeDetailList;
import com.renata.mentesaudvel.R;

public class FiveListActivity extends AppCompatActivity {
    ListView list;
    String[] itemname ={
            "A gratidão é um dos melhores presentes que você pode retribuir àqueles que estiveram com você por toda a parte. Seu simples \"obrigado\" tem o poder de fazer alguém se sentir apreciado.",
            "Desenvolva o hábito de dizer \"obrigado\" por tudo o que os outros dão ou fazem por você.\n"+
                    "        Seu \"obrigado\" é provavelmente a frase mais bonita que alguém pode ouvir hoje; portanto, seja generoso em divulgar isso. Crie o hábito de agradecer sinceramente (com um sorriso) a todos que fazem algo por você - o garçom que o serve, o motorista de táxi que o leva para casa ou mesmo o cara aleatório que abre a porta da loja para você.",
            "Envie um cartão ou presente de agradecimento simples como sinal de sua gratidão.\n"+
                    "        Mostrar gratidão não precisa ser caro. Por exemplo, postar uma nota adesiva com uma breve carta de agradecimento no monitor do seu colega pode ser uma surpresa emocionante para ela. Ou, se você tiver o dinheiro extra, poderia comprar uma barra de chocolate para ela.",
            " Saiba que a generosidade ou ajuda que você recebe de outras pessoas tem custos.\n"+
                    "        Uma das maneiras de implantar gratidão em seu coração é perceber que custa a alguém ajudar, servir ou dar a você - mesmo os favores simples. O vizinho que concordou em cuidar do seu filho por uma hora poderia ter usado esse tempo para alguma tarefa pessoal; ou o colega de classe que o ensinou em matemática poderia ter se concentrado mais em sua própria revisão.",
            "Instale em sua mente que, apesar das dificuldades, existem muitas razões para celebrar a vida.\n"+
                    "        A gratidão não é dada apenas àqueles que o ajudaram de alguma maneira. Também deve ser dado a Deus - pela vida que você vive agora. Pode haver algumas dificuldades, mas com certeza há mais bênçãos e coisas positivas que você vê todos os dias. Conte suas bênçãos, especialmente os entes queridos que continuam a apoiá-lo.",
            "Entenda que nem todas as pessoas recebem as mesmas oportunidades que você recebe.\n"+
                    "        Seja grato pelas oportunidades que você recebeu ou receberá, porque algumas pessoas só poderiam desejar por elas. Por exemplo, em vez de desejar ter estudado em uma universidade de prestígio, agradeça a educação gratuita na universidade estadual em que estuda. O que importa é que você pode terminar seu curso e estar mais perto do seu sonho.",
            "Coloque-se no lugar daqueles que não são agradecidos pelo seu esforço em ajudar.\n"+
                    "        O que você sentiria se sacrificasse tempo, dinheiro ou esforço apenas para ajudar alguém e não recebesse um único \"obrigado\" por isso? Isso faria você se sentir um dado adquirido se seu esforço não for apreciado, especialmente se isso lhe custar muito. Não é sobre reconhecimento - é sobre ser valorizado.",
            "Seja um bom mordomo das coisas ou oportunidades que receber.\n"+
                    "        A gratidão também pode ser demonstrada cuidando bem do que lhe foi dado. Isso mostra que você realmente o valoriza. Por exemplo, se você recebeu uma bolsa de estudos para estudar na faculdade, deve dar o seu melhor para se destacar em seus estudos.",
            "Pague o favor adiante.\n"+
                    "        Uma maneira bonita de demonstrar gratidão é pagar adiante. Ou seja, em vez de retribuir aqueles que o abençoaram (bem, também é bonito abençoá-los de volta), você faz a outra pessoa qualquer coisa boa que foi feita a você.",
            "Aborde as pessoas não apenas quando você precisar de algo delas para mostrar um cuidado sincero.\n"+
                    "        É ruim se você só é lembrado pelas pessoas quando elas precisam de algo de você, certo? A melhor coisa que você pode fazer pelas pessoas que se preocupam com você é mostrar constantemente seu carinho por elas também. Mensagem ou visite-os sempre que puder.",
            "Encontre a chance de retribuir.\n"+
                    "        Quando o tempo e os recursos permitirem, mostre sua gratidão abençoando aqueles que o ajudaram. Isso não está retribuindo, pois você nunca pode retribuir a gentileza, mas apenas uma maneira de demonstrar apreço e carinho. Estar disponível para eles sempre que precisarem de ajuda é uma maneira de retribuir.",
            "Mantenha as pessoas que o abençoaram em suas orações.\n"+
                    "        Você pode não ter meios de retribuir àqueles que o apóiam, mas há uma coisa poderosa que você pode fazer por eles - ou seja, incluí-los nas orações. Se você acredita que a oração funciona, orar pelas pessoas de quem você gosta não é uma perda de tempo. Peça a Deus para abençoá-los mais, protegê-los sempre e dar-lhes os desejos de seus corações.",
            "Perceba que Deus lhe dá mais do que você merece.\n"+
                    "        Eu acho que a melhor maneira de desenvolver um hábito de gratidão é lembrar que é pela graça de Deus que você é capaz de viver uma vida abundante agora. Deus salvou você do castigo de seus pecados, sacrificando Seu Filho Jesus na cruz (Romanos 6:23, João 3:16). Ele lhe deu o presente gratuito da salvação (Efésios 2: 8-9), mesmo que você não o mereça, porque Ele te ama.",
            "Ser grato por tudo que você tem levará à satisfação, o que resultará em paz e alegria. Isso também ajudará você a manter uma perspectiva positiva da vida, necessária para que você seja forte em tempos de problemas.",
            "Escreva uma carta de gratidão: escolha alguém que tenha causado um impacto positivo em sua vida. Escreva uma carta explicando como e agradecendo. Seja específico e inclua muitas descrições. Você pode enviar a carta por correio ou apenas guardá-la. Expressar sua gratidão aumenta isso.",
            "Receba com gratidão: Muitos de nós somos melhores doadores do que receptores. Concentre-se na sua experiência de receber gratidão. Quando você recebe um elogio, você se deprecia dizendo \"não era nada\" ou diminuindo seu papel? Observe sua experiência como destinatário e tente receber complementos ou agradecimentos com graça. A lei de dar e receber coloca igual ênfase nos dois lados.",
            "Mantenha um Diário de Gratidão: No final de cada dia, faça uma lista de três coisas pelas quais você é grato. Pense em tudo, desde água corrente e uma cama aconchegante até luzes vermelhas durante o trajeto e ter um grande amigo no trabalho. A lista pode ser interminável! Ao praticar, você fortalece os caminhos neurais que ajudam a encontrar ainda mais coisas pelas quais agradecer. Em breve, a gratidão será sua atitude.",
            "Ser grato pode parecer uma tarefa simples. Existem obstáculos à gratidão, incluindo narcisismo, materialismo e até demais agendas. Há também os mitos de que a gratidão expressa no trabalho é \"beijar o traseiro\", que pode levar à complacência, não é possível no meio do sofrimento ou faz de você uma pessoa insana.",
            "A gratidão é mais forte quando compartilhada. Para manter sua mentalidade de gratidão, encontre uma maneira de verbalizar, anotá-la ou compartilhar através da mídia social. Assim como a meditação é uma prática, também a gratidão.",
            "A gratidão pode afetar os aspectos físicos, psicológicos e sociais do bem-estar de um indivíduo, mostram estudos. A psicologia positiva vê a gratidão como uma das chaves para transformar potenciais negativos em positivos.",
            "Benefícios físicos da gratidão\n"+
                    "        - um sistema imunológico mais forte\n"+
                    "        - menos incomodado por dores e dores\n"+
                    "        - pressão arterial mais baixa\n"+
                    "        - durma mais e sinta-se mais descansado ao acordar",
            "Benefícios sociais da gratidão\n"+
                    "        - mais compassivo, generoso e útil\n"+
                    "        - mais perdoador\n"+
                    "        - mais extrovertido\n"+
                    "        - sinta-se menos solitário ou isolado",
            "Benefícios psicológicos da gratidão\n"+
                    "        - níveis mais altos de emoção positiva\n"+
                    "        - mais alerta, vivo, acordado\n"+
                    "        - mais alegria e prazer\n"+
                    "        - mais otimismo e felicidade",
            "Ser grato não deve ser uma tradição uma vez por ano. Aprenda a ser mais grato todos os dias por ter uma vida mais saudável e feliz.",
            "É possível cultivar uma mentalidade de gratidão que permanecerá com você ao longo do ano. Uma mentalidade de gratidão significa níveis mais baixos de inveja, ansiedade e depressão, além de maior otimismo e bem-estar.",
            "Ser grato pode fazer você feliz, mas ser feliz também pode fazer você agradecer. Existem muitas outras maneiras de melhorar seu humor, incluindo exercitar-se ou participar de um hobby que você gosta.",
            "Quando sentir que as endorfinas fluem, demonstrar gratidão se tornará ainda mais fácil e você começará a fazer uma lista após a outra de todas as coisas em sua vida pelas quais você é grato.",
            "A gratidão não precisa ser salva para as coisas \"grandes\" da vida. O hábito de ser grato começa por apreciar tudo de bom na vida e reconhecer que não há nada pequeno demais para você agradecer.",
            "Mesmo que seja tão simples quanto apreciar o tempo limpo ou a rapidez com que o carteiro entregou sua correspondência na última sexta-feira, não deixe nada de fora ao praticar sua gratidão.",
            "Gratidão não é apenas agradecer por experiências positivas. De fato, às vezes, pensar em situações negativas ou difíceis pode ajudar a realmente definir o que você deve agradecer.",
            "Mergulhe um pouco mais fundo em algumas de suas próprias experiências passadas e tente descobrir como elas ajudaram a moldá-lo na pessoa que você é hoje.",
            "Sente-se diariamente e pense em cinco a dez coisas pelas quais você é grato. O truque é que você precisa imaginá-lo e se sentar com esse sentimento de gratidão em seu corpo. Fazer isso todos os dias reconectará seu cérebro a ficar naturalmente mais agradecido, e você começará a se sentir mais feliz após cada sessão.",
            "Leva apenas oito semanas de prática de gratidão para as pessoas começarem a mostrar padrões cerebrais alterados que levam a uma maior empatia e felicidade.",
            "Seu cérebro é uma ferramenta poderosa, e treiná-lo para a gratidão faz parte de garantir que a gratidão seja mais fácil à medida que você pratica, então o que você está esperando?",
            "Após a sessão de atenção plena, anote seus pensamentos positivos! Manter um diário de todas as coisas pelas quais você é grato pode ajudá-lo a acompanhar e consultar os aspectos positivos de sua vida.",
            " Você pode fazer o diário todos os dias após a prática de gratidão, ou pode voltar ao diário regularmente, semanalmente ou mensalmente.",
            "Para muitas pessoas, a chave para ter mais gratidão é retribuir a outras pessoas na comunidade local. Não apenas isso o tornará mais grato pelas coisas que você pode dar como garantidas, mas os estudos demonstraram que o voluntariado com o objetivo de ajudar os outros aumenta nosso próprio bem-estar e, portanto, nossa capacidade de ter mais gratidão.",
            "Às vezes, não basta apenas manter sua gratidão consigo mesmo. Você pode aumentar seus sentimentos de gratidão expressando a mesma gratidão às pessoas de quem gosta.",
            "Soul Pancake, um grupo que trabalha para descobrir a “ciência da felicidade”, realizou um experimento em que encorajava as pessoas a escrever uma carta para uma pessoa pela qual eram gratas. Por si só, esse exercício aumentou seus níveis de felicidade de 2 para 4%. No entanto, quando as mesmas pessoas telefonaram para a pessoa pela qual agradeceram por expressar sua gratidão diretamente, os níveis de felicidade saltaram de 4% para 19%.",
            "Não apenas expressar sua gratidão por alguém torna o dia um pouco mais brilhante, mas pode fazer maravilhas por aumentar seus próprios níveis de gratidão e felicidade a longo prazo.",
            "Se você estiver com dificuldades para sentir a gratidão no momento, vá passar um tempo com seus amigos e familiares. É claro que isso o ajudará a se aproximar mais deles e a fortalecer seu relacionamento, mas também lhe dará a chance de praticar seus atos de gratidão pelas pessoas de quem gosta.",
            "Comece pequeno se estiver com problemas para encontrar maneiras de apoiar seus amigos e familiares. Por exemplo, por que você não ouve atentamente na próxima vez que alguém compartilhar uma história com você, em vez de esperar pela sua chance de falar? Ou inicie uma conversa com um membro difícil da família elogiando seus sapatos novos ou cortando o cabelo.",
            "Mantenha um diário de gratidão e adicione-o todos os dias.",
            "Diga a alguém que você a ama e o quanto você a aprecia.",
            "Observe a beleza da natureza todos os dias.",
            "Cultive as amizades que você tem, bons amigos não aparecem todos os dias.",
            "Sorria com mais frequência.",
            "Assista a vídeos inspiradores que o lembrarão dos bons do mundo.",
            "Inclua um ato de bondade em sua vida todos os dias.",
            "Evite mídias e filmes negativos com conteúdo destrutivo.",
            "Chame sua mãe ou seu pai com mais frequência.",
            "Faça refeições com amor, pense nas pessoas que você irá alimentar.",
            "Voluntário para organizações que ajudam outras pessoas.",
            "Não fofoque nem fale mal de ninguém.",
            "Passe um tempo de qualidade com seus filhos ou com seu amante.",
            "Lembre-se de elogiar seus amigos e familiares quando eles estiverem bem.",
            "Escreva um cartão para alguém que você não vê há um tempo e diga algo legal.",
            "Adicione à sua lista de gratidão diariamente, pelo menos mais uma coisa por dia.",
            "Quando você pensa em um pensamento negativo, tente ver o lado positivo da situação.",
            "Confirme um dia da semana em que você não reclamará de nada.",
            "Tente tomar nota quando as pessoas fazem um bom trabalho e reconhecer quando é devido no trabalho.",
            "Esforço recompensador, se alguém fizer algo bom por você, faça algo bom por eles.",
            "Edite com sua lista de gratidão, dando graças por toda a sua boa sorte.",
            "Viva conscientemente, sem se preocupar com o passado ou o futuro.",
            "Obrigado às pessoas que o atendem na comunidade - o lojista, os motoristas de ônibus, etc.",
            "Diga obrigado pelas pequenas coisas que seus entes queridos fazem por você, coisas que você normalmente considera garantidas.",
            "Publique citações e imagens que o lembrem de ser grato em sua casa.",
            "Ligue para um vizinho idoso e agradeça a presença deles em sua vida.",
            "Chame seus avós e diga que os ama.",
            "Abrace desafios e transforme-os em oportunidades de crescimento.",
            "Envie amor aos seus inimigos ou pessoas que você não gosta.",
            "Seja grato quando aprender algo novo.",
            "Veja a oportunidade de crescimento com seus erros.",
            "Ajude seus amigos a ver o lado positivo da vida.",
            "Quando os tempos forem ruins, concentre-se nos amigos que estão ao seu lado.",
            "Quando o tempo estiver bom, observe e ajude os outros.",
            "Faça uma colagem de gratidão, recorte todas as coisas pelas quais você é grato.",
            "Faça da gratidão parte da vida familiar, compartilhe-a durante as refeições.",
            "Pratique gratidão no mesmo horário todos os dias para torná-lo um hábito.",
            "Concentre-se em seus pontos fortes.",
            "Compartilhe os benefícios da gratidão com a família e os amigos.",
            "Compartilhe gratidão todos os dias postando um tweet, postagem no Facebook ou Pinterest.",
            "A gratidão é uma emoção tão poderosa que pode melhorar sua vida de muitas maneiras. É muito difícil sentir-se deprimido ou sentir pena de si mesmo quando sente gratidão.",
            "Escreva. Mantenha um diário de gratidão. Experimente por 30 dias. Seja específico sobre o que você é grato. Observe como seus pensamentos se desenvolvem ao longo do tempo. Você pode começar simplesmente, mas quando você adiciona histórias e cores, fica mais poderoso.",
            "Fale sobre isso. Crie o hábito de falar sobre o que você agradece o ano todo. Isso reforçará seus sentimentos.",
            "Se você medita regularmente ou não, faça uma pausa algumas vezes ao dia. Concentre-se em um espírito de gratidão. Por quem você é grato? Traga a pessoa à mente. Imagine sua vida cercada de bênçãos.",
            "Expresse-o. Encontre o professor que fez a diferença em sua vida e diga a ele. Escreva uma nota pessoal e conte a uma amiga perdida o que ela significava para você.",
            "Procure. Se você quer ser grato, contate as pessoas com essa característica. Algumas pessoas simplesmente transbordam de entusiasmo e gratidão pela vida. Uma vez conheci uma senhora idosa que era exuberante com a vida. Ela estava em uma casa de repouso e poderia ter reclamado por horas. Em vez disso, ela me recebeu em seu quarto e começou a me contar sobre os pássaros do lado de fora da janela. Ela estava agradecida por sua companhia, por sua música pela manhã e por suas cores vibrantes. Ao ouvi-la, percebi que queria aquela faísca especial.",
            "Os benefícios de praticar gratidão são quase infinitos. As pessoas que praticam regularmente a gratidão dedicando um tempo para perceber e refletir sobre as coisas pelas quais são gratas por experimentar emoções mais positivas, sentem-se mais vivas, dormem melhor, expressam mais compaixão e bondade e até têm sistemas imunológicos mais fortes. E a gratidão não precisa ser reservada apenas para ocasiões importantes: claro, você pode expressar gratidão depois de receber uma promoção no trabalho, mas também pode ser grato por algo tão simples quanto um pedaço de torta deliciosa",
            "Refresque seus agradecimentos.\n"+
                    "        A melhor maneira de colher os benefícios da gratidão é perceber coisas novas pelas quais você é grato todos os dias. O diário de gratidão funciona porque muda lentamente a maneira como percebemos as situações, ajustando o que focamos. Embora você possa sempre ser grato por sua ótima família, apenas escrever \"Sou grato por minha família\" semana após semana não mantém seu cérebro alerta para novos momentos agradecidos. Seja específico ao escrever “Hoje meu marido me deu uma massagem no ombro quando soube que eu estava realmente estressada” ou “Minha irmã me convidou para jantar para que eu não tivesse que cozinhar depois de um longo dia”. E certifique-se de esticar-se além das grandes coisas bem à sua frente. Abrir os olhos para mais do mundo ao seu redor pode melhorar profundamente sua prática de gratidão. Faça um jogo de perceber coisas novas todos os dias.",
            "Ela decidiu agradecer ainda este ano. Toda vez que experimenta um momento de intensa gratidão, ela o escreve em um pedaço de papel e o coloca em uma jarra. Esvazie o frasco na véspera de Ano Novo e revise tudo o que ele escreveu. Quando algo de bom aconteceu, ela agora diz: \"Obrigado\". Imediatamente torna o momento mais significativo e assiste mais."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_five_list);
        list=(ListView)findViewById(R.id.list);
        DetailListAdapter adapter=new DetailListAdapter(this, itemname, "5");
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // TODO Auto-generated method stub
//                String Selecteditem = itemname[+position];
//                Log.d("Position", Selecteditem);
//                Intent intent = new Intent(FiveListActivity.this, FiveDetailList.class);
//                startActivity(intent);
            }
        });
    }
}