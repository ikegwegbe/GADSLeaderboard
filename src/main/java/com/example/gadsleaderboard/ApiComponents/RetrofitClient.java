package com.example.gadsleaderboard.ApiComponents;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;

    public static final String BASE_URL = "https://gadsapi.herokuapp.com/";
    public static final String GOOGLE_FORM_URL = "https://docs.google.com/forms/u/0/d/e/";
    private static RetrofitClient instance = null;

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static Retrofit postRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(GOOGLE_FORM_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public <S> S buildService(Class<S> serviceType) {
        return instance.retrofit.create(serviceType);
    }

    public static void destroyInstance(){
        instance = null;
    }

}

