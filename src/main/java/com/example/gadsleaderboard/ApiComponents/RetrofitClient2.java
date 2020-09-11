package com.example.gadsleaderboard.ApiComponents;

import com.example.gadsleaderboard.ApiComponents.RetrofitClient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient2 {
    private static Retrofit retrofit;


    public static final String GOOGLE_FORM_URL = "https://docs.google.com/forms/u/0/d/e/";
    private static RetrofitClient instance = null;

    public static Retrofit postRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(GOOGLE_FORM_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public static void destroyInstance(){
        instance = null;
    }

}


