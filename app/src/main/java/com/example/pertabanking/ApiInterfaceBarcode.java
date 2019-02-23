package com.example.pertabanking;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterfaceBarcode {
    @FormUrlEncoded
    @POST("exec")
    Observable<SuccessDao> postUpload(
            @Field("id") String id,
            @Field("nama") String nama,
            @Field("alamat") String alamat,
            @Field("email") String email,
            @Field("jenis_kelamin") String jenis_kelamin,
            @Field("foto") String foto,
            @Field("sheet") String sheet);
}
