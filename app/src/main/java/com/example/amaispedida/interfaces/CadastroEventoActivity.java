package com.example.amaispedida.interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.amaispedida.R;
import com.example.amaispedida.database.DatabaseHelper;

public class CadastroEventoActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper = new DatabaseHelper(this);

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
                EditText nome_evento = (EditText) findViewById(R.id.et_nome_evento_cadastro);
                EditText local = (EditText) findViewById(R.id.et_local_evento_cadastro);
                EditText data = (EditText) findViewById(R.id.et_data_evento_cadastro);
                EditText hora = (EditText) findViewById(R.id.et_hora_evento_cadastro);

                String nome_eventost = nome_evento.getText().toString();
                String localst = local.getText().toString();
                String datast = data.getText().toString();
                String horast = hora.getText().toString();

                if(nome_eventost.isEmpty()||localst.isEmpty()||datast.isEmpty()||horast.isEmpty()) {
                    alert("Campo em branco, favor preencher todo o formulário");
                }



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
    public void alert(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
