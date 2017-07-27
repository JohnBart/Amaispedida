package com.example.amaispedida.interfaces;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amaispedida.R;
import com.example.amaispedida.database.DBController;

public class LoginActivity extends AppCompatActivity {

    private TextView tName;
    private TextView tLogin;
    private TextView tPassword;
    private String name;
    private String login;
    private String password;
    Button bt_login;
    Button bt_signup;
    DBController database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        database = new DBController(this);

        bt_login = (Button)findViewById(R.id.button_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
            TextView tLogin = (TextView) findViewById(R.id.login_editText);
            TextView tPassword = (TextView) findViewById(R.id.password_editText);
            String login = tLogin.getText().toString();
            String password = tPassword.getText().toString();
            String passAux = database.searchPass(login);

            if (password.equals(passAux)) {
                String profileAux = database.searchProfile(login);
                long id = database.returnIdUser(login);

                Intent intent;
                if (profileAux.equals("espectador")) {
                    intent = new Intent(LoginActivity.this, EspectadorMainActivity.class);
                } else {
                    intent = new Intent(LoginActivity.this, MusicoMainActivity.class);
                }
                intent.putExtra("id", id);
                startActivity(intent);
                finish();
            } else {
                alert("Login ou senha não conferem");
        }
    }
}
        );
        bt_signup = (Button) findViewById(R.id.button_signup);
        bt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, CadastroUserActivity.class);
                startActivity(i);
            }
        });
    }


    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }

}

