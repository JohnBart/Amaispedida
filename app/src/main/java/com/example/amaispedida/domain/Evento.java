package com.example.amaispedida.domain;

import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by João Paulo Bart Dias on 11/07/2017.
 */

public class Evento {
    private Integer imagemArtista;
    private String nomeEvento;
    private String nomeArtista;
    private String generoMusical;
    private String localShow;
    private String data;
    private String hora;

    public Evento() {
    }

    public Evento(Integer imagemArtista, String nomeEvento, String nomeArtista, String generoMusical, String localShow, String data, String hora) {
        this.nomeEvento = nomeEvento;
        this.imagemArtista = imagemArtista;
        this.nomeArtista = nomeArtista;
        this.generoMusical = generoMusical;
        this.localShow = localShow;
        this.data = data;
        this.hora = hora;
    }


    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public Integer getImagemArtista() {
        return imagemArtista;
    }

    public void setImagemArtista(Integer imagemArtista) {
        this.imagemArtista = imagemArtista;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public String getLocalShow() {
        return localShow;
    }

    public void setLocalShow(String localShow) {
        this.localShow = localShow;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}