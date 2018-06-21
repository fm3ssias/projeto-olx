package com.m3.fmessias.navex;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProdutoAdapter extends BaseAdapter {

    Context context;
    Produto produto;
    List<Produto> listProduto;

    public ProdutoAdapter(Context context, List<Produto> listProduto) {
        this.context = context;
        this.listProduto = listProduto;
    }

    @Override
    public int getCount() {
        return listProduto.size();
    }

    @Override
    public Object getItem(int position) {
        return listProduto.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        produto = (Produto) getItem(position);

        //Inflate
        View linha = LayoutInflater.from(context).inflate(R.layout.produto, null);

        //Referencias
        ImageView imgProduto = linha.findViewById(R.id.imgProduto);
        TextView txtTituloProduto = linha.findViewById(R.id.txtProduto);
        TextView txtPrecoProduto = linha.findViewById(R.id.txtPreco);
        TextView txtLocalDataHora = linha.findViewById(R.id.txtLocalDataHora);

        //Pega o array dos produtos
        Resources resources = context.getResources();
        TypedArray typedArray = resources.obtainTypedArray(R.array.listaProdutos);

        //Seta os valores
        imgProduto.setImageDrawable(typedArray.getDrawable(position));
        txtTituloProduto.setText(produto.getTitulo());
        txtPrecoProduto.setText(String.valueOf(produto.getPreco()));
        txtLocalDataHora.setText(produto.getLocal());

        return linha;
    }
}
