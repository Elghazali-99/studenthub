package com.esisba.studenthub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    //-------------- Animation- wait scene---------------------
    Handler mHandler;
    Runnable mRunnable;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img= findViewById(R.id.logo);
                img.animate().alpha(3000).setDuration(0);
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dsp = new Intent(MainActivity.this,LogIn.class);
                startActivity(dsp);
                finish();
            }
        },3000);
    }
}
