package com.example.amaispedida.interfaces;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.amaispedida.R;
import com.example.amaispedida.database.DBController;
import com.example.amaispedida.database.DatabaseHelper;
import com.example.amaispedida.domain.User;

/**
 * Created by João Paulo Bart Dias on 20/07/2017.
 */

public class CadastroUserActivity extends AppCompatActivity {

    //DatabaseHelper database = new DatabaseHelper(this);
    DBController database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_user);

        database = new DBController(this);

        Button btsignup = (Button) findViewById(R.id.signup_button);
        btsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name = (EditText) findViewById(R.id.name_input_edittext);
                EditText login = (EditText) findViewById(R.id.login_input_edittext);
                EditText password1 = (EditText) findViewById(R.id.password_input_edittext1);
                EditText password2 = (EditText) findViewById(R.id.password_input_edittext2);

                String namest = name.getText().toString();
                String loginst = login.getText().toString();
                String password1st = password1.getText().toString();
                String password2st = password2.getText().toString();
                String profilest = null;

                RadioGroup profilerg = (RadioGroup) findViewById(R.id.profile_radiogroup);
                switch (profilerg.getCheckedRadioButtonId()){
                    case R.id.espectador_radiobutton:
                        profilest = "espectador";
                        break;
                    case R.id.musico_radiobutton:
                        profilest = "musico";
                        break;
                }


                if(namest.isEmpty()||loginst.isEmpty()||password1st.isEmpty()||password2st.isEmpty()){
                    alert("Campo em branco, favor preencher todo o formulário");
                }else if(database.isLoginInDatabase(loginst)){
                        alert("Login indisponivel, escolher outro");
                } else if (!password1st.equals(password2st)) {
                    alert("Senhas diferentes");
                } else {
                    User user = new User();
                    user.setName(namest);
                    user.setLogin(loginst);
                    user.setPassword(password1st);
                    user.setProfile(profilest);

                    database.insertUser(user);
                    alert("Usuário cadastrado");
                }

            }
        });
    }

    public void alert(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
