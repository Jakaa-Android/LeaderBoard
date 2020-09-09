package com.example.leaderboard;

import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static void client(){
        Retrofit retrofit= new Retrofit.Builder()
               .baseUrl("https://gadsapi.herokuapp.com/api/ ")
               .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api= retrofit.create(Api.class);

        Call<List<Hero>> call=api.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            private TextView textViewResult;
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code"+response.code());
                    return;
                }
                List<Hero> heroes=response.body();
                for (Hero hero: heroes){
                    String content="";
                    content += "name"+hero.getName()+"\n";
                    content += "hours"+hero.getHours()+"\n";
                    content += "country"+hero.getCountry()+"\n";
                    content += "badgeUrl"+hero.getBadgeUrl()+"\n\n";
                    textViewResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                textViewResult.setText(t.getMessage());

            }
        });

    }


}
