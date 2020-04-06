package com.renata.mentesaudvel.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.renata.mentesaudvel.Adapter.DetailListAdapter;
import com.renata.mentesaudvel.DetailList.OneDetailList;
import com.renata.mentesaudvel.DetailList.TwoDetailList;
import com.renata.mentesaudvel.R;

public class TwoListActivity extends AppCompatActivity {
    ListView list;
    String[] itemname ={
            "Domine uma nova habilidade.\n" +
                    "Quando você se torna hábil em algo que corresponde aos seus talentos e interesses, aumenta seu senso de competência.",

            "Liste suas realizações.\n" +
                    "Pense em todas as coisas que você realizou e depois as anote. Faça uma lista de tudo o que você fez e do qual se sente orgulhoso, tudo o que fez bem. Revise sua lista quando precisar de um lembrete de sua capacidade de fazer as coisas e fazê-las bem.",

            "Faça algo criativo.\n" +
                    "Tarefas criativas são uma ótima maneira de colocar o fluxo de volta em sua vida. A criatividade estimula o cérebro; portanto, quanto mais você o usa, maiores são os benefícios. Pegue seu violão antigo, escreva uma história ou poema, faça uma aula de dança ou inscreva-se em uma produção de teatro. Quando você adiciona o desafio de tentar algo novo, isso ajuda você ainda mais.",

            "Seja claro sobre seus valores.\n" +
                    "Determine quais são seus valores e examine sua vida para ver onde você não está vivendo alinhado com o que acredita. Em seguida, faça as alterações necessárias. Quanto mais você souber o que representa, mais confiante estará.",

            "Desafie suas crenças limitantes.\n" +
                    "Quando você se pegar pensando negativamente sobre si mesmo, pare e desafie a si mesmo. Não se deixe limitar por crenças errôneas.",

            "Fique na extremidade da sua zona de conforto.\n" +
                    "Estique-se e vá até a borda da sua zona de conforto. Fique desconfortável - tente algo novo, conheça pessoas diferentes ou encare uma situação de maneira não convencional. A confiança começa na extremidade da sua zona de conforto.",

            " Ajude alguém.\n" +
                    "Use seus talentos, habilidades e habilidades para ajudar os outros. Ajude alguém diretamente, compartilhe recursos úteis ou ensine a alguém algo que eles querem aprender. Ofereça algo que você faz bem como presente a alguém. \n" +
                    "O voluntariado pode ajudar aqueles que tem menos sorte. “Estar ao serviço dos outros ajuda a tirar você da sua cabeça. Quando você é capaz de ajudar alguém, isso o torna menos focado em seus próprios problemas”. \n" +
                    "Ajudar outra pessoa geralmente nos permite esquecer de nós mesmos e sentir gratidão pelo que temos. Também é bom quando você é capaz de fazer a diferença para outra pessoa.\n" +
                    "Em vez de se concentrar em suas próprias fraquezas, seja voluntário como mentor, ajude ou ensine outra pessoa e você verá sua autoconfiança crescer automaticamente no processo.",

            "Cure seu passado.\n" +
                    "Problemas não resolvidos podem mantê-lo preso em baixa autoestima. Procure o apoio de um psiquiatra ou um psicólogo para ajudá-lo a curar o passado, para poder avançar para o futuro de maneira confiante e segura de si.",

            "Faça uma coisa que assusta você todos os dias.\n" +
                    "Se você é inseguro, adivinhe? O resto do mundo também é. Não superestime a concorrência e subestime a si mesmo. Você é melhor do que pensa.\n" +
                    "A melhor maneira de superar o medo é enfrentá-lo de frente. Fazendo algo que o assusta todos os dias e ganhando confiança em cada experiência, você verá sua autoconfiança disparar. Então saia da sua zona de conforto e enfrente seus medos!",

            "Questione seu crítico interno.\n" +
                    "Você vem se criticando há anos e não funcionou. Tente se aprovar e veja o que acontece.\n",

            "Prepare-se para vencer.\n" +
                    "Para estabelecer a verdadeira autoconfiança, precisamos nos concentrar em nossos sucessos e esquecer as falhas e os negativos em nossas vidas. Muitas pessoas ficam desanimadas com suas habilidades porque estabelecem metas que são muito difíceis de alcançar. Comece definindo pequenas metas que você pode vencer facilmente.",

            "Pare de se preocupar com o que os outros pensam.\n" +
                    "Quando você se preocupa com o que os outros pensam de você, você nunca se sente livre para ser completamente você mesmo. Tome uma decisão firme para parar de se preocupar com o que as outras pessoas pensam - comece a fazer escolhas com base no que você deseja, não no que você acha que os outros querem de você.",

            "Leia algo inspirador.\n" +
                    "Uma ótima maneira de obter mais autoestima é ler algo que o estimule e faça você se sentir positivo sobre si mesmo.",

            "Recupere sua integridade.\n" +
                    "Defina o que integridade significa para você e garanta que você esteja vivendo de acordo com esse entendimento. Se a sua vida não estiver alinhada com o seu personagem, isso o esgotará e fará você se sentir mal consigo mesmo.",

            "Deixe as pessoas negativas irem.\n" +
                    "Se houver pessoas negativas em sua vida - que não têm nada de positivo a dizer ou que o decepcionam ou se aproveitam de você -, faça a coisa inteligente e deixe-as ir. A única maneira de encontrar sua autoestima é cercar-se de pessoas positivas que o admiram e valorizam.",

            "Preocupe-se com sua aparência.\n" +
                    "Quando você olha o seu melhor, você se sente melhor. Vista-se como alguém que tenha confiança e permita que sua autoconfiança apareça na aparência.",

            "Entenda o fracasso como parte do crescimento.\n" +
                    "É uma resposta comum ser duro consigo mesmo quando você falha. Mas se você puder mudar seu pensamento para entender que o fracasso é uma oportunidade de aprender, que desempenha um papel necessário no aprendizado e no crescimento, pode ajudá-lo a manter a perspectiva. Lembre-se também de que o fracasso significa que você está fazendo um esforço.",

            "Seja sempre um aprendiz\n" +
                    "Pense em você como um aprendiz ao longo da vida. Aborde tudo o que você faz com a mentalidade de um aluno - o que os budistas zen chamam de \"mente de iniciante\" - aberto, ansioso, imparcial e disposto a aprender.",

            "Enfrente seu medo.\n" +
                    "Permita-se sentir medo, mas continue assim mesmo. A autoestima é frequentemente encontrada na dança entre seus desejos mais profundos e seus maiores medos.",

            "Ter alta autoestima é realmente uma coisa boa, mas apenas com moderação. \n" +
                    "A autoestima muito alta - como a dos narcisistas - geralmente é bastante frágil. Essas pessoas podem se sentir bem consigo mesmas a maior parte do tempo, mas também tendem a ser extremamente vulneráveis a críticas e feedback negativo e respondem a elas de maneiras que atrapalham seu crescimento psicológico.",

            "Torne-se um mentor.\n" +
                    "Esteja lá para alguém que precisa de sua orientação, liderança e apoio. O respeito e a gratidão deles - e observá-los progredir com a sua ajuda - aumentarão sua autoestima e auto-respeito.\n",

            "Reconheça sucessos\n" +
                    "Muitas vezes, pessoas com baixa auto-estima descartam seus sucessos como sorte ou acaso. Ou eles podem se concentrar em não serem perfeitos, em vez de destacar até que ponto chegaram. Pessoas com alta auto-estima dedicam um tempo para celebrar suas realizações. Eles dizem: \"Obrigado\", quando as pessoas os elogiam, em vez de dispensar seus elogios. Isso não significa que pessoas com alta auto-estima sejam arrogantes ou narcisistas; eles apenas confiam em suas habilidades e reconhecem sucessos quando acontecem.",

            "Mude para uma mentalidade de igualdade.\n" +
                    "Desejar ser outra pessoa é um desperdício da pessoa que você é. Pessoas com baixa autoconfiança veem os outros como melhores ou mais merecedores do que eles. Em vez de carregar essa percepção, veja a si mesmo como sendo igual a todos. Eles não são melhores ou mais merecedores do que você. Faça uma mudança mental para uma mentalidade de igualdade e você verá automaticamente uma melhoria em sua autoconfiança.",

            "Use afirmações positivas corretamente\n" +
                    "Afirmações positivas como \"Vou ser um grande sucesso!\" são extremamente populares, mas têm um problema crítico: tendem a fazer com que as pessoas com baixa autoestima se sintam piores consigo mesmas. Por quê? Porque quando nossa autoestima é baixa, essas declarações são simplesmente muito contrárias às nossas crenças existentes. Ironicamente, afirmações positivas funcionam para um subconjunto de pessoas - aquelas cuja autoestima já é alta. Para que as afirmações funcionem quando sua autoestima está atrasada, ajuste-as para torná-las mais críveis. Por exemplo, altere \"Vou ser um grande sucesso!\" para \"vou perseverar até conseguir!",

            "Identifique suas competências e desenvolva-as\n" +
                    "A autoestima é construída demonstrando capacidade e conquista reais em áreas de nossas vidas que são importantes para nós. Se você se orgulha de ser um bom cozinheiro, faça mais jantares. Se você é um bom corredor, inscreva-se nas corridas e treine para elas. Em resumo, descubra suas principais competências e encontre oportunidades e carreiras que as acentuem.",

            "Aprenda a aceitar elogios\n" +
                    "Um dos aspectos mais difíceis de melhorar a autoestima é que, quando nos sentimos mal com relação a nós mesmos, tendemos a ser mais resistentes a elogios - mesmo que seja quando mais precisamos deles. Portanto, defina o objetivo de tolerar elogios ao recebê-los, mesmo que eles o deixem desconfortável (e eles o farão). A melhor maneira de evitar as reações reflexivas dos elogios a rebater é preparar respostas simples e treinadas para usá-las automaticamente sempre que você obtiver um bom feedback (por exemplo, \"Obrigado\" ou \"Que gentileza você diz\"). Com o tempo, o impulso de negar ou rejeitar elogios desaparecerá - o que também será uma boa indicação de que sua autoestima está ficando mais forte.",

            "Eliminar a autocrítica e introduzir a autocompaixão\n" +
                    "Infelizmente, quando nossa autoestima é baixa, é provável que a prejudicamos ainda mais por sermos autocríticos. Como nosso objetivo é aumentar nossa autoestima, precisamos substituir a autocrítica (que quase sempre é totalmente inútil, mesmo que pareça convincente) pela autocompaixão. Especificamente, sempre que o seu monólogo interno autocrítico aparecer, pergunte a si mesmo o que você diria a um amigo querido se ele estivesse na sua situação (tendemos a ser muito mais compassivos com os amigos do que com nós mesmos) e direcione esses comentários para si mesmo. Fazer isso evitará prejudicar ainda mais sua autoestima com pensamentos críticos e, em vez disso, ajudará a desenvolvê-la.",

            "Afirme seu verdadeiro valor\n" +
                    "O exercício a seguir foi demonstrado para ajudar a reavivar sua autoestima após sofrer um golpe: Faça uma lista de qualidades que você possui que são significativas no contexto específico. Por exemplo, se você foi rejeitado por sua data, liste as qualidades que o tornam um bom candidato a um relacionamento (por exemplo, ser leal ou emocionalmente disponível); se você não conseguiu uma promoção no trabalho, liste as qualidades que o tornam um funcionário valioso (você tem uma ética de trabalho forte ou é responsável). Em seguida, escolha um dos itens da sua lista e escreva um breve ensaio (de um a dois parágrafos) sobre por que a qualidade é valiosa e provavelmente será apreciada por outras pessoas no futuro. Faça o exercício todos os dias durante uma semana ou sempre que precisar de um aumento na autoestima.",

            "Em poucas palavras, a autoestima é sua opinião sobre si mesmo e sobre suas habilidades.\n" +
                    " Pode ser alto, baixo ou em algum lugar intermediário. Embora todos ocasionalmente tenham dúvidas sobre si mesmos, a baixa autoestima pode fazer com que você se sinta inseguro e desmotivado. Você pode identificar algumas coisas que estão afetando sua opinião sobre si mesmo (talvez você esteja sofrendo bullying ou esteja se sentindo sozinho), ou pode ser um mistério.",

            "Seja legal consigo mesmo\n" +
                    "Essa pequena voz que diz que você está matando (ou não) é muito mais poderosa do que você imagina. Faça um esforço para ser gentil consigo mesmo\n" +
                    " e, se você escorregar, tente desafiar quaisquer pensamentos negativos. Uma boa regra é falar consigo mesmo da mesma maneira que falaria com seus companheiros. Isso pode ser realmente difícil no começo, mas a prática leva à perfeição. Se você quiser algumas dicas, confira nossas dicas para conversar.",

            "Comparar-se a outras pessoas é uma maneira infalível de começar a se sentir mal. Tente se concentrar em seus próprios objetivos e realizações, em vez de compará-los com os de outra pessoa. Ninguém precisa desse tipo de pressão!\n" +
                    "O exercício é uma ótima maneira de aumentar a motivação, praticar o estabelecimento de metas e criar confiança. Quebrar o suor também leva o corpo a liberar endorfinas, os hormônios da sensação boa.",

            "Ninguém é perfeito\n" +
                    "Sempre se esforce para ser a melhor versão de si mesmo, mas também é importante aceitar que a perfeição é uma meta irrealista.",

            "Crie limites pessoais.\n" +
                    "Nunca seja intimidado em silêncio. Não aceite a definição de ninguém da sua vida, mas defina a si mesmo.\n" +
                    "Aprenda a dizer não. Ensine os outros a respeitar seus limites pessoais. Se necessário, faça aulas de como ser mais assertivo e aprenda a pedir o que deseja. Quanto mais controle e dizer que você tiver sobre sua própria vida, maior será sua autoconfiança.",

            "Concentre-se no que você pode mudar\n" +
                    "É fácil ficar preso a todas as coisas que estão fora de seu controle, mas não vai conseguir muito. Em vez disso, tente concentrar sua energia na identificação das coisas que estão sob seu controle e vendo o que você pode fazer sobre elas.",

            "Faça o que te faz feliz\n" +
                    "Se você gasta algum tempo fazendo as coisas de que gosta, é mais provável que pense positivamente. Tente agendar um pouco para você todos os dias. Seja o tempo gasto lendo, cozinhando ou apenas conversando um pouco no sofá, se isso o faz feliz, reserve um tempo para isso.",

            "Celebre as pequenas coisas\n" +
                    "Você acordou a tempo esta manhã. Carraça. Você escalfou seus ovos com perfeição. Ganhando. Celebrar as pequenas vitórias é uma ótima maneira de criar confiança e começar a se sentir melhor consigo mesmo.",

            "Seja um amigo\n" +
                    "Ser útil e atencioso com outras pessoas certamente aumentará seu humor, mas também fará você se sentir bem consigo mesmo.",

            "Cerque-se de um esquadrão de apoio\n" +
                    "Encontre pessoas que fazem você se sentir bem consigo mesmo e evite aquelas que tendem a desencadear seu pensamento negativo.",

            "Quando se trata de valor próprio, apenas uma opinião realmente importa - a sua. E mesmo esse deve ser cuidadosamente avaliado; nós tendemos a ser nossos próprios críticos mais severos.\n" +
                    "41. Alguns navegam pelo mundo - e pelos relacionamentos - procurando por qualquer evidência para validar suas crenças autolimitantes. Assim como o juiz e o júri, eles constantemente se julgam e às vezes se sentenciam a uma vida inteira de autocrítica.",
            "Seja cuidadoso.\n" +
                    "Não podemos mudar algo se não reconhecermos que há algo para mudar. Simplesmente tomando consciência de nossa conversa interna negativa, começamos a nos distanciar dos sentimentos que ela traz à tona. Isso nos permite identificar menos com eles. Sem essa consciência, podemos facilmente cair na armadilha de acreditar em nossa conversa autolimitada. \"Não acredite em tudo que você pensa. Pensamentos são apenas isso - pensamentos.\n" +
                    "Assim que se encontrar no caminho da autocrítica, observe cuidadosamente o que está acontecendo, tenha curiosidade e lembre-se: \"São pensamentos, não fatos\".",

            "Todos nós temos uma narrativa ou uma história que criamos sobre nós mesmos que molda nossas autopercepções, nas quais nossa autoimagem principal se baseia. Se queremos mudar essa história, precisamos entender de onde ela veio e de onde recebemos as mensagens que dizemos a nós mesmos.",

            "Cuide-se.\n" +
                    "O autocuidado nunca é um ato egoísta - é simplesmente uma boa mordomia do único presente que tenho, o presente que fui colocado na terra para oferecer aos outros.\n" +
                    "A autoconfiança depende de uma combinação de boa saúde física, emocional e social. É difícil se sentir bem consigo mesmo se você odeia seu corpo ou constantemente tem pouca energia.",

            "Canalize sua estrela do rock interior.\n" +
                    "Albert Einstein disse: “Todo mundo é um gênio. Mas se você julgar um peixe por sua capacidade de escalar uma árvore, ele viverá a vida inteira acreditando que é estúpido.” Todos nós temos nossos pontos fortes e fracos. Alguém pode ser um músico brilhante, mas um cozinheiro terrível. Nenhuma qualidade define seu valor principal. Reconheça quais são seus pontos fortes e os sentimentos de confiança que eles geram, especialmente em tempos de dúvida. É fácil fazer generalizações quando você \"bagunça\" ou \"falha\" em alguma coisa, mas lembrar-se das maneiras como agita oferece uma perspectiva mais realista de si mesmo.",

            "Exercício.\n" +
                    "Muitos estudos mostraram uma correlação entre exercício e maior autoestima, além de melhorar a saúde mental. O exercício organiza seu dia em torno do autocuidado.” Ela sugere deixar uma tarefa diariamente da sua lista interminável de tarefas, com o único objetivo de relaxar ou fazer algo divertido, e ver como isso se sente. Outras formas de autocuidado, como nutrição adequada e sono suficiente, também demonstraram ter efeitos positivos na autopercepção de alguém.",

            "Visualize-se como você deseja ser.\n" +
                    "Visualização é a técnica de ver uma imagem sua de que você se orgulha, em sua própria mente. Quando lutamos com baixa autoconfiança, temos uma percepção ruim de nós mesmos que geralmente é imprecisa. Pratique a visualização de uma versão fantástica de si mesmo, atingindo seus objetivos.",

            "Há muita verdade no fato de que o que divulgamos no mundo tende a voltar para nós. \n" +
                    "Para testar isso, passe um dia intencionalmente divulgando pensamentos e comportamentos positivos em relação àqueles com quem você entra em contato. Ao longo do dia, lembre-se do que volta a você e observe também se seu humor melhora.",

            "Perdão.\n" +
                    "Existe alguém na sua vida que você não perdoou? Um ex-parceiro? Um membro da família? Você mesmo? Ao nos apegarmos a sentimentos de amargura ou ressentimento, nos mantemos presos em um ciclo de negatividade. Se não nos perdoamos, a vergonha nos manterá nesse mesmo ciclo.\n" +
                    "“Perdoar a si mesmo e aos outros melhora a autoestima”. “talvez porque nos conecte com nossa natureza inatamente amorosa e promova a aceitação das pessoas, apesar de nossas falhas.” Ele se refere à meditação budista sobre perdão, que pode ser praticada a qualquer momento: \"Se machuquei ou machuquei alguém, consciente ou inconscientemente, peço perdão. Se alguém me machucou ou machucou, consciente ou inconscientemente, eu os perdoo. Pelas maneiras como me magoei, consciente ou inconscientemente, ofereço perdão. \"",

            "Lembre-se de que você não é sua circunstância.\n" +
                    "Finalmente, aprender a diferenciar suas circunstâncias e quem você é a chave para a autoestima. \"O reconhecimento do valor interno e o amor ao eu imperfeito fornecem a base segura para o crescimento\". \"Com essa segurança, é possível crescer com prazer, sem medo do fracasso - porque o fracasso não muda o valor principal\".",

            "Todos nós nascemos com potencial infinito e igual valor como seres humanos. \n" +
                    "Que somos menos do que isso é uma crença falsa que aprendemos ao longo do tempo. Portanto, com muito trabalho e autocompaixão, pensamentos e crenças autodestrutivas podem ser desaprendidos. Tomar as medidas descritas acima é um começo no esforço para aumentar a autoestima ou \"reconhecer a autoestima. Já existe em cada pessoa. \"",

            "O que é autoestima?\n" +
                    "Autoestima é a opinião que temos de nós mesmos.\n" +
                    "Quando temos uma autoestima saudável, tendemos a nos sentir positivos em relação a nós mesmos e à vida em geral. Isso nos torna mais capazes de lidar com os altos e baixos da vida.\n" +
                    "Quando nossa autoestima é baixa, tendemos a ver a nós mesmos e a nossa vida sob uma luz mais negativa e crítica. Também nos sentimos menos capazes de enfrentar os desafios que a vida nos representa.",

            "O que causa baixa autoestima?\n" +
                    "Baixa autoestima geralmente começa na infância. Professores, amigos, irmãos, pais e até a mídia nos enviam mensagens sobre nós mesmos, tanto positivas quanto negativas.\n" +
                    "54. Estresse e eventos difíceis da vida, como doenças graves ou luto, podem ter um efeito negativo na autoestima.",

            "A personalidade também pode desempenhar um papel. \n" +
                    "Algumas pessoas são mais propensas a pensamentos negativos, enquanto outras estabelecem padrões impossivelmente altos para si mesmas.",

            "Como a baixa autoestima nos afeta?\n" +
                    "Se você tem baixa autoestima ou confiança, pode se esconder das situações sociais, parar de tentar coisas novas e evitar coisas que considera desafiadoras.\n" +
                    "Viver com baixa autoestima pode prejudicar sua saúde mental, causando problemas como depressão e ansiedade.\n" +
                    "Você também pode desenvolver hábitos inúteis, como fumar e beber demais, como forma de lidar com isso.",

            "Como ter autoestima saudável\n" +
                    "Para aumentar sua autoestima, você precisa identificar as crenças negativas que tem sobre si mesmo e desafiá-las.\n" +
                    "Você pode dizer a si mesmo que é \"burro demais\" para se candidatar a um novo emprego, por exemplo, ou que \"ninguém se importa\" com você.\n" +
                    "Comece a anotar esses pensamentos negativos e anotá-los em um pedaço de papel ou em um diário. Pergunte a si mesmo quando você começou a ter esses pensamentos.",

            "Como ter autoestima saudável\n" +
                    "Comece a anotar evidências que desafiam essas crenças negativas: \"Sou realmente bom em palavras cruzadas enigmáticas\" ou \"Minha irmã pede um bate-papo toda semana\".\n" +
                    "Anote outras coisas positivas sobre você, como \"Sou atencioso\" ou \"Sou um ótimo cozinheiro\" ou \"Sou alguém em quem os outros confiam\".",

            "Como ter autoestima saudável \n" +
                    "Anote as coisas boas que outras pessoas dizem sobre você.\n" +
                    "Procure ter pelo menos cinco itens em sua lista e adicione-os regularmente. Em seguida, coloque sua lista em algum lugar que você possa vê-la. Dessa forma, você pode se lembrar de que está bem.",

            "Reconheça no que você é bom\n" +
                    "Todos somos bons em alguma coisa, seja cozinhar, cantar, fazer quebra-cabeças ou ser um amigo. Também gostamos de fazer as coisas em que somos bons, o que pode ajudar a melhorar o seu humor.",

            "Construa relacionamentos positivos\n" +
                    "Se você achar que certas pessoas tendem a derrubá-lo, tente passar menos tempo com elas ou diga como se sente sobre as palavras ou ações delas.\n" +
                    "Procure relacionamentos com pessoas que são positivas e que apreciam você.",

            "Seja gentil consigo mesmo\n" +
                    "O professor Williams aconselha: \"Seja compassivo consigo mesmo. Isso significa ser gentil consigo mesmo às vezes em que você sente autocrítica.\n" +
                    "Pense no que você diria a um amigo em uma situação semelhante. Muitas vezes damos conselhos muito melhores aos outros do que a nós mesmos.\"",

            "Comece a dizer 'não'\n" +
                    "Pessoas com baixa autoestima geralmente sentem que precisam dizer sim a outras pessoas, mesmo quando realmente não querem.\n" +
                    "O risco é que você fique sobrecarregado, ressentido, zangado e deprimido.\n" +
                    "Na maioria das vezes, dizer não perturba os relacionamentos. Pode ser útil continuar dizendo não de maneiras diferentes até que eles recebam a mensagem.",

            "Desafie-se\n" +
                    "Todos nos sentimos nervosos ou com medo de fazer as coisas às vezes. Mas as pessoas com autoestima saudável não deixam esses sentimentos impedi-los de tentar coisas novas ou assumir desafios.\n" +
                    "Defina uma meta para você, como participar de uma aula de ginástica ou ir a uma ocasião social. Atingir seus objetivos ajudará a aumentar sua autoestima.",

            "Nada é mais importante do que como você se sente e pensa sobre si mesmo.\n" +
                    "Uma opinião alta sobre você e quem você é e o que faz e, basicamente, um amor a si mesmo também é uma das coisas das quais as pessoas geralmente sentem falta ou têm muito pouco na sociedade de hoje.",

            "Por que a construção e a capacidade de manter alta autoestima são tão importantes?\n" +
                    "A vida se torna mais simples e mais leve.\n" +
                    "Quando você gosta ou se ama mais, as coisas simplesmente se tornam mais fáceis.\n" +
                    "Você não fará montanhas de montes de terra (ou do ar puro) quase com tanta frequência. Você não se rebaixará ou se machucará por erros simples ou por não atingir um padrão perfeito e desumano.",

            "Por que a construção e a capacidade de manter alta autoestima são tão importantes? \n" +
                    "Você terá mais estabilidade interna.\n" +
                    "Quando você gosta mais de si mesmo, quando sua opinião sobre si mesma aumenta, você para de tentar ansiosamente obter validação e atenção de outras pessoas.\n" +
                    "E assim você se torna menos carente e sua vida interior se torna muito menos uma montanha-russa emocional com base no que as pessoas podem pensar ou dizer sobre você hoje ou nesta semana.",

            "Por que a construção e a capacidade de manter alta autoestima são tão importantes? \n" +
                    "Menos autosabotagem.\n" +
                    "O pior inimigo da maioria das pessoas são elas mesmas. Ao aumentar e manter sua autoestima, você se sentirá mais merecedor de coisas boas da vida.\n" +
                    "E assim você os perseguirá com mais frequência e com mais motivação. E quando você os obtém, é muito menos provável que sucumba à dúvida ou à sabotagem de maneiras sutis ou não tão sutis.",

            "Por que a construção e a capacidade de manter alta autoestima são tão importantes? \n" +
                    "Você será mais atraente em qualquer relacionamento.\n" +
                    "Com uma melhor autoestima, você obterá os benefícios listados acima. Você estará mais estável e poderá lidar melhor com os tempos difíceis. Você será menos carente e mais doador natural.\n" +
                    "Estar com você se torna mais simples e uma experiência mais leve, com muito menos drama, argumentos ou brigas com base em pouco ou nada.\n" +
                    "E tudo isso é atraente em qualquer relacionamento, não importa se é com um amigo, no trabalho ou com um parceiro.",

            "Por que a construção e a capacidade de manter alta autoestima são tão importantes?\n" +
                    "Você ficará mais feliz.\n" +
                    "Essa tem sido a minha experiência e é por isso que escrevo muito sobre autoestima e por que valorizo muito a minha própria autoestima e tento mantê-la constante todos os dias.\n" +
                    "Porque isso fez minha vida muito mais feliz.",

            "Diga para seu crítico interno.\n" +
                    "Um bom lugar para começar a aumentar sua autoestima é aprender a lidar e substituir a voz de seu próprio crítico interno.\n" +
                    "Todos nós temos um crítico interno.\n" +
                    "Pode estimulá-lo a fazer as coisas ou a ganhar aceitação das pessoas em sua vida. Mas, ao mesmo tempo, isso reduzirá sua autoestima.\n" +
                    "Essa voz interior sussurra ou grita pensamentos destrutivos em sua mente.",

            "Use hábitos de motivação mais saudáveis.\n" +
                    "Para tornar o crítico interno menos útil para si mesmo e essa voz mais fraca e ao mesmo tempo motivar-se a agir e aumentar sua autoestima, certamente ajuda a ter hábitos saudáveis de motivação.",

            "Lembre-se dos benefícios.\n" +
                    "Uma maneira simples, porém poderosa, de motivar-se e manter essa motivação diária é anotar os benefícios profundamente sentidos que você terá ao seguir esse novo caminho ou alcançar uma meta.",

            "Concentre-se em fazer o que VOCÊ realmente gosta de fazer.\n" +
                    "Quando você realmente gosta de fazer alguma coisa, a motivação para fazer isso vem automaticamente.\n" +
                    "Quando você realmente deseja algo na vida, também fica mais fácil superar qualquer resistência interior que sentir.\n" +
                    "Portanto, se você perder sua motivação, pergunte-se:\n" +
                    "Estou fazendo o que realmente quero fazer?\n" +
                    "Se não e se possível, volte a focar e comece a trabalhar nessa coisa muito importante.\n" +
                    "Depois de usar sua palavra de parada ou frase, concentre-se em uma dessas técnicas. Sobre Quando isso se tornar um hábito, seu crítico interno aparecerá com muito menos frequência.",

            "Este é um hábito muito simples e divertido. E se você gastar apenas dois minutos todos os dias durante um mês, pode fazer uma enorme diferença.\n" +
                    "Respire fundo, diminua a velocidade e pergunte a si mesmo.\n" +
                    "Quais são as três coisas que posso apreciar sobre mim?\n" +
                    "Alguns exemplos que surgiram quando me acostumei a este exercício são:\n" +
                    "- Ajud algumas pessoas todos os dias no que escrevo.\n" +
                    "- Posso fazer as pessoas rirem e esquecerem seus problemas.\n" +
                    "- Sou muito atencioso e atencioso quando se trata de nossos gatos.",

            "Anote três coisas à noite que você pode apreciar sobre si mesmo.\n" +
                    "Essa é uma variação do hábito acima e a combinação dos dois pode ser extremamente poderosa para aumentar a autoestima por dia.\n" +
                    "Ou você pode simplesmente preferir usar essa variação no final do dia, quando tiver tempo livre para gastar.\n" +
                    "O que você faz é se fazer a pergunta da última seção:\n" +
                    "Quais são as três coisas que posso apreciar sobre mim?\n" +
                    "Anote suas respostas todas as noites em um diário feito de papel ou no seu computador / smartphone.\n" +
                    "Um bom benefício extra de anotá-lo é que, depois de algumas semanas, você pode ler todas as respostas para se manter positivo, obter um bom impulso na autoestima e mudar de perspectiva nos dias em que você mais precisa.",

            "Faça a coisa certa.\n" +
                    "Quando você faz o que acha, no fundo, a coisa certa a fazer, aumenta e fortalece sua autoestima.\n" +
                    "Pode ser uma coisa pequena como se levantar do sofá e ir à academia. Poderia ser entender em vez de julgar uma situação.\n" +
                    "Ou para parar de se preocupar ou sentir pena de si mesmo e se concentrar nas oportunidades e na gratidão pelo que você realmente tem.\n" +
                    "Nem sempre é fácil de fazer. Ou mesmo para saber qual é a coisa certa.\n" +
                    "Mas manter o foco e fazê-lo da melhor maneira possível faz grande diferença, tanto nos resultados que obtém quanto na maneira como pensa sobre si mesmo.\n" +
                    "Uma dica que facilita ficar consistente ao fazer a coisa certa é tentar executar algumas dessas ações no início do dia. Por exemplo, elogiar alguém, tomar um café da manhã saudável e malhar.",

            "Substitua o perfeccionismo.\n" +
                    "Poucos hábitos de pensamento podem ser tão destrutivos na vida cotidiana quanto o perfeccionismo.\n" +
                    "Isso pode impedi-lo de agir, porque você fica com tanto medo de não seguir um padrão. E assim você procrastina e não obtém os resultados desejados. Isso fará com que sua autoestima afunda."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_two_list);
        list=(ListView)findViewById(R.id.list);
        DetailListAdapter adapter=new DetailListAdapter(this, itemname, "2");
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // TODO Auto-generated method stub
//                String Selecteditem = itemname[+position];
//                Log.d("Position", Selecteditem);
//                Intent intent = new Intent(TwoListActivity.this, TwoDetailList.class);
//                startActivity(intent);

            }
        });
    }
}
