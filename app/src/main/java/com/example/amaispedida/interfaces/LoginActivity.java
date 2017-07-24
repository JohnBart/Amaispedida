package com.example.amaispedida.interfaces;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amaispedida.R;
import com.example.amaispedida.database.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void click(View v){
        if(v.getId()==R.id.button_login){
            TextView tLogin = (TextView) findViewById(R.id.login_editText);
            TextView tPassword = (TextView) findViewById(R.id.password_editText);
            String login = tLogin.getText().toString();
            String password = tPassword.getText().toString();
            String passAux = helper.searchPass(login);;

            if(password.equals(passAux)){
                String profileAux = helper.searchProfile(login);
                Intent intent;
                if(profileAux.equals("espectador")){
                   intent = new Intent(this, EspectadorMainActivity.class);
                }else{
                   intent = new Intent(this, MusicoMainActivity.class);
                }
                intent.putExtra("login", login);
                startActivity(intent);
            }else{
                alert( "Login ou senha não conferem");
            }

        }else if(v.getId()==R.id.button_signup){
            Intent i = new Intent(LoginActivity.this, CadastroActivity.class);
            startActivity(i);
        }
    }

    private void alert(String s){
        Toast.makeText(this, s , Toast.LENGTH_LONG).show();
    }

}

