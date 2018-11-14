package com.example.lara.movies;

import android.app.Application;

import com.example.lara.movies.networkUtils.volleyStuff.VolleyInstance;

/**
 * Created by Lara on 4/16/2018.
 */

public class AppController extends Application {
    private static AppController mInstance;


    public static synchronized AppController getmInstance() {
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        VolleyInstance.getInstance(this);
    }


}

