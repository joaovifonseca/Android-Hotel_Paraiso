package com.example.hotelparaiso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hotelparaiso.model.APIService;
import com.example.hotelparaiso.model.Reserva;
import com.example.hotelparaiso.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText Login;
    private EditText Senha;
    private Button Logar;
    private Retrofit retrofit;
    private Retrofit retrofits;
    String tipoLogin = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = findViewById(R.id.editLogin);
        Senha = findViewById(R.id.editSenha);
        Logar = findViewById(R.id.buttonLogar);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://hotelparaiso.atwebpages.com/WebService/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        try {
            Logar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        if (validaCampo(Login) && validaCampo(Senha)) {
                            Toast.makeText(getApplicationContext(), "Preencha todos os campos", Toast.LENGTH_LONG).show();
                        } else if (validaCampo(Login)) {
                            Toast.makeText(getApplicationContext(), "Preencha o login", Toast.LENGTH_LONG).show();
                        } else if (validaCampo(Senha)) {
                            Toast.makeText(getApplicationContext(), "Preencha a senha", Toast.LENGTH_LONG).show();
                        } else {

                            APIService apiService = retrofit.create(APIService.class);
                            Call<Usuario> call = apiService.logar(Login.getText().toString(), Senha.getText().toString());

                            call.enqueue(new Callback<Usuario>() {
                                @Override
                                public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                                    if (response.isSuccessful()) {
                                        if(response.body() != null) {
                                            Usuario usu = response.body();
                                            Intent i = new Intent(getApplicationContext(), menu.class);
                                            i.putExtra("IdUsuario", usu.getID_USU());
                                            i.putExtra("NomeUsuario", usu.getNOME_USU());
                                            i.putExtra("EmailUsuario", usu.getEMAIL_USU());
                                            startActivity(i);
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Não foi possível realizar o login", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }

                                @Override
                                public void onFailure(Call<Usuario> call, Throwable t) {
                                    Toast.makeText(getApplicationContext(), "Não foi possível realizar o login", Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    }
                    catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Não foi possível realizar o login", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Não foi possível realizar o login", Toast.LENGTH_SHORT).show();
        }


    }
    public boolean validaCampo(EditText edits) {
        if(TextUtils.isEmpty(edits.getText().toString().trim()))
        {
            return true;
        } else {
            return false;
        }
    }


}


