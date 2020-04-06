package com.renata.mentesaudvel.List;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.renata.mentesaudvel.Adapter.DetailListAdapter;
import com.renata.mentesaudvel.DetailList.OneDetailList;
import com.renata.mentesaudvel.R;

public class OneListActivity extends AppCompatActivity {
    ListView list;
    String[] itemname ={
            "A alimentação consciente é baseada na atenção plena. O que é comer atentamente?\n"+
                    "A atenção plena é uma forma de meditação que ajuda a reconhecer e lidar com suas emoções e sensações físicas.\n"+
                    "É usado para tratar muitas condições, incluindo distúrbios alimentares, depressão, ansiedade e vários comportamentos relacionados a alimentos.\n"+
                    "Comer atentamente significa usar a atenção plena para atingir um estado de total atenção às suas experiências, desejos e sugestões físicas ao comer. \n"+
                    "Fundamentalmente, a alimentação consciente envolve:\n"+
                    "•\tComer devagar e sem distração\n"+
                    "•\tOuvir sinais físicos de fome e comendo apenas até você estar cheio\n"+
                    "•\tDistinguir entre a verdadeira fome e a vontade de comer\n"+
                    "•\tEnvolver seus sentidos ao perceber cores, cheiros, sons, texturas e sabores\n"+
                    "•\tAprender a lidar com a culpa e a ansiedade em relação à comida\n"+
                    "•\tComer para manter a saúde e o bem-estar em geral\n"+
                    "•\tPerceber os efeitos que a comida tem sobre seus sentimentos e sobre você\n"+
                    "•\tApreciar sua comida\n"+
                    "Essas coisas permitem que você substitua pensamentos e reações automáticos por respostas mais conscientes e saudáveis. Por que você deveria tentar comer atentamente?\n"+
                    "A sociedade acelerada de hoje tenta as pessoas com uma abundância de escolhas alimentares. Além disso, as distrações mudaram a atenção do ato atual de comer para televisões, computadores e smartphones. \n"+
                    "Comer tornou-se um ato irracional, geralmente feito rapidamente. Isso pode ser problemático, pois leva 20 minutos para o seu cérebro perceber que você está cheio. Se você comer rápido demais, o sinal de saciedade poderá não chegar até que você já tenha comido demais. Isso é muito comum na compulsão alimentar. Ao comer conscientemente, você restaura sua atenção e diminui a velocidade, tornando a alimentação um ato intencional em vez de automático.\n"+
                    "Além disso, ao aumentar o reconhecimento de sinais de fome física e de plenitude, você consegue distinguir entre fome emocional e a verdadeira fome.\n"+
                    "Você também aumenta sua percepção dos gatilhos que fazem você querer comer, mesmo que não esteja necessariamente com fome. Ao conhecer seus gatilhos, você pode criar um espaço entre eles e sua resposta, oferecendo tempo e liberdade para escolher como reagir.",

            "Alimentação consciente e perda de peso.\n"+
                    "É sabido que a maioria dos programas de perda de peso não funciona a longo prazo. Cerca de 85% das pessoas com obesidade que perdem peso retornam ou excedem seu peso inicial dentro de alguns anos. \n"+
                    "A compulsão alimentar, a alimentação emocional e a alimentação em resposta aos desejos alimentares têm sido associadas ao ganho e à recuperação de peso após a perda bem-sucedida de peso.",

            "A exposição crônica ao estresse também pode ter um papel importante em comer demais e obesidade.\n"+
                    "A grande maioria dos estudos concorda que a alimentação consciente ajuda a perder peso, alterando seus comportamentos alimentares e reduzindo o estresse. \n"+
                    "Um seminário em grupo de 6 semanas sobre alimentação consciente entre pessoas com obesidade resultou em uma perda de peso média de 4 kg durante o seminário e no período de acompanhamento de 12 semanas.\n"+
                    "Outro seminário de 6 meses resultou em uma perda de peso média de 12 kg - sem recuperar o peso nos 3 meses seguintes\n"+
                    "Ao mudar a maneira como você pensa sobre a comida, os sentimentos negativos que podem estar associados à alimentação são substituídos por conscientização, autocontrole aprimorado e emoções positivas.\n"+
                    "Quando comportamentos alimentares indesejados são abordados, suas chances de sucesso a longo prazo na perda de peso aumentam. \n",

            "Alimentação consciente e compulsão alimentar\n"+
                    "A compulsão alimentar envolve comer uma grande quantidade de comida em um curto período de tempo, sem pensar e sem controle. Tem sido associada a distúrbios alimentares e ganho de peso, e um estudo mostrou que quase 70% das pessoas com transtorno da compulsão alimentar periódica são obesas. \n"+
                    "A alimentação consciente pode reduzir drasticamente a gravidade e a frequência dos episódios de compulsão alimentar.\n"+
                    "Um estudo descobriu que, após uma intervenção em grupo de 6 semanas em mulheres com obesidade, os episódios de compulsão alimentar diminuíram de 4 para 1,5 vezes por semana. A severidade de cada episódio também diminuiu alimentação consciente, além dos comportamentos alimentares não saudáveis",

            "É um tratamento eficaz para a compulsão alimentar e também foi demonstrado que os métodos de alimentação consciente reduzem:\n"+
                    "Comer emocional. Esse é o ato de comer em resposta a certas emoções. Alimentação externa. Isso ocorre quando você come em resposta a sugestões ambientais relacionadas à comida, como a visão ou o cheiro da comida. Comportamentos alimentares não saudáveis como esses são os problemas comportamentais mais comumente relatados em pessoas com obesidade.\n"+
                    "A alimentação consciente fornece as habilidades necessárias para lidar com esses impulsos. Põe você no comando de suas respostas, e não na vontade de seu instinto."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_one_list);
        list=(ListView)findViewById(R.id.list);
        DetailListAdapter adapter=new DetailListAdapter(this, itemname, "1");
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
