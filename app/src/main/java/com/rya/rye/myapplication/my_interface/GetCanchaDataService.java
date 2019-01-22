package com.rya.rye.myapplication.my_interface;

import com.rya.rye.myapplication.model.Cancha;
import com.rya.rye.myapplication.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetCanchaDataService {
    @GET("api/cancha/")
    Call<List<Cancha>> getCanchaData();

    @GET("api/canchaById/")
    Call<List<Cancha>> getCanchaByIdData(
            @Query("id") String id
    );

    @GET("Login/login/")
    Call<List<Usuario>> getUsuarioData(
            @Query("dni") String dni,
            @Query("pass") String pass
    );
}
