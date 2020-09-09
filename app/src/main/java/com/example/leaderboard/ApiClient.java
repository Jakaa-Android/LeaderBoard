package com.example.leaderboard;

import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private ApiClient(){}
    private static final String BASE_URL = "https://gadsapi.herokuapp.com";
    private static Retrofit.Builder sBuilder=new Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit mRetrofit = sBuilder.build();
    public static <S> S buildService(Class<S> serviceType){
        return mRetrofit.create(serviceType);
    }


    ////}


}
