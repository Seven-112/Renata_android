package com.renata.mentesaudvel.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.renata.mentesaudvel.Adapter.DetailListAdapter;
import com.renata.mentesaudvel.DetailList.FourDetailList;
import com.renata.mentesaudvel.DetailList.ThreeDetailList;
import com.renata.mentesaudvel.R;

public class FourListActivity extends AppCompatActivity {
    ListView list;
    String[] itemname ={
            "As finanças pessoais geralmente podem ser uma frase temida, fazendo com que as pessoas evitem o planejamento - o que, por sua vez, pode levar a más decisões e maus resultados no caminho.\n"+
                    "Reserve um tempo para orçar sua receita versus despesas e, em seguida, entenda como gastar dentro do seu meio e gerenciar as expectativas de estilo de vida.\n"+
                    "Além do planejamento para o futuro, comece a arrecadar dinheiro hoje para metas de economia, incluindo aposentadoria, lazer e propósitos de emergência.\n"+
                    "Comece criando o hábito de olhar para seu extrato com frequência, identificando exatamente quanto entra e quanto sai, para chegar no ponto crucial das finanças pessoais: gastar menos do que você ganha.",

            "Gaste Menos Do Que Você Ganha\n"+
                    "É básico, mas muita gente não consegue. Pior ainda; o desconhecimento das finanças pessoais é tão grande que, acredite, existe quem pense que gasta menos, quando na verdade gasta mais. Como isso é possível? Mecanismos de crédito, com parcelamentos supostamente sem juros, que \"criam sensação de poder de compra\", sem que de fato haja.\n"+
                    "Porém, o acúmulo de parcelas e juros, em algum momento, trará a realidade à tona, de modo que será muito difícil reverter a situação. E toda essa problemática converge, novamente, para um mesmo ponto: falta de conhecimento e de interesse por finanças pessoais.\n"+
                    "A partir do momento em que se adquire o conhecimento básico, de modo que suas finanças pessoais sejam parte integrante de sua rotina, fica muito mais simples a tarefa de gastar menos do que se ganha e, por consequência, investir essa diferença.",

            "Monitore Os Gastos (Como Controlar Suas Finanças)\n"+
                    "Falamos de \"gastar menos do que se ganha\", não é? Mas de muitas maneiras alcançar isso passa pelo controle de seus gastos. E, como você não pode controlar o que não vê, é fundamental em finanças pessoais que passe a anotar cada despesa que realiza.\n"+
                    "Nesse instante, pouco importa se fará isso através de um aplicativo, uma planilha ou usando um caderno.\n"+
                    "O importante é que faça, para que conheça exatamente como está gastando seu dinheiro, possa identificar possíveis desperdícios e tenha suas finanças pessoais sob controle.\n"+
                    "E ao identificá-los (os desperdícios), corte sem dó. Assim, você vai aprender como controlar suas finanças.\n"+
                    "IMPORTANTE: Não existe nenhum gasto que não possa ser revisto, nem mesmo moradia. Fundamental mesmo é ter as contas em dia, poder investir, para viver melhor. Esse é o papel fundamental do bom cuidado com as finanças pessoais.\n"+
                    "Ao passar a monitorar suas finanças pessoais, você perceberá em pouco tempo uma mudança significativa em seus hábitos e, por consequência, verá os frutos desse esforço em forma de poupança e investimentos.",

            "Reconheça necessidades versus desejos - e gaste com atenção\n"+
                    "A menos que você tenha uma quantia ilimitada de dinheiro, é de seu interesse estar atento à diferença entre necessidades e desejos, para que você possa fazer melhores escolhas de gastos. “Necessidades” são coisas que você precisa ter para sobreviver: comida, abrigo, assistência médica, transporte, uma quantidade razoável de roupas (muitas pessoas incluem economia conforme a necessidade, seja 10% da renda ou o que puderem pagar) reservar todos os meses). Por outro lado, \"desejos\" são coisas que você gostaria de ter, mas que não precisa de sobrevivência.\n"+
                    "Pode ser desafiador rotular com precisão as despesas conforme suas necessidades ou desejos e, para muitos, a linha fica embaçada entre os dois. Quando isso acontece, pode ser fácil racionalizar uma compra desnecessária ou extravagante, chamando-a de necessidade. Um carro é um bom exemplo. Você precisa de um carro para trabalhar e levar as crianças para a escola. Você quer o SUV edição de luxo que custa o dobro de um carro mais prático (e custa mais em gasolina). Você pode tentar chamar o SUV de \"necessidade\" porque, de fato, precisa de um carro, mas ainda é um desejo. Qualquer diferença de preço entre um veículo mais econômico e o SUV de luxo é dinheiro que você não precisou gastar.\n"+
                    "\n"+
                    "Suas necessidades devem ter prioridade máxima no seu orçamento pessoal. Somente depois que suas necessidades forem atendidas você deverá alocar uma renda discricionária para desejos. E, novamente, se você tiver dinheiro sobrando a cada semana ou a cada mês após pagar pelo que realmente precisa, não precisará gastar tudo.\n",

            "Como Montar Uma Aposentadoria De Sucesso\n"+
                    "Para montar uma aposentadoria de sucesso, antes de mais nada é preciso disciplina e ater-se ao básico: controlar seus gastos de forma que gaste menos do que ganha.\n"+
                    "Feito isso, é hora de pensar no prazo em que pretende se aposentar e quanto seria o suficiente. Uma vez feito isso, é hora de procurar quais investimentos vão te levar até os objetivos pretendidos e definir que montante mensal terá de ser investido para isso.\n"+
                    "É importante lembrar-se de todo ano aumentar o valor das aplicações para compensar a inflação.\n"+
                    "Finanças pessoais é isso: objetivos, prazos, metas e, baseada nisso, a escolha dos investimentos que o ajudarão a alcançá-los. Jamais se esqueça que, ao longo do tempo, correções e mudanças terão de ser feitas, uma vez que a economia está em constante movimento. Mais uma vez: conte conosco para que suas finanças pessoais o levem para uma aposentadoria vencedora.",

            "Transforme Sua Vida Financeira Com a Regra Dos 50-15-35\n"+
                    "Você já ouviu falar dessa regra? Bem, ela é bastante simples. Consiste em aplicar uma métrica na ideia que repetimos sempre: objetivos e metas.\n"+
                    "O conceito é simples: dividir seu orçamento em três percentuais para onde sua renda deverá ser direcionada (ou 3 limites para seus gastos). 50% para gastos essenciais, 15% para prioridades financeiras e 35% para estilo de vida. Isso significa dizer que, tudo o que é básico e fundamental, não deverá superar 50% do seu orçamento: moradia, contas de consumo, educação e assim por diante.\n"+
                    "Em seguida, as prioridades financeiras devem se limitar a 15% do seu orçamento. Se você está endividado, essa é a parcela que deverá ser canalizada para o pagamento desses compromissos.\n"+
                    "Do contrário, esse percentual deve ser destinado à poupança e construção de patrimônio.\n"+
                    "Seguindo os dois parâmetros anteriores, você conseguirá 35% do seu orçamento para gastar com coisas que gosta e trazem sentido para sua vida: passeios, hobbies, restaurantes e tudo mais que te define e te motiva.\n"+
                    "Sem essas coisas, as finanças pessoais ficam comprometidas, pois a vida perde, literalmente, a graça.\n"+
                    "Cuidado, portanto, em rotular como \"supérfluo\" exatamente as coisas que lhe trazem alegria.",

            "Faça um planejamento financeiro pessoal\n"+
                    "Muita gente pensa que o Planejamento Financeiro Pessoal é um bicho de sete cabeças. Mas não é. Aliás, o grande segredo é ser simples e funcional. A base de qualquer planejamento é simplesmente definir prazos e metas. Em resumo: é saber o que se quer, quando se quer, para poder planejar como vai chegar lá. ",

            "Monte uma planilha de gastos mensais\n"+
                    "Finanças pessoais não são nada sem controle. E como você não controla o que não vê, que tal começar a fazer sua planilha de gastos mensais? Melhor ainda; existem muitas planilhas prontas para você começar agora mesmo.",

            "Aprenda contabilidade com os ricos\n"+
                    "Ricos não são ricos à toa. Uma das principais coisas que os diferencia das demais pessoas do mundo é a atenção incrível que dão às suas finanças pessoais. E como conhecimento significa poder, sabem o suficiente de cada aspecto que envolve seu dinheiro.\n"+
                    "E um dos aspectos mais importantes, ignorado pela maioria das pessoas que não conseguem enriquecer, é a \"contabilidade\". É preciso entender os fundamentos contábeis para poder contratar um bom contador e evitar, assim, perder dinheiro.\n"+
                    "Não estamos falando de nada ilegal, muito pelo contrário. As pessoas ricas conhecem a contabilidade de forma a evitar tributos e impostos desnecessários, dinheiro esse que em suas mãos, só faz crescer seu patrimônio.\n"+
                    "Note que, toda vez que ler uma biografia de um milionário, parte de seus segredos sempre passará por uma contabilidade impecável e conhecimento tributário. O segredo de quem tem: jamais perder dinheiro quando isso puder ser evitado.",

            "Utilize a tecnologia a seu favor\n"+
                    "Achou a planilha financeira trabalhosa demais? Ainda bem que existem empresas desenvolvendo aplicativos financeiros para facilitar a sua vida. Os apps de controle financeiro são os melhores amigos de suas finanças pessoais.\n"+
                    "A grande vantagem, além da simplicidade no uso, é a mobilidade. Como a maioria tem a versão para smartphone, você poderá lançar suas despesas no ato, sem esperar chegar em casa, correndo o risco de esquecer.\n"+
                    "Há ainda aplicativos que se conectam às suas contas correntes, realizando os lançamentos de forma automática. A você caberá apenas criar categorias para cada despesa, como \"moradia\", \"transporte\", \"educação\", para citar alguns exemplos e definir metas (ou limites) para seus gastos.\n"+
                    "Fantástico, não é? Agora você não tem mais desculpa para deixar seu controle financeiro de lado.",

            "Poupe parte do seu dinheiro e invista (mesmo ganhando pouco)\n"+
                    "Ganhar pouco não é desculpa para não poupar. Lembra-se da regra dos 50-15-35? Ela cabe em qualquer orçamento.\n"+
                    "O grande segredo das finanças pessoais não é ficar tentando adaptar seus ganhos à sua vida, mas adaptar sua vida aos seus ganhos.\n"+
                    "Esforce-se, assim, para conseguir separar 15% do que ganha para poupar e, por consequência, investir. Esqueça esse dinheiro e condicione-se a viver com os 85% restantes e adapte sua vida a eles.\n"+
                    "Assim, com disciplina e paciência, você verá seu patrimônio crescer. E, a partir desse ponto, utilize-se de tudo o que a Rico te oferece para escolher os melhores investimentos: seu dinheiro crescerá mais rápido e você atingirá seus objetivos.\n",

            "Aprenda Como Economizar Dinheiro\n"+
                    "A economia de dinheiro é parte importante das finanças pessoais, por isso, falamos tanto sobre esse assunto. E, por mais óbvio que pareça, economizar vem de cortar desperdícios; tão simples quanto isso.\n"+
                    "E, após começar a fazer o controle dos seus gastos, ficará muito fácil identificá-los. De forma resumida: desperdício de dinheiro é tudo aquilo que você paga mas não usa, ou, o gasto para o qual (caso use) haveria opção mais barata.\n"+
                    "Alguns exemplos práticos:\n"+
                    "•\tTV por assinatura: se você não usa, cancele\n"+
                    "•\tTelefonia: veja se seus planos estão adequados ao seu consumo. Sempre é possível gastar menos.\n"+
                    "•\tAssinaturas em geral: o brasileiro é conhecido por assinar um monte de coisas e não cancelar. Seja o serviço de streaming de música ou aquela revista que nunca lê, cancele tudo e só pague aquilo que efetivamente usa.\n"+
                    "Seja a academia que não vai, ou um carro que fica na garagem e não usa, só cortando os desperdícios você poderá poupar e ver seu patrimônio crescer.\n",

            "Aprenda e ensine sua família sobre finanças pessoais\n"+
                    "Quando vivemos em família é fundamental que todos se engajem em torno dos objetivos comuns da casa. E com finanças pessoais não é diferente: se todos estiverem em sintonia, os resultados serão muito melhores\n"+
                    "Por isso, é importante criar uma dinâmica familiar, com um momento para que os assuntos finanças pessoais e finanças familiares sejam abordados. Defina um dia do mês, crie um ritual e assuma esse compromisso.\n"+
                    "É importante que seja um momento sério, mas gostoso. E que, ao longo do tempo, todos possam comemorar juntos as conquistas e encarar os desafios.\n"+
                    "É claro que, se tiver filhos muito pequenos, é preciso esperar que tenham idade e discernimento para participar desse momento.\n"+
                    "Sempre haverá algo a ensinar e a aprender. Estimule todos a fazerem pesquisas e trazer assuntos novos a cada encontro sobre finanças pessoais. Logo perceberá os benefícios do aprendizado conjunto, bem com a determinação em construir um futuro sólido de forma participativa.\n",

            "Aposente o cartão de crédito\n"+
                    "Embora o cartão de crédito não seja inimigo de ninguém (pelo contrário, o único inimigo, do ponto de vista financeiro que temos, somos nós mesmos), não podemos negar que é uma ferramenta que pode levar a problemas financeiros.\n"+
                    "Existe uma \"armadilha psicológica\" no uso do cartão que é o fato de você \"não ver\" o dinheiro sendo gasto de fato. Isso causa uma falsa sensação de \"não ter gasto\", sobretudo quando há saldo positivo na conta corrente (esquecendo que você já gastou aquele dinheiro no cartão).\n"+
                    "Quando você passa a usar \"dinheiro vivo\" ou mesmo \"cartão de débito\", você estará utilizando de uma ferramenta poderosa das finanças pessoais que, acredite, inibe o consumo por impulso e, pela \"dificuldade\" de ver o dinheiro indo embora, fará com que você gaste menos.\n",

            "Não escute o gerente do seu banco\n"+
                    "Como já falamos antes, bancos não estão interessados em nada além do próprio lucro. E o gerente, como funcionário do banco, por mais que fale o contrário, atende os interesses da instituição e não do cliente.\n"+
                    "Desse modo, ele te oferecerá uma série de produtos cujo único beneficiado é o banco, como por exemplo, títulos de capitalização, que é um produto que possui rendimento praticamente zero, com a promessa de sortear prêmios.\n"+
                    "Em finanças pessoais, títulos como esse são o suicídio financeiro. Esse foi apenas um dos muitos exemplos que podem ser dados. Por isso, seja o que seu gerente lhe oferecer, nos procure, que poderemos te oferecer algo muito melhor.\n",

            "Construir e manter um fundo de emergência\n"+
                    "Um fundo de emergência é exatamente o que o nome indica: dinheiro que foi reservado para fins de emergência. O fundo tem como objetivo ajudá-lo a pagar por coisas que normalmente não seriam incluídas em seu orçamento pessoal: despesas inesperadas, como reparos de automóveis ou uma visita de emergência ao dentista. Também pode ajudá-lo a pagar suas despesas regulares se sua renda for interrompida; por exemplo, se uma doença ou lesão o impedir de trabalhar ou se você perder o emprego.\n"+
                    "Embora a diretriz tradicional seja economizar três a seis meses de despesas de subsistência em um fundo de emergência, a triste realidade é que esse valor ficaria aquém do que muitas pessoas precisariam para cobrir uma grande despesa ou sofrer uma perda de renda. No ambiente econômico incerto de hoje, a maioria das pessoas deve ter como objetivo economizar pelo menos seis meses em gastos com moradia - mais se possível. Colocar isso como um item de despesa regular em seu orçamento pessoal é a melhor maneira de garantir que você economize para emergências e não gaste esse dinheiro de maneira frívola.\n"+
                    "Lembre-se de que estabelecer um backup de emergência é uma missão contínua (consulte Construindo um fundo de emergência): as probabilidades são de que, assim que for financiado, você precisará disso para obter alguma coisa. Em vez de ficar desanimado com isso, fique satisfeito por estar preparado financeiramente e inicie o processo de construção do fundo novamente.\n"+
                    "Conclusão\n"+
                    "Embora Finanças Pessoais seja uma disciplina ampla, no final, alguns pontos fundamentais convergem para as boas práticas, que levam à construção de riqueza e à sua tranquilidade e da sua família.\n"+
                    "Desde começar a controlar suas despesas, cortar desperdícios, gastar menos do que ganha e poupar, até o ponto de começar a investir, todas essas atitudes simples dentro das finanças pessoais, levam à tão sonhada \"independência financeira\".\n"+
                    "E mesmo sendo simples, saiba que, apenas uma pequena parcela da população se esforça para colocá-las em prática e, por isso, tão poucas pessoas tem suas finanças pessoais em ordem.\n"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_four_list);
        list=(ListView)findViewById(R.id.list);
        DetailListAdapter adapter=new DetailListAdapter(this, itemname, "4");
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // TODO Auto-generated method stub
//                String Selecteditem = itemname[+position];
//                Log.d("Position", Selecteditem);
//                Intent intent = new Intent(FourListActivity.this, FourDetailList.class);
//                startActivity(intent);

            }
        });
    }
}