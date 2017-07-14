package com.example.amaispedida.domain;

import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by João Paulo Bart Dias on 11/07/2017.
 */

public class Evento {
    private Integer imagemArtista;
    private String nomeArtista;
    private String generoMusical;
    private String localShow;
    private String dataHoraShow;

    public Evento(){ }

    public Evento(Integer imagemArtista, String nomeArtista, String generoMusical, String localShow, String dataHoraShow){
        this.imagemArtista = imagemArtista;
        this.nomeArtista = nomeArtista;
        this.generoMusical = generoMusical;
        this.dataHoraShow = dataHoraShow;
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

    public String getDataHoraShow() {
        return dataHoraShow;
    }

    public void setDataHoraShow(String dataHoraShow) {
        this.dataHoraShow = dataHoraShow;
    }
}
