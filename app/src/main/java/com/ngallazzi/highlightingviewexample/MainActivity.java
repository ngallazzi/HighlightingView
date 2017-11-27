package com.ngallazzi.highlightingviewexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ngallazzi.highlightingview.HighlightingView;

public class MainActivity extends AppCompatActivity {
    private HighlightingView myEnlightingLayout;
    private HighlightingView myEnlightingLayoutWithProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myEnlightingLayout = (HighlightingView) findViewById(R.id.myEnlightingLayout);
        myEnlightingLayoutWithProgress = (HighlightingView)
                findViewById(R.id.myEnlightingLayoutWithProgress);
        myEnlightingLayoutWithProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!myEnlightingLayoutWithProgress.isHighlighted()){
                    new DownloadFilesTask().execute();
                }else{
                    myEnlightingLayoutWithProgress.setHighlighted(false);
                }
            }
        });
    }

    private class DownloadFilesTask extends AsyncTask<Void, Void, Long> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            myEnlightingLayoutWithProgress.showProgressBar();
        }

        protected Long doInBackground(Void... urls) {
            long totalSize = 0;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return totalSize;
        }

        protected void onPostExecute(Long result) {
            myEnlightingLayoutWithProgress.hideProgressBar();
            myEnlightingLayoutWithProgress.setHighlighted(true);
        }
    }
}
