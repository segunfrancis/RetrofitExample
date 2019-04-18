package com.example.computer.retrofitexample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Retrofit retrofit = null;

    private static ApiInterface getClient() {
        // change your base URL
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl("https://mobileappdatabase.in/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        // Creating object for our interface
        ApiInterface api = retrofit.create(ApiInterface.class);
        return api;
    }
}
