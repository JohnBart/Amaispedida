package com.example.amaispedida.interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.amaispedida.R;

public class MusicoMainActivity extends AppCompatActivity {

    Button bt_cadastrar_musica;
    Button bt_consultar_musicas;
    Button bt_cadastrar_evento;
    Button bt_consultar_eventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musico_main);

        bt_cadastrar_musica = (Button) findViewById(R.id.bt_cadastrar_musica);
        bt_cadastrar_musica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_consultar_musicas = (Button) findViewById(R.id.bt_consultar_musicas);
        bt_consultar_musicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        bt_cadastrar_evento = (Button) findViewById(R.id.bt_cadastrar_evento);
        bt_cadastrar_evento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        bt_consultar_eventos = (Button) findViewById(R.id.bt_consultar_eventos);
        bt_consultar_eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
