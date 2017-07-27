package com.example.amaispedida.interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amaispedida.R;
import com.example.amaispedida.database.DBController;
import com.example.amaispedida.domain.Musica;

public class CadastroMusicaActivity extends AppCompatActivity {

    DBController database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_musica);

        database = new DBController(this);

        Button bt_salvar = (Button) findViewById(R.id.bt_salvar_musica_cadastro);
        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText ed_musica = (EditText) findViewById(R.id.ed_musica_cadastro_musica);
                EditText ed_compositor = (EditText) findViewById(R.id.ed_compositor_cadastro_musica);

                String musicast = ed_musica.getText().toString();
                String compositorst = ed_compositor.getText().toString();

                long id_artista = 1;

                if(musicast.isEmpty()||compositorst.isEmpty()){
                    alert("Campo em branco, favor preencher todo o formulário");
                }else if(database.isMusicInDatabase(musicast, compositorst, id_artista)){
                    alert("Musica já cadastrada");
                }else{
                    Musica musica = new Musica();
                    musica.setMusica(musicast);
                    musica.setCompositor(compositorst);
                    database.insertMusica(musica, id_artista);
                    alert("Musica cadastrada");
                }
            }
        });



    }
    public void alert(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
