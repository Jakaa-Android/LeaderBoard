package com.example.leaderboard;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;


public interface Api {
    @GET("api/hours")
     Call<List<Hero>> getHeroes();
    
    

}
