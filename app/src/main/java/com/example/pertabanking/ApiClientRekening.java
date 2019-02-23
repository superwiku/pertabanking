package com.example.pertabanking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientRekening {
    private static final String BASE_URL="https://script.google.com/macros/s/AKfycbwRHXNh3LiCF8DN6x35_mazWxBClkFLbbxCqSorxeqi4lE-vb0/";
    public static Retrofit retrofit;
    public static Retrofit getApiClient(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
