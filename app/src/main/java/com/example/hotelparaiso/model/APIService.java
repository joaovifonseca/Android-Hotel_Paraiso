package com.example.hotelparaiso.model;

import com.example.hotelparaiso.model.Usuario;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    @GET("login.php?")
    Call<Usuario> logar(@Query("email_usu") String login, @Query("senha_usu") String senha);

    @POST("aluga.php?")
    Call <ArrayList<Reserva>> reservas(@Query("id_usu") String idUsu);
}
