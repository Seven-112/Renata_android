package com.renata.mentesaudvel.DetailList;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.renata.mentesaudvel.DetailAdapter.FiveListAdapter;
import com.renata.mentesaudvel.DetailAdapter.SixListAdapter;
import com.renata.mentesaudvel.R;

public class SixDetailList extends AppCompatActivity {
    private FirebaseAuth auth;//TODO; firebase
    private DatabaseReference mDatabase; //TODO; database reference
    String[] itemname ={
            "Não é pecado ser pão-duro quando você não tem dinheiro para gastar. É melhor do que ser mão-aberta e ficar cheio de dívidas para pagar.\n" +
                    "Corte a TV a cabo e avalie o plano de celular\n" +
                    "Quando as contas estão fora de controle, o melhor é cortar gastos não essenciais. \n" +
                    "Passe um ano sem comprar roupas novas\n" +
                    "ro.",
            "Esse é um exercício difícil, mas muito importante para tomar o controle das contas. Você pode buscar alternativas, como trocas com amigas ou mesmo participar de desafios de uma peça e vários looks.\n" +
                    "Busque alternativas de moda baratas\n" +
                    "Em vez de comprar sapatos novos, vá ao sapateiro da esquina. Tire do baú aqueles modelitos que você aposentou na última estação. Com acessórios diferentes, vai parecer que é uma roupa nova.",
            "O melhor é fugir das tentações. Os apelos para o gasto e consumismo estão em todas as partes. É preciso ser forte para resistir. Então, uma dica para controlar as finanças é dar um tempo dos passeios no shopping nos finais de semana.\n" +
                    "Tenha apenas um cartão de crédito\n" +
                    "Se for preciso, corte ou cancele os outros. Ter muitos cartões é um caminho muito fácil para o descontrole com as contas. Mesmo com as novas regras do cartão, ele ainda está entre os juros mais caros do mercado. Uma sugestão é só levar o cartão quando você tiver uma compra realmente necessária e que caiba no orçamento.",
            "Troque as mais caras (cheque especial e rotativo do cartão de crédito) pelas mais baratas (empréstimo consignado e crédito pessoal). Com o corte nas despesas, você terá dinheiro para quitar seus débitos e limpar seu nome.\n" +
                    "Antes de pedir crédito avalie os juros\n" +
                    "Entenda como algumas dívidas crescem tão rápido. Ao sair do cheque especial e da dívida no cartão de crédito, confirme se os juros e as condições são favoráveis, se cabem no seu orçamento.",
            "Há várias opções de crédito no mercado, mas é preciso pesquisar de forma criteriosa, para não fechar negócio sem pensar. Compare as taxas de juros e as condições de pagamento – quantidade e valor das parcelas.",
            "Uma alternativa para não deixar de consumir é mudar alguns hábitos. Por exemplo, é possível comprar bens usados em bom estado por um preço mais em conta. Há vários aplicativos em que você pode buscar livros, eletrodomésticos e móveis de segunda-mão.",
            "Com essas dicas, você vai controlar as finanças e ficar no azul. E, depois de quitar as dívidas, você vai ver como será mais fácil programar a compra de um bem maior, como um carro ou uma casa.\n" +
                    "Acompanhe\n" +
                    "Comece acompanhando quanto você ganha em comparação a quanto você gasta. Para isso, se apoie em uma planilha para controle de gastos. Dessa forma, você poderá avaliar para onde vai aquela parte do dinheiro que sempre parece que “sumiu”.",
            "Em geral, nunca compre no primeiro lugar que você achar um produto. Com as facilidades que a internet oferece, deixar de comparar os preços é praticamente um pecado, especialmente porque você pode adotar esse simples hábito de controlar as finanças pessoais sem sair de casa.\n" +
                    "Não confie em contas feitas de cabeça\n" +
                    "Fazer o planejamento financeiro baseado em contas rápidas e feitas de cabeça pode ser muito prejudicial para as finanças pessoais. Isso porque, ao fazer isso, a maioria das pessoas esquece de considerar os descontos nos salários, juros e compras parceladas.",
            "Alguns serviços — como assinaturas de revistas, tarifas bancárias altas, planos de academias ou televisão a cabo — não são usufruídos como deveriam. Neste caso, você já sabe o que fazer: aposte no cancelamento.\n" +
                    "Reavalie seus gastos básicos\n" +
                    "Sempre dá para economizar um pouquinho a mais com as contas de água, energia elétrica e até mesmo com os planos de internet.",
            "O que você precisa mais: um sofá novo (sendo que você já tem um) ou uma nova geladeira (quando a sua está prestes a estragar)? Avalie sempre as necessidades e os desejos antes de realizar uma grande compra.\n" +
                    "Evite grandes prestações\n" +
                    "Mesmo que comprar em 10x, 12x ou 24x pareça muito atrativo no imediatismo, saiba que você poderá se arrepender depois de pouquíssimos meses. Sendo assim, evite ao máximo os parcelamentos.",
            "Despesas com IPTU, IPVA, DPVAT e outras são totalmente previsíveis. Mesmo assim, muitas pessoas ainda as deixam para a última hora. Evitar que isso aconteça é uma grande atitude em nome de suas finanças pessoais.",
            "Esteja no controle sem abrir mão do seu estilo de vidaSe você adora ir para a academia, participar do happy hour com os amigos ou ver as estreias no cinema, tudo bem: não precisa abrir mão do seu estilo de vida. Porém, tentar maneirar um pouco no número de vezes que você faz isso ao longo do mês pode ser uma ótima forma de economizar.\n" +
                    "Faça o download do aplicativo do seu banco\n" +
                    "Com o aplicativo do seu banco sempre à mão, ficará muito mais fácil conferir o seu saldo e seus extratos, de modo a evitar grandes sustos no controle das finanças.",
            "Na hora de poupar dinheiro, não escolha a tradicional poupança antes de pesquisar por outras opções que podem ser mais vantajosas. Existem diversos outros tipos de investimento que podem ser mais interessantes para você: pesquise!\n" +
                    "Transforme o controle de finanças em um hábito\n" +
                    "Se você teve gastos com a família no final de semana, anote. Se teve gastos fixos, anote também. Faça do controle um hábito.\n" +
                    "Antes de dizer algo desagradável ou fazer uma grande compra, reserve um momento e se acalme primei"

    };
    String[] titlename ={
            "Pratique a avareza",
            "",
            "Passe longe do shopping",
            "Renegocie as suas dívidas",
            "Pesquise os empréstimos disponíveis",
            "Mude alguns hábitos de consumo",
            "",
            "Compare preços",
            "Atenção às despesas com serviços não utilizados",
            "Compare necessidades e desejos",
            "Preveja as despesas anuais",
            "",
            "Conheça os principais investimentos financeiros"

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

        SixListAdapter adapter=new SixListAdapter(this, itemname, titlename);
        recyclerView.setAdapter(adapter);
    }
}

