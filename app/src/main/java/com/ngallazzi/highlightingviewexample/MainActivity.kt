package com.ngallazzi.highlightingviewexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ngallazzi.highlightingview.HighlightingView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * HighlightingView
 * Created by Nicola on 11/5/2018.
 * Copyright © 2018 Zehus. All rights reserved.
 */


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myEnlightingLayoutWithProgress.initExecuteBackgroundTaskOnClickListener()
        myEnlightingLayoutWithProgressTwo.initExecuteBackgroundTaskOnClickListener()
    }


    private fun startHighlightingTask(view: HighlightingView) {
        view.showProgressBar()
        doAsync {
            //Execute all the lon running tasks here
            Thread.sleep(2000)
            uiThread {
                //Update the UI thread here
                view.hideProgressBar()
                view.isHighlighted = true
            }
        }
    }

    private fun HighlightingView.initExecuteBackgroundTaskOnClickListener() {
        this.setOnClickListener {
            if (!this.isHighlighted) {
                startHighlightingTask(this)
            } else {
                this.isHighlighted = false
            }
        }
    }
}
