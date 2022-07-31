package com.example.movieapp.retrofit;

public class ApiUtility {

    public static ApiInterface getApi(){

        return RetrofitClient.getInstanceWithLogging().create(ApiInterface.class);
    }
}
