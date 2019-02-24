package com.example.pertabanking;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterfaceRekening {
    @FormUrlEncoded
    @POST("exec")
    Call<Rekening> postUpload(
            @Field("action") String action,
            @Field("nama") String nama,
            @Field("noreg") String noreg,
            @Field("uang") String uang,
            @Field("tableName") String tableName
    );


    @GET("exec")
    Call<Rekening> getRekening(@Query("noreg") String noreg);

    @FormUrlEncoded
    @POST("exec")
    Call<Rekening> putUpload(
            @Field("action") String action,
            @Field("noreg") String noreg,
            @Field("bbm") String bbm,
            @Field("liter") int liter,
            @Field("tableName") String tableName
    );

}
