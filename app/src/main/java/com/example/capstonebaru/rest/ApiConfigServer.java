package com.example.capstonebaru.rest;

public class ApiConfigServer {
    public static final String URL_API = "https://dev.farizdotid.com/api/purwakarta/";

    public static ApiService getApiService(){
        return RetrofitApi.getClient(URL_API).create(ApiService.class);
    }
}
