package com.ngallazzi.enlightingviewexample;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ngallazzi.enlightinglayout.EnlightingLayout;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private EnlightingLayout myEnlightingLayoutK,myEnlightingLayoutB,myEnlightingLayoutG,myEnlightingLayoutT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myEnlightingLayoutK = (EnlightingLayout) findViewById(R.id.myEnlightingLayoutK);
        myEnlightingLayoutB = (EnlightingLayout) findViewById(R.id.myEnlightingLayoutB);
        myEnlightingLayoutG = (EnlightingLayout) findViewById(R.id.myEnlightingLayoutG);
        myEnlightingLayoutT = (EnlightingLayout) findViewById(R.id.myEnlightingLayoutT);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnlightingLayout myView = (EnlightingLayout) v;
                if (!myView.isEnlighted()){
                    myView.setEnlighted(true);
                }else{
                    myView.setEnlighted(false);
                }
            }
        };
        myEnlightingLayoutK.setOnClickListener(clickListener);
        myEnlightingLayoutB.setOnClickListener(clickListener);
        myEnlightingLayoutG.setOnClickListener(clickListener);
        myEnlightingLayoutT.setOnClickListener(clickListener);

        TimerTask timerTask = new ShowProgressBarTask();
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, TimeUnit.SECONDS.toMillis(5));
    }

    class ShowProgressBarTask extends TimerTask {
        Handler handler = new Handler();
        @Override
        public void run() {
            try {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        myEnlightingLayoutT.setEnlighted(false);
                        myEnlightingLayoutT.showProgressBar();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                myEnlightingLayoutT.setEnlighted(true);
                                myEnlightingLayoutT.hideProgressBar();
                            }
                        },2500);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
