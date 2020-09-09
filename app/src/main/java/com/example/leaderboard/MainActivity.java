package com.example.leaderboard;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import Fragments.SkillIqFragment;
import Fragments.TopLearnersFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private ApiClient mApiClient;

   private Toolbar toolbar;
    private TabLayout tabLayout;
   private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Api api = ApiClient.buildService(Api.class);
        Call<List<Hero>> heroes = api.getHeroes();
        heroes.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> body=response.body();
                if(body !=null){
                    for(Hero hero:body){
                        Log.d("TAG","onRensponse"+hero.getName() +":"+hero.getHours());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Log.d("TAG","onFailure");


            }
        });


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
       setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

   private void setupViewPager(ViewPager viewPager) {
      ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
       adapter.addFragment(new TopLearnersFragment(), "Learning Leaders");
      adapter.addFragment(new SkillIqFragment(), "Skill IQ Leaders");
    viewPager.setAdapter(adapter);

    }




}