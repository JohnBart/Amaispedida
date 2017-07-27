package com.example.amaispedida.interfaces;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amaispedida.R;
import com.example.amaispedida.database.DBController;
import com.example.amaispedida.database.DatabaseHelper;
import com.example.amaispedida.domain.Evento;

public class CadastroEventoActivity extends AppCompatActivity {

    //DatabaseHelper database = new DatabaseHelper(this);
    DBController database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_evento);

        //Acesso ao banco de dados:
        database = new DBController(this);

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
                EditText nome_evento = (EditText) findViewById(R.id.et_nome_evento_cadastro);
                EditText nome_artista = (EditText) findViewById(R.id.et_nome_artista_cadastro);
                EditText genero_musical = (EditText) findViewById(R.id.et_genero_cadastro);
                EditText local = (EditText) findViewById(R.id.et_local_evento_cadastro);
                EditText data = (EditText) findViewById(R.id.et_data_evento_cadastro);
                EditText hora = (EditText) findViewById(R.id.et_hora_evento_cadastro);

                String nome_eventost = nome_evento.getText().toString();
                String nome_artistast = nome_artista.getText().toString();
                String genero_musicalst = genero_musical.getText().toString();
                String localst = local.getText().toString();
                String datast = data.getText().toString();
                String horast = hora.getText().toString();

                if(nome_eventost.isEmpty()||nome_artistast.isEmpty()||genero_musicalst.isEmpty()||localst.isEmpty()||
                        datast.isEmpty()||horast.isEmpty()) {
                    alert("Campo em branco, favor preencher todo o formulário");
                } else {
                    Evento evento = new Evento();
                    evento.setNomeEvento(nome_eventost);
                    evento.setNomeArtista(nome_artistast);
                    evento.setGeneroMusical(genero_musicalst);
                    evento.setLocalShow(localst);
                    evento.setData(datast);
                    evento.setHora(horast);



                    database.insertEvento(evento, 1);
                    alert("Evento Salvo");
                }



            }
        });
    }
    public void alert(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
