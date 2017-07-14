package com.example.amaispedida.domain;

/**
 * Created by João Paulo Bart Dias on 12/07/2017.
 */

public class Musica {

    private String musica;
    private String compositor;

    public Musica() {
    }

    public Musica(String musica, String compositor) {
        this.musica = musica;
        this.compositor = compositor;
    }

    public String getMusica() {
        return musica;
    }

    public void setMusica(String musica) {
        this.musica = musica;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }


}
