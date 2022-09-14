package com.example.webservice;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface CEPService {
    @GET("{cep}/json/")
    Call<CEP> recuperarCEP(@Path("cep") String cep);
}
