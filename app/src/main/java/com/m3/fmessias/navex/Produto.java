package com.m3.fmessias.navex;

import android.os.Parcel;
import android.os.Parcelable;

public class Produto implements Parcelable {
    private String titulo;
    private int preco;
    private String local;
    private String categoria;
    private String tipoDoAnuncio;
    private String novoUsado;
    private String genero;
    private String descricao;
    private int numeroCelular;


    public Produto(String titulo, int preco, String local, String categoria, String tipoDoAnuncio, String novoUsado, String genero, String descricao, int numeroCelular) {
        setTitulo(titulo);
        setPreco(preco);
        setLocal(local);
        setCategoria(categoria);
        setTipoDoAnuncio(tipoDoAnuncio);
        setNovoUsado(novoUsado);
        setGenero(genero);
        setDescricao(descricao);
        setNumeroCelular(numeroCelular);
    }

    public Produto (){  }

    protected Produto(Parcel in) {
        titulo = in.readString();
        preco = in.readInt();
        local = in.readString();
        categoria = in.readString();
        tipoDoAnuncio = in.readString();
        novoUsado = in.readString();
        genero = in.readString();
        descricao = in.readString();
        numeroCelular = in.readInt();
    }
    //Parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(titulo);
        dest.writeInt(preco);
        dest.writeString(local);
        dest.writeString(categoria);
        dest.writeString(tipoDoAnuncio);
        dest.writeString(novoUsado);
        dest.writeString(genero);
        dest.writeString(descricao);
        dest.writeInt(numeroCelular);
    }

    public static final Creator<Produto> CREATOR = new Creator<Produto>() {
        @Override
        public Produto createFromParcel(Parcel in) {
            return new Produto(in);
        }

        @Override
        public Produto[] newArray(int size) {
            return new Produto[size];
        }
    };

    //Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipoDoAnuncio() {
        return tipoDoAnuncio;
    }

    public void setTipoDoAnuncio(String tipoDoAnuncio) {
        this.tipoDoAnuncio = tipoDoAnuncio;
    }

    public String getNovoUsado() {
        return novoUsado;
    }

    public void setNovoUsado(String novoUsado) {
        this.novoUsado = novoUsado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }



}
