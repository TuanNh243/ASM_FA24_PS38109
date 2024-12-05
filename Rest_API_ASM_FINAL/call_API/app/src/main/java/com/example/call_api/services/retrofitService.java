package com.example.call_api.services;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.Header;
import retrofit2.http.POST;

import com.example.call_api.Models.resProduct;
import com.example.call_api.Models.reslogin;
import com.example.call_api.Models.reqlogin;

public interface retrofitService {
//    public static String BASE_URL = "https://md19301-1y4e.onrender.com/";
    public static String BASE_URL = "https://asm-fa24.onrender.com";
    // đăng nhập
    @POST("users/login")
    Call<reslogin> login(@Body reqlogin reqlogin);

    // lấy danh sách
    @GET("vouchers/")
    Call<resProduct>  GetAllProduct(@Header("Authorization") String token);
}
