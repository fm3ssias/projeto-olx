package com.m3.fmessias.navex;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ProdutoAdapter produtoAdapter;
    private ListView listView;
    private List<Produto> produtoList;
    private Intent intent;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_anuncios:

                    return true;
                case R.id.navigation_chats:

                    return true;
                case R.id.navigation_inserirAnuncio:

                    return true;
                case R.id.navigation_minhaConta:

                    return true;
                case R.id.navigation_mais:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        produtoList = new ArrayList<>();
        listView = findViewById(R.id.listProduto);

        produtoList.add(new Produto("Magrela só o gold, brbr", 250, "Taguatinga Sul - 06 Maio 00:30", "Ciclismo", "Venda", "Usado", "Não se aplica", "Bike novinha, unico dono, jaé jaé, troco por berma, telefone, xama na call. Faça sua ofera, parça.", 999876634));
        produtoList.add(new Produto("Ótima moradia, minha casa minha vida", 100500, "Brasília - 14 Maio 14:11 ", "Casas", "Venda/Aluguel", "Nova", "Não se aplica", "Acabei de receber a casa. Propostas wpp. (61)988473123", 988473123));
        produtoList.add(new Produto("Gato para adoção", 0, "Guará II - 20 Abril 20:12 ", "Bichos/Animais", "Doação", "Novo/Usado", "Não se aplica", "Gente, achei esse gatinhho na frente da minha casa! Ele é super dócil, por favor, alguem adota ele, não tenho condições de criar o bixin. Já está vermifugado e entrego com areia e ração. Obrigado.", 99410401));
        produtoList.add(new Produto("ps4 semi-novo", 980, "Águas Claras - 28 Abril 13:00", "Video Games", "Venda", "Usado", "Não se aplica", "Usei pouco tempo. MMotivo de troca, não jogomuito e preciso do dinheiro. Só venda e em dinheiro.", 99887678));
        produtoList.add(new Produto("Roadster. Único no Brasil", 1000000, "Brasília - 10 Março 09:00", "Veículos/Automóveis", "Venda/Troca", "Usado", "God", "Único Tesla Roaster no Brasil. Passando pra frente porque a energia tá muito cara... não pera... ", 99691337));
        produtoList.add(new Produto("Jogos xone barato", 30, "Asa sul - 01 Abril 17:14", "Video Games", "Venda/Troca", "Usado", "Não se aplica", "Vendo ou troco por outro que ainda nao joguei. Chama wpp (61)98776123", 98776123));

        produtoAdapter = new ProdutoAdapter(this, produtoList);
        listView.setAdapter(produtoAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        mostraDescricao(position, "bike");
                        break;
                    case 1:
                        mostraDescricao(position, "casa");
                        break;
                    case 2:
                        mostraDescricao(position, "gato");
                        break;
                    case 3:
                        mostraDescricao(position, "ps4");
                        break;
                    case 4:
                        mostraDescricao(position, "roadster");
                        break;
                    case 5:
                        mostraDescricao(position, "xonejogos");
                        break;
                }
            }
        });

    }

    private void mostraDescricao(int position, String imagem){
        intent = new Intent(MainActivity.this, DescricaoActivity.class);
        intent.putExtra("produto", produtoList.get(position));
        intent.putExtra("imagem", imagem);
        startActivity(intent);
    }
}
