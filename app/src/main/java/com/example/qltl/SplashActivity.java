package com.example.qltl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    private static final String FIRST_INSTALL = "FIRST_INSTALL";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        StartShareReferences startShareReferences = new StartShareReferences(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //kiem tra sharerefernces co data chua
                if(startShareReferences.getBoolleanValue(FIRST_INSTALL)){
                    //main
                    startActivity(MainActivity.class);
                }else{
                    //onboarding
                    startActivity(OnboardingActivity.class);
                    //sau khi da cai thi bo data vao share, lan sau se chay main
                    startShareReferences.putBooleanStart(FIRST_INSTALL, true);
                }
            }
        }, 2000);
    }

    private void startActivity(Class<?> cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
        finish();
    }
}