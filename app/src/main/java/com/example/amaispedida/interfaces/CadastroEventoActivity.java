package com.example.amaispedida.interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.amaispedida.R;

public class CadastroEventoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento);

        Button bt_inserirImagemEvento = (Button) findViewById(R.id.button_insert_image);
        bt_inserirImagemEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        Button bt_salvarEvento = (Button) findViewById(R.id.bt_salvar_evento_cadastro);
        bt_salvarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        Button bt_editarEvento = (Button) findViewById(R.id.bt_editar_evento_cadastro);
        bt_editarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        Button bt_cancelarEvento = (Button) findViewById(R.id.bt_cancelar_evento_cadastro);
        bt_cancelarEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
