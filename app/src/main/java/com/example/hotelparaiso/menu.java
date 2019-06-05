package com.example.hotelparaiso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotelparaiso.model.APIService;
import com.example.hotelparaiso.model.Reserva;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView NomeUsu;
    private TextView EmailUsu;
    private Retrofit retrofits;
    private List<Reserva> listaTarefas = new ArrayList<>();
    private List<String> listString;

    private ArrayAdapter mAdapter;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView = findViewById(R.id.Lista);

        retrofits = new Retrofit.Builder()
                .baseUrl("http://hotelparaiso.atwebpages.com/WebService/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        try {
            APIService service = retrofits.create(APIService.class);
            Intent i = getIntent();
            Bundle b = i.getExtras();
            Call<ArrayList<Reserva>> teste = service.reservas(b.get("IdUsuario").toString());
            teste.enqueue(new Callback<ArrayList<Reserva>>() {
                @Override
                public void onResponse(Call<ArrayList<Reserva>> call, Response<ArrayList<Reserva>> response) {
                    if(response.isSuccessful()) {
                        ArrayList<Reserva> listaDeReservas = response.body();
                        ArrayAdapter arrayAdapter =
                                new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, listaDeReservas);

                        listView.setAdapter(arrayAdapter);
                    } else {
                        Toast.makeText(getApplicationContext(), " Não existem reservas cadastradas", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<Reserva>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Erro interno" + t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.d("Erro busca api",t.getMessage());
                }
            });
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), " Erro" + e.getMessage(), Toast.LENGTH_LONG).show();
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);

        Intent i = getIntent();
        Bundle b = i.getExtras();


        NomeUsu = findViewById(R.id.textNomeUsu);
        EmailUsu = findViewById(R.id.textEmailUsu);
        if(b != null) {
            String nome = b.get("NomeUsuario").toString();
            String email = b.get("EmailUsuario").toString();
            NomeUsu.setText(nome);
            EmailUsu.setText(email);


        }

        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_send) {
            finish();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
