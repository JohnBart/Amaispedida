package com.example.amaispedida.interfaces;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.amaispedida.R;
import com.example.amaispedida.database.DatabaseHelper;
import com.example.amaispedida.domain.User;

/**
 * Created by João Paulo Bart Dias on 20/07/2017.
 */

public class CadastroActivity extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_activity);
    }

    public void onSignUpClick(View v){
        if(v.getId()==R.id.signup_button){

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



            if(!password1st.equals(password2st)){
                Toast.makeText(this, "Senhas diferentes", Toast.LENGTH_LONG).show();
            }else{
                User user = new User();
                user.setName(namest);
                user.setLogin(loginst);
                user.setPassword(password1st);
                user.setProfile(profilest);

                helper.insertUser(user);
                Toast.makeText(this, "Usuário cadastrado", Toast.LENGTH_SHORT).show();
            }



        }
    }
}
