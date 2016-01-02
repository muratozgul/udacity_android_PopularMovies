package com.udacity.mozgul.popularmovies.Application;


import android.app.Application;
import android.content.res.Configuration;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class App extends Application {
    public static final String TAG = "FoodieApp";

    private static App singleton;

    private RequestQueue mRequestQueue;

    private final String movieApiUrl = "https://api.themoviedb.org/3";

    private String apiKey;


    //############################
    //Getters
    //############################

    public String getApiUrl() {
        return movieApiUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public static synchronized App getInstance(){
        return singleton;
    }


    //############################
    //Volley methods
    //############################

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // tag is used for cancelling (a group of reqs) if needed
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }


    //############################
    //Override
    //############################

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        apiKey = getApiKey();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
