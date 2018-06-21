package com.m3.fmessias.navex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.nio.channels.InterruptedByTimeoutException;

public class DescricaoActivity extends Activity {

    private ImageView imgProduto;
    private TextView txtTitulo;
    private TextView txtLocalDataHora;
    private TextView txtPreco;
    private TextView txtCategoria;
    private TextView txtTipoAnuncio;
    private TextView txtNovoUsado;
    private TextView txtGenero;
    private TextView txtDescricao;
    private Produto produto = new Produto();
    private Intent intent;
    private String imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao);
        intent = getIntent();

        //Referencias
        imgProduto = findViewById(R.id.imgProdutoDesc);
        txtTitulo = findViewById(R.id.txtProdutoDesc);
        txtLocalDataHora = findViewById(R.id.txtLocalDataHoraDesc);
        txtPreco = findViewById(R.id.txtPrecoDesc);
        txtCategoria = findViewById(R.id.txtCategoriaDesc);
        txtTipoAnuncio = findViewById(R.id.txtTipoAnuncioDesc);
        txtNovoUsado = findViewById(R.id.txtNovoUsadoDesc);
        txtGenero = findViewById(R.id.txtGeneroDesc);
        txtDescricao = findViewById(R.id.txtDescricaoDesc);

        //Recebe os parâmetros
        produto = intent.getParcelableExtra("produto");

        if(produto != null){
            imagem = intent.getStringExtra("imagem");

            //seta as imagens
            switch (imagem){
                case "bike":
                    imgProduto.setImageDrawable(getResources().getDrawable(R.drawable.bike));
                    break;
                case "casa":
                    imgProduto.setImageDrawable(getResources().getDrawable(R.drawable.casa));
                    break;
                case "gato":
                    imgProduto.setImageDrawable(getResources().getDrawable(R.drawable.gato));
                    break;
                case "ps4":
                    imgProduto.setImageDrawable(getResources().getDrawable(R.drawable.ps4));
                    break;
                case "roadster":
                    imgProduto.setImageDrawable(getResources().getDrawable(R.drawable.roadster));
                    break;
                case "xonejogos":
                    imgProduto.setImageDrawable(getResources().getDrawable(R.drawable.xonejogos));
                    break;
            }

            txtTitulo.setText(produto.getTitulo());
            txtLocalDataHora.setText(produto.getLocal());
            txtPreco.setText("R$"+String.valueOf(produto.getPreco()));
            txtCategoria.setText(produto.getCategoria());
            txtTipoAnuncio.setText(produto.getTipoDoAnuncio());
            txtNovoUsado.setText(produto.getNovoUsado());
            txtGenero.setText(produto.getGenero());
            txtDescricao.setText(produto.getDescricao());
        }


    }
}
