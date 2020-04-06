package com.renata.mentesaudvel.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.renata.mentesaudvel.Adapter.DetailListAdapter;
import com.renata.mentesaudvel.DetailList.EightDetailList;
import com.renata.mentesaudvel.DetailList.FiveDetailList;
import com.renata.mentesaudvel.R;

public class EightListActivity extends AppCompatActivity {
    ListView list;
    String[] itemname ={
            "Tire um tempo livre para você. Pratique ioga, ouça música, medite, faça uma massagem ou aprenda técnicas de relaxamento. Distanciar do problema ajuda a clarear sua cabeça.",

            "Coma refeições bem equilibradas. Não pule nenhuma refeição. Mantenha lanches saudáveis e que aumentam a energia à mão.",

            "Suspenda o uso de álcool e de cafeína, já que podem agravar a ansiedade e desencadear ataques de pânico.",

            "Durma o suficiente. Quando estressado, seu corpo precisa de sono e descanso adicionais.",

            "Faça exercícios diariamente para ajudá-lo a se sentir bem e manter sua saúde.",

            "Faça o seu melhor. Em vez de buscar a perfeição, o que não é possível, orgulhe-se do quanto você chegou perto da perfeição.",

            "Aceite que você não pode controlar tudo.",

            "Coloque seu estresse em perspectiva: é realmente tão ruim quanto você pensa? O que de pior poderia acontecer?",

            "Uma boa risada ajuda muito. Ria sempre que puder.",

            "Mantenha uma atitude positiva. Faça um esforço para substituir pensamentos negativos por positivos.",

            "Envolva-se. Seja voluntário ou encontre outra maneira de ser ativo em sua comunidade, o que cria uma rede de apoio e oferece uma pausa do estresse diário.",

            "Descubra o que desencadeia sua ansiedade. É o trabalho, a família, a escola ou algo mais que você pode identificar?",

            "Escreva em um diário quando estiver estressado ou ansioso e procure um padrão.",

            "Fale com alguém. Diga a amigos e familiares que você está se sentindo sobrecarregado e informe-os como eles podem ajudá-lo. Converse com um médico psiquiatria ou um terapeuta para obter ajuda profissional.",

            "Respire\n"+
                    "A respiração é a técnica número um e mais eficaz para reduzir a raiva e a ansiedade rapidamente.\n"+
                    "Quando você está ansioso ou com raiva, tende a respirar rápido e superficialmente. Isso envia uma mensagem ao seu cérebro, causando um ciclo, reforçando sua resposta de luta ou fuga. É por isso que respirar fundo, profundamente e acalmar, interrompe esse ciclo e ajuda você a se sentir melhor.\n"+
                    "Existem várias técnicas de respiração para ajudá-lo a se acalmar. \n"+
                    "- Uma é a respiração em três partes. A respiração em três partes requer que você respire profundamente e expire totalmente, enquanto presta atenção ao seu corpo.\n"+
                    "Depois de se sentir confortável com a respiração profunda, você pode alterar a proporção de inspiração e expiração para 1: 2 (diminua a expiração para que seja duas vezes maior que a sua inspiração).\n"+
                    "Pratique essas técnicas com calma, para saber como fazê-las quando estiver ansioso.",

            "Admita que você está ansioso ou com raiva\n"+
                    "Permita-se dizer que está ansioso ou com raiva. Quando você rotula como está se sentindo e se permite expressá-lo, a ansiedade e a raiva que está sentindo podem diminuir.",

            "Desafie seus pensamentos\n"+
                    "Parte de estar ansioso ou zangado é ter pensamentos disfuncionais (automáticos) que não fazem necessariamente sentido. Esses pensamentos costumam ser o \"pior cenário\". Você pode se ver preso no ciclo \"e se\", o que pode fazer com que você sabote muitas coisas em sua vida.\n"+
                    "Ao experimentar um desses pensamentos, pare e faça as seguintes perguntas:\n"+
                    "É provável que isso aconteça?\n"+
                    "Esse é um pensamento racional?\n"+
                    "Isso já aconteceu comigo antes?\n"+
                    "Qual o pior que pode acontecer? Eu posso lidar com isso?\n"+
                    "Depois que fizer essas perguntas, é hora de reformular seu pensamento. Em vez de \"não consigo apresentar esse trabalho. E se eu esquecer o que vou falar? \" diga a si mesmo: \"Há pessoas que apresentam, eu mesmo já apresentei outras vezes e nada pior aconteceu”.",

            "Libere a ansiedade ou a raiva\n"+
                    "Dê uma caminhada ou corra. Envolver-se em alguma atividade física libera serotonina para ajudá-lo a se acalmar e se sentir melhor”.\n",

            "Visualize-se calmo\n"+
                    "Esta dica exige que você pratique as técnicas de respiração que aprendeu. Depois de respirar fundo algumas vezes, feche os olhos e imagine-se calmo. Veja seu corpo relaxado e imagine-se trabalhando em uma situação estressante ou causadora de ansiedade mantendo-se calmo e concentrado.\n"+
                    "Ao criar uma imagem mental de como é manter a calma, você pode consultar essa imagem quando estiver ansioso.",

            "Pense nisso\n"+
                    "Tenha um mantra para usar em situações críticas. Apenas certifique-se de que você considere útil. \n"+
                    "\"Isso é realmente importante? ou \"Vou permitir que essa pessoa / situação roube minha paz?\n"+
                    "O que isso significará para mim daqui 10 anos? \n"+
                    "Isso permite que o pensamento mude o foco, e você pode \"testar a realidade\" da situação.\n"+
                    "Quando estamos ansiosos ou com raiva, ficamos hiper focados na causa e pensamentos racionais deixam nossa mente. Esses mantras nos dão a oportunidade de permitir que o pensamento racional volte e leve a um resultado melhor.",

            "Ouça música\n"+
                    "Na próxima vez que você sentir o nível de ansiedade aumentando, pegue um fone de ouvido e sintonize sua música favorita. Ouvir música pode ter um efeito muito calmante no corpo e na mente.",

            "Mude seu foco\n"+
                    "Deixe a situação, olhe em outra direção, saia da sala ou saia.",

            "Relaxe seu corpo\n"+
                    "Quando você está ansioso ou com raiva, pode parecer que todos os músculos do seu corpo estão tensos (e provavelmente estão). Praticar o relaxamento muscular progressivo pode ajudá-lo a se acalmar e a se concentrar.\n"+
                    "Para fazer isso, deite-se no chão com os braços estendidos ao seu lado. Verifique se seus pés não estão cruzados e que suas mãos não estão em punhos. Comece na ponta dos pés e diga a si mesmo para liberá-los. Mova lentamente seu corpo, dizendo a si mesmo para liberar cada parte do corpo até chegar à sua cabeça.",

            "Escreva\n"+
                    "Se você estiver com muita raiva ou ansioso para falar sobre isso, pegue um diário e escreva seus pensamentos. Não se preocupe com frases ou pontuação completas - basta escrever. Escrever ajuda a tirar pensamentos negativos da cabeça.\n"+
                    "Você pode dar um passo adiante e fazer um plano de ação para continuar calmo quando terminar de escrever.",

            "Tome ar fresco\n"+
                    "A temperatura e a circulação de ar em uma sala podem aumentar sua ansiedade ou raiva. Se você estiver se sentindo tenso e o espaço em que está quente e abafado, isso pode desencadear um ataque de pânico.\n"+
                    "Retire-se desse ambiente o mais rápido possível e saia para fora - mesmo que seja apenas por alguns minutos.\n"+
                    "Não só o ar fresco ajudará a acalmá-lo, mas também a mudança de cenário às vezes pode interromper seu processo de pensamento ansioso ou irritado.",

            "Abasteça seu corpo\n"+
                    "Se você estiver com fome ou não estiver adequadamente hidratado, muitas dessas técnicas não funcionarão. É por isso que é importante desacelerar e comer algo - mesmo que seja apenas um pequeno lanche.",

            "Solte os ombros\n"+
                    "Se seu corpo está tenso, há uma boa chance de sua postura sofrer. Sente-se alto, respire fundo e abaixe os ombros. Para fazer isso, concentre-se em juntar as omoplatas e depois descer. Isso puxa seus ombros para baixo. Faça algumas respirações profundas. Você pode fazer isso várias vezes ao dia.",

            "Tenha um objeto centralizador\n"+
                    "Quando você está ansioso ou com raiva, grande parte de sua energia está sendo gasta em pensamentos irracionais. Quando estiver calmo, encontre um \"objeto central\", como um pequeno bicho de pelúcia, uma pedra polida que você mantenha no bolso ou um medalhão que use no pescoço.\n"+
                    "Diga a si mesmo que tocará nesse objeto quando sentir ansiedade ou frustração. Isso o centraliza e ajuda a acalmar seus pensamentos. Por exemplo, se você está no trabalho e seu chefe a deixa ansiosa, esfregue suavemente o medalhão no pescoço.",

            "Identifique pontos de pressão para acalmar a raiva e a ansiedade\n"+
                    "Indo para uma massagem ou obter acupuntura é uma maneira maravilhosa de gerenciar a ansiedade e raiva. Mas nem sempre é fácil encontrar tempo no seu dia para que isso aconteça. A boa notícia é que você pode fazer acupressão em si mesmo para aliviar a ansiedade instantaneamente.\n"+
                    "Este método envolve pressionar com os dedos ou com a mão em determinados pontos do corpo. A pressão libera a tensão e relaxa seu corpo.\n"+
                    "Uma área para começar é o ponto em que a parte interna do pulso forma um vinco com a mão. Pressione o polegar nessa área por dois minutos. Isso pode ajudar a aliviar a tensão.",

            "Fique no seu fuso horário.\n"+
                    "A ansiedade é um estado de espírito orientado para o futuro. Então, em vez de se preocupar com o que vai acontecer, \"volte para o presente\", Pergunte a si mesmo: o que está acontecendo agora? Eu estou seguro? Há algo que eu preciso fazer agora? Caso contrário, faça um \"compromisso\" para se registrar no final do dia para revisar suas preocupações, para que esses cenários distantes não o tirem do caminho.",

            "Reconfigure o que está acontecendo.\n"+
                    "Os ataques de pânico costumam fazer você se sentir como se estivesse morrendo ou tendo um ataque cardíaco. Lembre-se: \"Estou tendo um ataque de pânico, mas é inofensivo, é temporário e não há nada que eu precise fazer”. Além disso, lembre-se de que é realmente o oposto de um sinal de morte iminente - seu corpo está ativando sua resposta de luta ou fuga, o sistema que o manterá vivo, diz ela.",

            "Verifique seus fatos.\n"+
                    "Pessoas com ansiedade geralmente se fixam nos piores cenários. Para combater ligue ou envie uma mensagem de texto para um amigo ou membro da família e fale suas preocupações com eles. Dizer em voz alta para outra pessoa pode ajudá-lo a vê-la claramente do que é.\" Também pode ajudar a escrever seus medos no papel.",

            "Assista a um vídeo engraçado.\n"+
                    "Essa tática final pode ser a mais fácil até agora: indique clipes de seu comediante favorito ou programa de TV engraçado. Rir é uma boa receita para uma mente ansiosa. Pesquisas mostram que o riso tem muitos benefícios para a nossa saúde mental e bem-estar; um estudo descobriu que o humor poderia ajudar a diminuir a ansieda.",

            "Exercício\n"+
                    "O exercício é uma das coisas mais importantes que você pode fazer para combater o estresse.\n"+
                    "Pode parecer contraditório, mas colocar o estresse físico em seu corpo através do exercício pode aliviar o estresse mental.\n"+
                    "Os benefícios são mais fortes quando você se exercita regularmente. Pessoas que se exercitam regularmente têm menos probabilidade de sentir ansiedade do que aquelas que não se exercitam.",

            "Hormônios do estresse: o exercício reduz os hormônios do estresse do corpo - como o cortisol - a longo prazo. Também ajuda a liberar endorfinas, substâncias químicas que melhoram seu humor e agem como analgésicos naturais.",

            "Sono: O exercício também pode melhorar sua qualidade de sono, que pode ser afetada negativamente pelo estresse e pela ansiedade.",

            "Confiança: Quando você se exercita regularmente, pode se sentir mais competente e confiante em seu corpo, o que, por sua vez, promove o bem-estar mental.",

            "Acenda uma vela\n"+
                    "Usar óleos essenciais ou queimar uma vela perfumada pode ajudar a reduzir seus sentimentos de estresse e ansiedade.\n"+
                    "Alguns aromas são especialmente calmantes. Aqui estão alguns dos aromas mais calmantes:\n"+
                    "Lavanda, Rosa, Bergamota, Camomila romana, Incenso, Flor de laranjeira ou laranja.",

            "Usar aromas para tratar o seu humor é chamado de aromaterapia. Vários estudos mostram que a aromaterapia pode diminuir a ansiedade e melhorar o sono.",

            "Reduza sua ingestão de cafeína\n"+
                    "A cafeína é um estimulante encontrado em café, chá, chocolate e bebidas energéticas. Altas doses podem aumentar a ansiedade.\n"+
                    "As pessoas têm limites diferentes para a quantidade de cafeína que podem tolerar.\n"+
                    "Se você perceber que a cafeína o deixa nervoso ou ansioso, considere reduzir.\n"+
                    "Embora muitos estudos mostrem que o café pode ser saudável com moderação, não é para todos. Em geral, cinco ou menos xícaras por dia é considerado uma quantidade moderada.",

            "Escreva\n"+
                    "Uma maneira de lidar com o estresse é escrever as coisas.\n"+
                    "Enquanto registra o que você está estressado, é uma abordagem, outra é anotar o que você agradece.\n"+
                    "A gratidão pode ajudar a aliviar o estresse e a ansiedade, concentrando seus pensamentos no que é positivo em sua vida.",

            "Goma de mascar\n"+
                    "Para um apaziguador super fácil e rápido, tente mascar um chiclete.\n"+
                    "Um estudo mostrou que as pessoas que mascavam chiclete tinham uma maior sensação de bem-estar e menor estresse.\n"+
                    "Uma explicação possível é que a goma de mascar causa ondas cerebrais semelhantes às de pessoas relaxadas. Outra é que a goma de mascar promove o fluxo sanguíneo no cérebro.\n"+
                    "Além disso, um estudo recente descobriu que o alívio do estresse era maior quando as pessoas mastigavam com mais força.",

            "Passe algum tempo com amigos e familiares\n"+
                    "O apoio social de amigos e familiares pode ajudá-lo a passar por momentos estressantes.\n"+
                    "Fazer parte de uma rede de amigos oferece um sentimento de pertencimento e valor próprio, o que pode ajudá-lo em tempos difíceis.\n"+
                    "Um estudo descobriu que, especialmente para as mulheres, passar tempo com amigos e crianças ajuda a liberar ocitocina, um calmante natural. Esse efeito é chamado de \"cuidar e fazer amizade\" e é o oposto da resposta de lutar ou fugir.\n"+
                    "Lembre-se de que homens e mulheres se beneficiam da amizade.\n"+
                    "Outro estudo descobriu que homens e mulheres com menos conexões sociais eram mais propensos a sofrer de depressão e ansiedade.",

            "Rir\n"+
                    "É difícil sentir ansiedade quando você está rindo. É bom para a sua saúde e existem algumas maneiras de ajudar a aliviar o estresse:\n"+
                    "Aliviando sua resposta ao estresse.\n"+
                    "Aliviando a tensão relaxando seus músculos.\n"+
                    "A longo prazo, o riso também pode ajudar a melhorar seu sistema imunológico e humor.\n"+
                    "Um estudo entre pessoas com câncer descobriu que as pessoas do grupo de intervenção do riso experimentaram mais alívio do estresse do que aquelas que estavam simplesmente distraídas. Tente assistir a um programa de TV engraçado ou sair com amigos que fazem você rir.",

            "Aprenda a dizer não\n"+
                    "Nem todos os estressores estão sob seu controle, mas alguns estão.\n"+
                    "Assuma o controle sobre as partes da sua vida que você pode mudar e causar estresse.\n"+
                    "Uma maneira de fazer isso pode ser dizer \"não\" com mais frequência.\n"+
                    "Isso é especialmente verdadeiro se você se comprometer com mais do que pode suportar, pois lidar com muitas responsabilidades pode deixar você se sentindo sobrecarregado.\n"+
                    "Ser seletivo sobre o que você assume - e dizer não a coisas que aumentarão desnecessariamente sua carga - pode reduzir seus níveis de estresse.",

            "Aprenda a evitar a procrastinação\n"+
                    "Outra maneira de controlar o estresse é manter-se no topo de suas prioridades e parar de procrastinar.\n"+
                    "A procrastinação pode levá-lo a agir de maneira reativa, deixando você se esforçando para alcançá-lo. Isso pode causar estresse, o que afeta negativamente sua saúde e qualidade do sono.\n"+
                    "Adquira o hábito de fazer uma lista de tarefas organizada por prioridade. Dê a si mesmo prazos realistas e trabalhe na lista.\n"+
                    "Trabalhe nas coisas que precisam ser feitas hoje e ofereça a si próprio pedaços de tempo ininterrupto, pois alternar entre tarefas ou multitarefa pode ser estressante.",

            "Faça uma aula de ioga\n"+
                    "Yoga tornou-se um método popular de alívio do estresse e exercícios entre todas as faixas etárias.\n"+
                    "Embora os estilos de ioga sejam diferentes, a maioria compartilha um objetivo comum - unir-se ao corpo e à mente.\n"+
                    "O yoga faz isso principalmente aumentando a consciência corporal e respiratória.\n"+
                    "Alguns estudos examinaram o efeito do yoga na saúde mental. No geral, a pesquisa descobriu que o yoga pode melhorar o humor e pode até ser tão eficaz quanto os antidepressivos no tratamento da depressão e da ansiedade.\n"+
                    "No entanto, muitos desses estudos são limitados e ainda há dúvidas sobre como o yoga funciona para alcançar a redução do estresse.\n"+
                    "Em geral, o benefício do yoga para o estresse e a ansiedade parece estar relacionado ao seu efeito no sistema nervoso e na resposta ao estresse.\n"+
                    "Pode ajudar a diminuir os níveis de cortisol, pressão arterial e batimentos cardíacos e aumentar o ácido gama-aminobutírico (GABA), um neurotransmissor que diminui os distúrbios de humor.",

            "Abraço\n"+
                    "Abraços, beijos, abraços e sexo podem ajudar a aliviar o estresse.\n"+
                    "O contato físico positivo pode ajudar a liberar ocitocina e diminuir o cortisol. Isso pode ajudar a diminuir a pressão sanguínea e a frequência cardíaca, os quais são sintomas físicos de estresse.\n"+
                    "Curiosamente, os seres humanos não são os únicos animais que abraçam para aliviar o estresse. Os chimpanzés também abraçam amigos estressados.",

            "Ouça música suave\n"+
                    "Ouvir música pode ter um efeito muito relaxante no corpo.\n"+
                    "A música instrumental em ritmo lento pode induzir a resposta de relaxamento, ajudando a baixar a pressão arterial e a frequência cardíaca, bem como os hormônios do estresse.\n"+
                    "Alguns tipos de música clássica podem ser particularmente reconfortantes, mas simplesmente ouvir a música que você gosta também é eficaz.\n"+
                    "Os sons da natureza também podem ser muito calmantes. É por isso que eles costumam ser incorporados à música de relaxamento e meditação.",

            "Respiração Profunda\n"+
                    "O estresse mental ativa seu sistema nervoso simpático, sinalizando para que seu corpo entre no modo \"lutar ou fugir\".\n"+
                    "Durante essa reação, os hormônios do estresse são liberados e você experimenta sintomas físicos como batimentos cardíacos mais rápidos, respiração mais rápida e vasos sanguíneos contraídos.\n"+
                    "Exercícios de respiração profunda podem ajudar a ativar o sistema nervoso parassimpático, que controla a resposta do relaxamento.\n"+
                    "Existem vários tipos de exercícios de respiração profunda, incluindo respiração diafragmática, abdominal, abdominal e respiratória.\n"+
                    "O objetivo da respiração profunda é focar sua atenção na respiração, tornando-a mais lenta e profunda. Quando você respira profundamente pelo nariz, seus pulmões se expandem completamente e sua barriga sobe.\n"+
                    "Isso ajuda a diminuir a frequência cardíaca, permitindo que você se sinta mais tranquilo.",

            "Passe algum tempo com seu animal de estimação\n"+
                    "Ter um animal de estimação pode ajudar a reduzir o estresse e melhorar o seu humor.\n"+
                    "Interagir com animais de estimação pode ajudar a liberar a ocitocina, uma substância química do cérebro que promove um humor positivo.\n"+
                    "Ter um animal de estimação também pode ajudar a aliviar o estresse, dando-lhe um propósito, mantendo-o ativo e proporcionando companhia - todas as qualidades que ajudam a reduzir a ansiedade.",

            "Exercício, atenção, música e intimidade física podem funcionar para aliviar a ansiedade - e também melhorarão seu equilíbrio geral entre trabalho e vida pessoal.",

            "Alguma ansiedade é uma parte normal da vida. É um subproduto da vida em um mundo frequentemente caótico. A ansiedade não é tão ruim assim. Isso o conscientiza do perigo, o motiva a manter-se organizado e preparado e ajuda a calcular os riscos. Ainda assim, quando a ansiedade se torna uma luta diária, é hora de agir.",

            "Mantenha-se ativo\n"+
                    "O exercício regular é bom para sua saúde física e emocional. O exercício regular funciona bem como medicamentos para aliviar a ansiedade de algumas pessoas. E não é apenas uma correção de curto prazo; você pode sentir alívio da ansiedade por horas depois de se exercitar.",

            "não beba álcool\n"+
                    "O álcool é um sedativo natural. Beber uma taça de vinho ou um dedo de uísque quando seus nervos são atingidos pode acalmá-lo a princípio. Quando o zumbido termina, no entanto, a ansiedade pode voltar com uma vingança. Se você usa álcool para aliviar a ansiedade, em vez de tratar a raiz do problema, pode desenvolver dependência do álcool.",

            "Pare de fumar\n"+
                    "Os fumantes costumam pegar um cigarro durante períodos estressantes. No entanto, como beber álcool, dar uma tragada no cigarro quando você está estressado é uma solução rápida que pode piorar a ansiedade ao longo do tempo. A pesquisa mostrou que quanto mais cedo você começar a fumar, maior será o risco de desenvolver um transtorno de ansiedade posteriormente. A pesquisa também sugere que a nicotina e outros produtos químicos na fumaça do cigarro alteram as vias do cérebro ligadas à ansiedade.\n"+
                    "\n"+
                    "Nada de cafeína\n"+
                    "Se você tem ansiedade crônica, a cafeína não é sua amiga. A cafeína pode causar nervosismo e nervosismo, nada disso é bom se você estiver ansioso. A pesquisa mostrou que a cafeína pode causar ou piorar os transtornos de ansiedade. Também pode causar ataques de pânico em pessoas com transtorno do pânico. Em algumas pessoas, a eliminação da cafeína pode melhorar significativamente os sintomas de ansiedade.",

            "Durma um pouco\n"+
                    "A insônia é um sintoma comum da ansiedade. Faça do sono uma prioridade.",

            "Pratique respiração profunda\n"+
                    "A respiração superficial e rápida é comum com ansiedade. Pode levar a um ritmo cardíaco acelerado, tontura ou tontura ou até um ataque de pânico. Exercícios de respiração profunda - o processo deliberado de respirar devagar, mesmo que profundamente - podem ajudar a restaurar os padrões normais de respiração e reduzir a ansiedade.",

            "Beba chá de camomila\n"+
                    "Uma xícara de chá de camomila é um remédio caseiro comum para acalmar os nervos desgastados e promover o sono. Um estudo de 2009 mostrou que a camomila também pode ser um poderoso aliado contra o transtorno de ansiedade generalizada. O estudo descobriu que as pessoas que tomaram cápsulas de camomila alemã (220 miligramas até cinco vezes por dia) tiveram uma redução maior nas pontuações dos testes que medem os sintomas de ansiedade do que aqueles que receberam um placebo."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_eight_list);
        list=(ListView)findViewById(R.id.list);
        DetailListAdapter adapter=new DetailListAdapter(this, itemname, "8");
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // TODO Auto-generated method stub
//                String Selecteditem = itemname[+position];
//                Log.d("Position", Selecteditem);
//                Intent intent = new Intent(EightListActivity.this, EightDetailList.class);
//                startActivity(intent);
            }
        });
    }
}