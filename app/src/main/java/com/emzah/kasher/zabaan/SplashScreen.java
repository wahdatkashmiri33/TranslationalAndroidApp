package com.emzah.kasher.zabaan;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config=new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(5000)

                //.withBackgroundColor(Color.parseColor("#C62828"))
               .withBackgroundResource(R.drawable.back)
               .withFooterText("Copyright 2017");



        config.getFooterTextView().setTextColor(Color.WHITE);



        View view =config.create();
        setContentView(view);

    }
}
