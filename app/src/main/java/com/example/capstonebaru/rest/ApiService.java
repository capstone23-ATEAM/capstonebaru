package com.example.capstonebaru.rest;

import com.example.capstonebaru.model.HotelModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    public static String URLIMAGE = "https://dev.farizdotid.com/api/halopwk/gambar/hotel/";
    @GET("hotel")
    Call<HotelModel> getData();
}
