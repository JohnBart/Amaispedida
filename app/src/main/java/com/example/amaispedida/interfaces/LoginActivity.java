package com.example.amaispedida.interfaces;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amaispedida.R;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button bt_entrar = (Button) findViewById(R.id.button_login);
        bt_entrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tLogin = (TextView) findViewById(R.id.login_editText);
                TextView tPassword = (TextView) findViewById(R.id.password_editText);
                String login = tLogin.getText().toString();
                String password = tPassword.getText().toString();

                if(login.equals("espectador")&&password.equals("espectador123")){
                    alert("Usuário espectador entrou");
                }else if(login.equals("musico")&&password.equals("musico123")){
                    alert("Usuário musico entrou");
                }else{
                    alert("Usuário não cadastrado");
                }
            }
        });
    }

    private void alert(String s){
        Toast.makeText(this, s , Toast.LENGTH_LONG).show();
    }

}

