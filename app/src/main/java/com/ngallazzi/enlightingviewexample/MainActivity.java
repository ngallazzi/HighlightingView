package com.ngallazzi.enlightingviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ngallazzi.enlightinglayout.EnlightingLayout;

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
    }
}
