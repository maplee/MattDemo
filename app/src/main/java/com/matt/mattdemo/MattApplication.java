package com.matt.mattdemo;

import android.app.Application;
import android.util.Log;

public class MattApplication extends Application {

    private static final String TAG = "MattApplication";
    @Override
    public void onCreate() {
        super.onCreate();

        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable throwable) {
                Log.e(TAG, "uncaughtException: ",throwable);
            }
        });
    }
}
