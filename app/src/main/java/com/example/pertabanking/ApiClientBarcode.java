package com.example.pertabanking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientBarcode {
    public static final String BASE_URL="https://script.google.com/macros/s/AKfycbxb9T7UCa37rT96P9h_ubedR2E5NvxvFZFBWwOR3bHrqsTmuxs/";
    public static Retrofit retrofitbar;
    public static Retrofit getApiClient(){
        if (retrofitbar==null){
            retrofitbar=new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitbar;
    }
}
