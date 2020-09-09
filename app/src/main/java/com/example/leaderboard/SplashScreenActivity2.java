package com.example.leaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity2 extends AppCompatActivity {
    private Handler mHandler;
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        mRunnable=new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        };
        mHandler = new Handler();
        mHandler.postDelayed(mRunnable,3000);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mHandler != null && mRunnable!=null)
        mHandler.removeCallbacks(mRunnable);
    }
}