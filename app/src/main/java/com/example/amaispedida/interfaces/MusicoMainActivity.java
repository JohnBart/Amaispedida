package com.example.amaispedida.interfaces;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.amaispedida.R;
import com.example.amaispedida.database.DBController;
import com.example.amaispedida.domain.User;

public class MusicoMainActivity extends AppCompatActivity {

    DBController database;

    private User user = new User();

    Button bt_cadastrar_musica;
    Button bt_consultar_musicas;
    Button bt_cadastrar_evento;
    Button bt_consultar_eventos;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musico_main);

        database = new DBController(this);

        //Recuperando informação via intent
        id = getIntent().getStringExtra("id");
        Toast.makeText(this, "O id desse caboco é: "+id, Toast.LENGTH_SHORT).show();

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
                Intent i = new Intent(MusicoMainActivity.this, CadastroEventoActivity.class);
                i.putExtra("id",user.getId() );
                i.putExtra("name", user.getName());
                startActivity(i);

            }
        });


        bt_consultar_eventos = (Button) findViewById(R.id.bt_consultar_eventos);
        bt_consultar_eventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    @Override
    public void onBackPressed() { //Ação tomada ao pressionar o botão voltar
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setMessage("Deseja realmente sair?");
        adb.setNegativeButton("Não", null);
        adb.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        adb.show();
    }
}
