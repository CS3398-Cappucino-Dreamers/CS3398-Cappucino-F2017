package com.example.ben.fitordie.Login.users.progresscircle;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.example.ben.fitordie.Login.customviews.CircleProgressBar;
import com.example.ben.fitordie.R;

/**
 * Created by The Dough Boys on 11/6/2017.
 */

/**
 * Decorator pattern??
 */
public class ProgressCircle {

    private CircleProgressBar circleProgressBar;

    public ProgressCircle(View view){
        circleProgressBar = (CircleProgressBar)view;
    }

    public void animate(final Activity activity){

        new Thread(new Runnable() {
            @Override
            public void run() {
                int b = 0;
                for(int i = 0; i < 70; i++) {
                    final int a = i;
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            circleProgressBar.setProgress(a);
                        }
                    });
                    try {

                        Thread.currentThread().sleep(50);
                        if(a >= 50){
                            Thread.currentThread().sleep(b+=5);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
