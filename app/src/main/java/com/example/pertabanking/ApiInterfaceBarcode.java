package com.example.pertabanking;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterfaceBarcode {
    @FormUrlEncoded
    @POST("exec")
    Call<Barcode> postUpload(
            @Field("noreg") String noreg,
            @Field("bbm") String bbm,
            @Field("liter") String liter
            );

    @FormUrlEncoded
    @GET("exec")
    Call<Barcode> getBarcode(
            @Field("action") String action,
            @Field("tableName") String tableName
            );

    @FormUrlEncoded
    @GET("exec")
    Call<Barcode> putBarcode(
            @Field("action") String action,
            @Field("noreg") String noreg,
            @Field("tableName") String tableName
            );
}
