package com.renata.mentesaudvel.List;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import com.renata.mentesaudvel.Adapter.DetailListAdapter;
import com.renata.mentesaudvel.R;

public class NineListActivity extends AppCompatActivity {
    ListView list;
    String[] itemname = {
            "Use psicologia reversa\n"+
                    "Em vez de se preocupar com o fato de não estar dormindo, tente se forçar a ficar acordado. Um estudo da Universidade de Glasgow descobriu que deitar na cama e tentar ficar acordado com os olhos abertos resulta em você adormecer mais rapidamente, graças ao poder da psicologia reversa.",

            "Levante-se em vez de ficar deitado lá\n"+
                    "Se você não consegue dormir, é importante que não fique deitado na cama - é provável que fique mais estressado por estar acordado, o que não é muito útil quando você está tentando dormir. Em vez disso, levante-se e faça algo que exija suas mãos e cabeça, como um quebra-cabeça, livro para colorir ou reorganizar seu guarda-roupa. Então, quando estiver com sono, volte para a cama.",

            "Evite a luz azul\n"+
                    "A melatonina é seu hormônio indutor do sono, e a luz azul suprime a produção do seu corpo. A luz azul pode ser encontrada em muitos itens digitais, como sua TV, telefone, computador ou tablet. Evite 2-3 horas antes de dormir, para não interromper a produção de melatonina do seu corpo.\n"+
                    "Se você não pode evitar telas digitais (ou não pode desistir de sua maratona noturna da Netflix), tente diminuir o brilho da tela ou usar aplicativos para reduzir a quantidade de luz azul que sua tela está produzindo. vivemos à luz do dia - acordamos quando o sol nasceu e dormimos quando o sol se pôs. É no que os relógios biológicos de nossos corpos (ou ritmos circadianos) são construídos. A luz artificial brilhante à noite joga nossos corpos fora de controle, e o maior infrator é a luz azul. Ele não vem apenas de eletrônicos, também pode ser de lâmpadas fluorescentes e luzes LED. Quando o sol se põe, apague as luzes artificiais e aproveite a luz de velas. Pense nisso como uma ótima oportunidade para ouvir música ou acompanhar podcasts.",

            "Remova o seu relógio\n"+
                    "Para adormecer rápida e facilmente, você precisa se sentir calmo e relaxado. Assistir o relógio - e os minutos passando mostrando que você ainda está acordado - aumenta seu nível de estresse. Ao remover o relógio do seu quarto, você está removendo uma fonte de estresse, ajudando a pavimentar o caminho para uma melhor noite de sono.",

            "Mantenha seu quarto fresco\n"+
                    "Embora possa parecer que uma sala quente faça você se sentir confortável e sonolento, uma sala um pouco mais fria pode realmente ser mais benéfica para ajudá-lo a adormecer. Isso ocorre porque, quando você adormece, a temperatura do seu corpo cai um pouco, o que alguns especialistas acham que pode ajudar a acelerar o processo de adormecer.",

            "Inicie uma rotina de dormir\n"+
                    "Bebês e crianças pequenas prosperam na rotina, e você também pode. Ao iniciar e seguir uma rotina de dormir, ajudará seu corpo a entender que é hora de dormir. Escolha o que funciona melhor para você - seja uma xícara de chá com sono, seguida de uma breve sessão de meditação ou simplesmente lavando o rosto e colocando o pijama. Apenas certifique-se de manter o mesmo horário e rotina todas as noites para obter os melhores resultados.",

            "Tome um banho quente antes de dormir\n"+
                    "Não é apenas um banho ou ducha quente uma experiência relaxante, o aquecimento do corpo e a entrada em um ar mais fresco ajudará a temperatura do corpo a cair rapidamente. Essa queda é uma das dicas do seu cérebro para deixá-lo sonolento, resultando em uma diminuição da frequência cardíaca, pressão arterial, respiração e digestão. Tente cerca de uma hora antes de dormir, tomar um banho curtos (5 a 15 minutos).",

            "Mergulhe seu rosto em água gelada\n"+
                    "Pode não parecer muito tranquilo, mas mergulhar o rosto em uma tigela de água fria é uma boa maneira de restaurar o sistema nervoso e ajudá-lo a se acalmar antes de dormir. Ao colocar seu rosto em água fria, você desencadeará um fenômeno involuntário chamado Reflexo de Mergulho com Mamíferos - a resposta embutida de nossos corpos à água. Isso reduzirá imediatamente sua freqüência cardíaca e pressão arterial para acalmar seu sistema nervoso, ajudando você a entrar em um estado mais tranqüilo.",

            "Experimente a técnica de respiração 4-7-8\n"+
                    "A respiração 4-7-8 ajudará você a adormecer em menos de um minuto. Isso ocorre para relaxar você, aumentando o oxigênio na corrente sanguínea, enquanto diminui a frequência cardíaca e libera dióxido de carbono dos pulmões. Experimente você mesmo: inspire por 4 segundos. Prenda a respiração por 7 segundos. Expire vigorosamente por 8 segundos. Repita 3 vezes",

            "Use lavanda\n"+
                    "Não só tem um cheiro agradável, a lavanda é conhecida por suas propriedades indutoras de relaxamento. Você pode usar óleo essencial de lavanda em um difusor para perfumar seu quarto, colocá-lo em seu travesseiro, cheirar, usá-lo em um óleo de massagem.",

            "Use a visualização\n"+
                    "Visualizar um lugar em sua cabeça que faça você se sentir calmo e feliz, como uma praia ou cachoeira, pode ajudar a distraí-lo de pensamentos e preocupações, facilitando a maneira de dormir. Um estudo da Universidade de Oxford confirma isso. Ele descobriu que as pessoas que foram convidadas a imaginar uma cena relaxante adormeceram 20 minutos mais rápido do que as que foram instruídas a contar ovelhas ou não fazerem nada.",

            "ouça música\n"+
                    "A música pode ajudar você a dormir, especialmente se você ouvir música clássica ou qualquer música que tenha um ritmo lento de 60 a 80 batimentos por minuto.",

            "Sopre algumas bolhas\n"+
                    "Pegue uma garrafa de bolhas e sopre - ele pode acalmar seu corpo e sua mente. A observação de bolhas é hipnótica e requer respiração profunda, o que pode relaxar seu sistema nervoso e prepará-lo para uma boa noite de sono.",

            "Priorize o exercício à noite\n"+
                    "Um treino intenso 90 minutos antes de dormir pode reduzir seus níveis do hormônio do estresse cortisol, ajudando você a adormecer mais rapidamente. Além disso, ele pode ajudá-lo a se sentir mais cansado e com menos fome da noite para o dia (um conhecido ladrão de sono).",

            "Escreva\n"+
                    "Enquanto seu cérebro tenta processar pensamentos estressantes, ele não pode desligar, impedindo que você durma. Uma das melhores maneiras de lidar com esses pensamentos é liberá-los, anotando-os. O ato de escrever seus pensamentos e preocupações ajuda você a se sentir mais no controle, o que significa que seu cérebro pode finalmente relaxar e permitir que você se divirta.",

            "Experimente os exercícios de relaxamento\n"+
                    "Os exercícios de relaxamento são simples de dominar e são uma boa maneira de acalmar sua mente e liberar qualquer tensão em seu corpo antes de dormir. Tente este exercício de exame corporal: deite-se na cama com os olhos fechados. Concentre-se nas sensações de cada parte do corpo, começando pelos dedos dos pés e subindo a partir daí. Você pode até adormecer antes de alcançar sua cabeça ...",

            "Aplique um pouco de acupressão\n"+
                    "A acupressão pode ajudá-lo a adormecer mais rápido por mais tempo e também desfrutar de uma noite de melhor qualidade. As técnicas que você pode tentar incluem aplicar uma leve pressão por um minuto a uma pequena depressão no nível das sobrancelhas, entre as sobrancelhas ou massagear os dois ouvidos por um minuto. Você também pode investir em um tapete de indução do sono que usa pontos de acupuntura para relaxar você.",

            "Programe seu sono\n"+
                    "Ajude seu relógio interno a manter uma programação regular, acordando e indo dormir na mesma hora todos os dias (inclusive nos fins de semana). Depois que seu corpo se ajustar, será mais fácil adormecer (e acordar) na mesma hora todos os dias.",

            "Tire um tempo para relaxar\n"+
                    "Pular direto para a cama do que você estiver fazendo não ajudará seu corpo a desacelerar para dormir. Você precisa preparar seu corpo para dormir, permitindo que ele desanuvie e relaxe lentamente. 30 a 60 minutos antes de dormir, dedique tempo ao relaxamento - de preferência atividades que não usam luz azul. Pense lendo, fazendo um quebra-cabeça, ouvindo música ou dando um passeio tranquilo pelo quarteirão.",

            "Aproveite o sol durante o dia\n"+
                    "Nossos ritmos circadianos (nosso sistema corporal incorporado que nos diz quando dormir e quando acordar) podem ser interrompidos pela exposição irregular à luz, dificultando o adormecimento e a permanência. Ao sair para a luz natural durante o dia, ajudará a manter seu corpo acordado. Então, quando a luz natural desaparecer à noite, seu corpo saberá que é hora de dormir.",

            "Deixe seu quarto muito escuro\n"+
                    "À noite, a escuridão promove sentimentos de sonolência. A pesquisa confirma isso, mostrando que a escuridão aumenta a produção de melatonina, um hormônio essencial para o sono. Para criar o ambiente ideal para dormir, use cortinas ou persianas opacas ou invista em uma boa máscara ocular.",

            "Experimente o yoga\n"+
                    "Os benefícios do yoga para a nossa saúde e bem-estar (mental e físico) são bem conhecidos. Mas você sabia que o yoga também pode ajudar a consertar aquelas noites sem dormir? Isso ocorre porque o yoga faz você se concentrar na respiração e a respiração profunda é um dos gatilhos do sono do seu corpo. Também envolve movimentos que liberam estresse e tensão em seu corpo, deixando-o relaxado e pronto para dormir. Tente alongar com as luzes apagadas para obter o efeito máximo.",

            "Meditar\n"+
                    "A meditação pode aumentar seus níveis de melatonina, ajudando seu cérebro a alcançar um estado em que o sono é facilmente alcançado. Graças à sua capacidade de acalmar uma mente ocupada, a meditação pode ajudar a relaxar o corpo e melhorar o sono.",

            "Abrace a atenção plena\n"+
                    "Tentar a atenção plena pode ajudá-lo a dormir melhor. Isso ocorre porque a atenção nos ensina a focar no presente e a nos preocupar menos, o que significa menos pensamentos correndo em sua cabeça e uma mente mais calma, preparada para desligar e dormir.",

            "Desista da soneca diária\n"+
                    "É um ciclo vicioso: você não consegue dormir à noite, fica com sono durante o dia e tira uma soneca - o que significa que não pode dormir à noite. Para interromper o ciclo, tente eliminar cochilos ou limitar-se a uma soneca curta (30 minutos ou menos) no início do dia.",

            "Hora de comer\n"+
                    "Refeições com alto teor de carboidratos podem afetar sua capacidade de dormir porque levam mais tempo para digerir. Se você não pode desistir de carboidratos na hora do jantar, certifique-se de comê-los pelo menos 4 horas antes de ir para a cama. ",

            "Estocar alimentos indutores do sono\n"+
                    "Uma dieta equilibrada, cheia de frutas frescas, vegetais e proteínas magras, como peixe e carne, é ótima para um corpo e uma mente saudáveis - e um corpo que funcione naturalmente produz melatonina, nosso hormônio indutor do sono. Mas há outros alimentos que você pode experimentar que ajudarão a aumentar a produção de melatonina, incluindo alimentos ricos em ácidos graxos ômega-3.",

            "Tome café da manhã\n"+
                    "O triptofano é um aminoácido essencial que é transformado em serotonina no cérebro antes de ser convertido em melatonina. A transformação do triptofano em melatonina é mais alta na luz do que na escuridão. Portanto, para maximizar a produção de melatonina e ajudá-lo a dormir melhor à noite, faz sentido combinar o triptofano com muita luz natural - em outras palavras, coma alimentos ricos em triptofano no café da manhã.\n"+
                    "Tente incorporar leite, queijo, ovos, carne, farelo de aveia, nozes e sementes no café da manhã, todas elas são ótimas fontes de triptofano.",

            "Considere um colchão mais confortável\n"+
                    "Um colchão flácido e desgastado,  provavelmente será bastante desconfortável, e esse desconforto provavelmente o impedirá de cair pacificamente na hora de dormir.",

            "Invista em um bom travesseiro \n"+
                    "Um travesseiro de boa qualidade é crucial para uma boa noite de sono. Ele apoiará seu pescoço corretamente e ajudará você a manter uma temperatura confortável para dormir, para a felicidade de todo o corpo. Almofadas ortopédicas podem ser uma opção melhor para você do que almofadas de penas ou de espuma com memória.",

            "Use um cobertor pesado para reduzir o estresse corporal\n"+
                    "Os bebês recém-nascidos tendem a dormir melhor quando são enrolados, pois os mantém apertados e imitam suas condições de vida no útero. Os adultos podem se beneficiar da mesma sensação usando um cobertor pesado. Ele usa estimulação de pressão profunda para relaxar o sistema nervoso, que, por sua vez, aumenta os níveis de serotonina e melatonina. A ativação dos pontos de pressão no corpo ajuda a reduzir o estresse e aumentar a sensação de relaxamento e sonolência.",

            "Evite a ingestão de cafeína\n"+
                    "Antes mesmo de ir para a cama, há coisas que você pode fazer no início do dia para facilitar o deslizamento da soneca - como evitar a ingestão de cafeína. Por ser um estimulante, a cafeína torna mais difícil adormecer, o que pode levar a um sono mais curto e mais fraco. Evite cafeína pelo menos 6 horas antes de dormir, embora esse período de tempo dependa de sua tolerância individual à cafeína. Não são apenas café, chá e bebidas energéticas nas quais você encontra cafeína; esteja ciente do chocolate e sorvete com sabor de café também.",

            "Experimente um chá sem cafeína antes de dormir\n"+
                    "O chá é conhecido por suas propriedades relaxantes, que demonstrou reduzir o estresse. Experimente um copo antes de dormir - evite chá verde e preto contendo cafeína e opte por um chá sem cafeína. Você pode encontrar chás que dão sono em um supermercado, e geralmente está cheio de ingredientes calmantes, como camomila, maracujá e valeriana.\n"+
                    "\n"+
                    "34. Mude sua posição de dormir\n"+
                    "Pensa-se que dormir ao seu lado pode ser a melhor posição para uma boa noite de descanso. Use um travesseiro entre as pernas para obter mais apoio nas costas. Se dormir de lado não funcionar para você, ajuste sua posição de dormir para obter o benefício máximo do tempo de sono. Se você dorme de costas, use um travesseiro de boa qualidade para apoiar seu pescoço. Se você tem dor de estômago, para evitar esticar o pescoço  \n"+
                    "não use um travesseiro. ",

            "Desligue lendo um livro\n"+
                    "Procure um livro em papel, não um e-book (devido à luz azul que eles emitem), para ajudá-lo a adormecer mais rapidamente. A leitura ajuda a relaxar e a distrair-se de qualquer preocupação. Uma mente clara e tranquila tornará mais fácil adormecer. É melhor tentar algo leve, em vez de horror ou suspense. ",

            "Bloqueie o ruído\n"+
                    "O barulho não é nosso amigo quando estamos tentando adormecer - pode ser uma distração estressante. Felizmente, é uma solução fácil. Tente tampões para os ouvidos, fones de ouvido acolchoados e confortáveis ou use ruído branco.",

            "Saboreie um lanche com sono\n"+
                    "Um lanche leve antes de dormir contendo um carboidrato de baixo índice glicêmico pode ajudar nosso cérebro a produzir serotonina, sinalizando que é hora de dormir. Experimente uma banana pequena, um punhado de frutas vermelhas ou uma pequena fatia de torrada. Tenha cuidado para saborear apenas um lanche leve, pois muita comida tarde da noite sobrecarregará seu sistema digestivo. Ou você pode experimentar alimentos ricos em magnésio combinados com carboidratos. Os alimentos ricos em magnésio atuam como relaxantes musculares, enquanto os carboidratos aumentam o açúcar no sangue, iniciando a produção de insulina do corpo e ajudando a \"colidir\" com a sonolência.",

            "Durma em roupas confortáveis\n"+
                    "Existe uma forte ligação entre o sono e a temperatura corporal central; portanto, escolha roupas de dormir confortáveis que seu corpo possa respirar, como algodão ou merino. Isso ajudará a regular melhor a temperatura do corpo e a dormir mais rápido. Opte por roupas largas que não restrinjam seus movimentos e sem zíperes ou cadarços irritantes que possam prender enquanto você se move durante a noite.",

            "Exercite-se regularmente\n"+
                    "Exercícios regulares durante o dia podem reduzir os hormônios do estresse e fortalecer os ritmos circadianos, promovendo a atenção diurna e a sonolência noturna. Três a quatro sessões de 30 minutos por semana de exercício aeróbico moderado (como caminhada, natação, ciclismo ou corrida) são suficientes.",

            "Mantenha animais de estimação fora do seu quarto\n"+
                    "Ter um animal de estimação como seu companheiro de cama pode estar dificultando uma boa noite de sono, desde o ronco e a movimentação e a necessidade de ir ao banheiro. Pesquisas mostram que dormir juntos pode resultar em você acordar com mais frequência durante a noite. Esse sono interrompido e agitado pode em breve contribuir para a privação do sono. Tente evitar ter um animal de estimação em sua cama e poderá desfrutar de um sono melhor e mais profundo.",

            "Aprenda uma técnica de relaxamento progressivo\n"+
                    "Prepare seu corpo para dormir usando relaxamento progressivo. Este exercício simples e rápido envolve dobrar os dedos dos pés com força por uma contagem de sete e depois relaxá-los. Repita através de cada grupo muscular, trabalhando dos dedos dos pés até o pescoço. Isso ajudará a aliviar qualquer tensão no seu corpo, acalmando-o para uma boa noite de sono.",

            "Ir acampar\n"+
                    "Acampar redefine seus ritmos circadianos - você acorda naturalmente com o sol (cedo!) E fica com sono quando o sol se põe. Um colchão de ar confortável é fundamental e estar do lado de fora, com muita exposição à luz do dia e ao ar fresco, também ajudará a cansar.",

            "Inspire pela narina esquerda\n"+
                    "Respirar apenas pela narina esquerda ativa sua resposta parassimpática, desativando o modo de execução ou luta da sua mente, que é uma barreira para o sono repousante. Para fazer isso, coloque um dedo na narina direita e respire pela narina esquerda, respirando lenta e profundamente.",

            "Retroceda mentalmente o seu dia\n"+
                    "Permitir que seu cérebro processe seu dia calmo e metodicamente ajude a facilitar o processo para um estado de descanso. Passe por todos os eventos do seu dia, desde o último da noite até o primeiro da manhã.",

            "Enrole os dedos dos pés\n"+
                    "Um exercício monótono, sem nenhum esforço necessário, ajuda a relaxar o corpo e a mente. Enrole os dedos dos pés, segure por alguns segundos e solte. Repita 2-3 vezes para se sentir calmo.\n",

            "Revire os olhos\n"+
                    "Quando você dorme, inconscientemente revira os olhos em pequenos movimentos. Ao fazer esses movimentos deliberadamente, você pode ativar seu cérebro para liberar o hormônio natural do sono, uma melatonina. Feche seus olhos, prestando atenção à sua respiração. Em seguida, role os olhos, prestando atenção à sua respiração. Repita 2-3 vezes até sentir relaxado e pronto para dormir.",

            "Visite seu médico\n"+
                    "Se você experimentar alterações no estilo de vida e estratégias de relaxamento, mas não estiver ajudando você a cair e ficar dormindo, talvez seja a hora de visitar seu médico. Pode ser que sua insônia seja um sintoma de um problema de saúde. Eles podem investigar e ajudar você a encontrar o melhor tratamento.",

            "Deixe seu quarto confortável\n"+
                    "Ajude sua mente e seu corpo a desligar durante o sono, criando o ambiente de sono ideal e tranquilo. Mime-se com novos travesseiros, colchão ou os lençóis toda semana e invista em pouca iluminação ao lado da cabeceira. Dica rápida: usar um colchão é uma maneira acessível de adicionar um pouco de conforto extra à cama sem gastar muito.",

            "Se canse durante o dia\n"+
                    "Quando você está de férias, geralmente descobre que toda diversão, emoção e atividade resultam em você cair na cama e dormir direto. Portanto, quando você não estiver em férias, faça um esforço para se cansar mentalmente e fisicamente (exercite-se bastante, faça um quebra-cabeça ou sudoku) em vez de apenas ficar sentado no sofá assistindo TV.",

            "Faça uma massagem\n"+
                    "Convença seu parceiro a fazer uma pequena massagem antes de dormir. Não precisa ser nada técnico demais - apenas pequenos movimentos circulares em áreas com maior tensão, como pescoço, costas e ombros. Aumente os benefícios da massagem usando um óleo indutor do sono.",

            "Faça sexo\n"+
                    "Uma pesquisa concorda que o sexo pode diminuir o estresse e ajudar a promover sentimentos de cansaço, ajudando você a adormecer rapidamente.",

            "Pare de roncar\n"+
                    "Seja você ou seu parceiro roncando, é perturbador dormir. Há uma variedade de auxiliares de ronco disponíveis que podem ajudar.",

            "Beba água suficiente durante o dia\n"+
                    "Para evitar sentir sede à noite - o que levará você a pegar sua garrafa de água, precisar do banheiro e interromper seu sono -, beba bastante água durante o dia. Apontar para cerca de 2 litros.",

            "Mantenha sua cama apenas para dormir e sexo\n"+
                    "Ajude seu corpo e mente a associar sua cama a apenas 2 coisas: sono e sexo. Então, quando você desliza por baixo das cobertas, seu corpo e sua mente podem se preparar para dormir (ou fazer sexo!). Se você trabalha, brinca ou assiste TV na cama com frequência, seu corpo e mente associam a cama a isso, tornando mais difícil desligar quando você quer dormir.",

            "Pare de fumar\n"+
                    "Os fumantes têm 4 vezes mais chances de sentir exaustão e cansado pela manhã do que os não fumantes. Isso ocorre porque a nicotina tem um efeito estimulante (como a cafeína), impedindo que os fumantes fiquem em sono profundo. Tente parar e veja qual o \n"+
                    "impacto que isso causa no seu sono.",

            "Evite alimentos apimentados, gordurosos ou fritos antes de dormir\n"+
                    "Eles podem perturbar seu estômago e causar refluxo, os quais provavelmente impedirão que você tenha uma boa noite de sono.",

            "Não pressione o botão soneca\n"+
                    "O sono com o botão soneca não é um sono reparador e profundo. O que significa que pressionar o botão de soneca pode fazer você se sentir mais cansado do que se tivesse acabado de acordar quando o alarme disparou. Em vez de começar o dia lento, levante-se quando o alarme disparar. Você se sentirá mais acordado e descansado, o que o ajudará a relaxar melhor no final do dia.",

            "Evite conversas profundas na cama\n"+
                    "Quando você quer adormecer, precisa de uma mente calma e descansada. O que significa que a hora de dormir não é o momento de conversas profundas e significativas com seu parceiro, mãe ou melhor amigo, pois é provável que sua mente acelere de uma maneira que não seja útil para adormecer. Programe as conversas sérias durante o dia.",

            "Fique fora da cama até sentir sono\n"+
                    "Se você não estiver com sono, não vá para a cama, pois seu corpo não se acalma. Espere até se sentir cansado.\n",

            "Remova os eletrônicos\n"+
                    "Seu quarto deve ser uma zona livre de eletrônicos. Isso significa que não há TV, computadores, telefones ou tablets. Eles não apenas emitem luz azul que mata o sono, mas também tentam você a realizar atividades não repousantes que o manterão acordado.\n",

            "Faça algo irracional\n"+
                    "Quanto mais entediado você estiver, menor será a probabilidade de conseguir pensar em outra coisa - e mais rápido você adormecerá. Os especialistas recomendam um exercício matematicamente desafiador, como contar para trás de 100 em múltiplos de 3.",

            "Faça uma lista de tarefas\n"+
                    "Quando sua mente está focada no amanhã, você se sente desconfortável, o que pode enviar adrenalina através de seu corpo, mantendo-o alerta e acordado. Assuma o controle fazendo uma pequena lista de tarefas antes de dormir todas as noites. Isso diminuirá sua ansiedade sobre o que precisa ser feito amanhã, faça uma lista de tarefas passo a passo. Escreva à mão em vez de usar um telefone ou laptop emissor de luz azul.",

            "Dedique tempo durante o dia às suas preocupações\n"+
                    "Se sua mente disparar enquanto você tenta adormecer, pense em agendar um 'tempo de preocupação' dedicado durante o dia. Atenha-se ao mesmo espaço de 15 minutos todos os dias e dê liberdade ao seu cérebro para considerar todas as coisas que o preocupam. Você pode compartilhar com um ente querido ou anotá-los, mas é o ato de liberar suas preocupações durante o dia que o ajudará a desligar na hora de dormir.",

            "Mantenha uma caneta e um caderno ao lado da sua cama\n"+
                    "Se você não conseguir dormir por causa de sua mente preocupada, facilite a tarefa de soltá-los da cabeça deles mantendo uma caneta e um caderno por perto. \n",

            "Não vá para a cama com raiva\n"+
                    "Casais que estão juntos há décadas normalmente têm um conselho sobre o casamento para compartilhar - não vá para a cama com raiva. Acontece que isso pode realmente ter alguma verdade. Isso porque se você está com raiva ou irritado, você inundará seu sistema nervoso com substâncias químicas que prejudicam o sono, como a adrenalina. Tente resolver qualquer desavença antes de ir para a cama, caso contrário, você não terá uma boa noite de sono - e provavelmente sentirá ainda mais raiva pela manhã.",

            "Tente uma cadeira de balanço ou rede\n"+
                    "A maioria dos bebês adormece quando embalados, então não há razão para que os adultos também não. Balançar pode ser uma das melhores maneiras de adormecer rápido e naturalmente. Quando ainda estávamos no útero, estávamos acostumados a uma sensação de balanço reconfortante, suave e repetitiva - a de nossas mães se movendo. O que significa que nosso prazer de um movimento de balanço foi fixado em nossos cérebros antes mesmo de nascermos.",

            "Tente cantarolar\n"+
                    "O zumbido pode ajudar seu corpo a se sentir menos estressado, mais relaxado e calmo, o que significa que adormecer será mais fácil e rápido. Deite-se na sua cama com os olhos fechados. Inspire e depois gentilmente tente cantarolar por toda a expiração. Concentre-se nessa sensação.",

            "Desenvolver um gatilho do sono\n"+
                    "Um gatilho do sono ajuda sua mente a associar uma ação única ao adormecer. Escolha algo que você não faz em nenhum outro momento durante o dia e use-o todas as noites enquanto adormece - tente acariciar sua bochecha. Faça-o todas as noites para que sua mente associe a ação ao adormecer, e você poderá usá-lo como um gatilho para adormecer mais rapidamente.",

            "Mantenha um diário de sono\n"+
                    "Ajude-se a entender qualquer coisa que possa estar interferindo no seu sono, identificando seus hábitos de sono. Inicie um diário do sono e escreva sempre que acordar tudo o que você notou que possa estar relacionado à qualidade do seu sono. Por exemplo, você teve uma noite mais tarde do que o normal e percebeu que não conseguia dormir facilmente naquela noite? Você comeu uma tigela cheia de carboidratos antes de dormir e se esforçou para dormir? Todas essas informações o ajudarão a determinar qual é o seu horário de sono real - a que horas você naturalmente acorda de manhã e fica com sono à noite - e todas as atividades que afetam negativamente o sono. Você pode usar essas informações para determinar o melhor horário de sono para você.\n",

            "Mantenha seu quarto arrumado\n"+
                    "Seu quarto precisa ser um local tranquilo para ajudar sua mente a se desligar após uma noite agitada. A desordem não é tranquila. Verifique se o seu quarto está arrumado e limpo, sem roupas no chão, pilhas de trabalho ou equipamento para exercícios.",

            "Escolha um esquema de cores suave para o seu quarto\n"+
                    "Tons calmantes ajudam a desencadear o sono porque ajudam a relaxar. Decore o seu quarto com tons naturais e suaves, em vez de tons altos e vibrantes - um azul suave em vez de um rosa brilhante.",

            " Mantenha sua passagem nasal clara\n"+
                    "Quando a maioria de nós adormece, obtemos menos oxigênio do que quando acordamos, o que resulta em um sono mais perturbado. Manter um fluxo de ar aberto ajuda a manter a abundância de oxigênio fluindo. Existem produtos ao redor que podem ajudar a manter sua passagem nasal aberta por dentro. ",

            "Beba leite morno\n"+
                    "Há muito se pensa que o leite quente antes de dormir pode ajudá-lo a adormecer. Os especialistas não sabem ao certo - pode ser que ele contenha 2 substâncias relacionadas ao sono e relaxamento (melatonina e triptofano) ou simplesmente que é reconfortante e nos lembra nossas infâncias. Tente um copo quente como parte de sua rotina de dormir e veja se ele ajuda.",

            "Tente hipnose\n"+
                    "O YouTube está repleto de vídeos de hipnose do sono para você experimentar quando está na cama. Evite a luz azul do seu dispositivo eletrônico, apenas ouvindo-os e não observando-os. Também pode haver praticantes de hipnose do sono perto de você.",

            "Esfregue sua barriga\n"+
                    "Esfregar a barriga pode ajudar seu corpo a relaxar, acalmando-o e permitindo que você adormeça. Começando no umbigo, esfregue a barriga em círculos cada vez maiores no sentido horário e depois em círculos cada vez menores no sentido anti-horário. Repita até sentir sono.",

            "Sincronize sua respiração\n"+
                    "Sua respiração diminui naturalmente quando você adormece. Imite essa sensação ajudando a diminuir a respiração.",

            "Cante para dormir\n"+
                    "Outro truque dos pais, cantar canções de ninar para os bebês os deixa sonolentos. Tente cantar suavemente para si mesmo quando estiver na cama. Você pode acalmar e relaxar, podendo adormecer mais rapidamente.",

            "Mantenha seu intestino feliz\n"+
                    "O equilíbrio de bactérias boas e ruins em seu intestino pode afetar a qualidade do seu sono. Mantenha-os felizes com uma dieta equilibrada e rica em fibras e complemente sua dieta com probióticos. ",

            "Seja grato\n"+
                    "Considere um ajuste de atitude se desejar uma melhor noite de sono. Pessoas agradecidas têm pensamentos mais positivos ao adormecer, talvez porque não estejam preocupadas em ter uma noite ruim ou em não conseguir dormir. Tente ir para a cama com uma mentalidade positiva para pavimentar o caminho para um momento mais fácil de adormecer.",

            "Tenha um tempo quieto\n"+
                    "Conversar ou socializar nos mantém alertas e engajados, tornando mais difícil relaxar e adormecer. Crie um período de inatividade silencioso na hora antes de dormir, evite a estimulação social, incluindo interações online."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_nine_list);
        list=(ListView)findViewById(R.id.list);
        DetailListAdapter adapter=new DetailListAdapter(this, itemname, "9");
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // TODO Auto-generated method stub
//                String Selecteditem = itemname[position];
//                Intent intent = new Intent(OneListActivity.this, OneDetailList.class);
//                startActivity(intent);
//                Log.d("id", String.valueOf(id));

            }
        });

    }
}
