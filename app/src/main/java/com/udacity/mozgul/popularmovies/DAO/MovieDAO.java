package com.udacity.mozgul.popularmovies.DAO;


import android.net.Uri;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.reflect.TypeToken;
import com.udacity.mozgul.popularmovies.Application.App;
import com.udacity.mozgul.popularmovies.Models.Movie;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    private static final String TAG = "MovieDAO";

    private static String apiBaseUrl = App.getInstance().getApiUrl();


    //############################
    //URL building methods
    //############################

    public static String getPopularMoviesUrl(){
        String uri = Uri.parse(apiBaseUrl)
                .buildUpon()
                .appendPath("discover")
                .appendPath("movie")
                .appendQueryParameter("api_key", App.getInstance().getApiKey())
                .appendQueryParameter("sort_by", "popularity.desc")
                .build()
                .toString();

        Log.d(TAG, uri);

        return uri;
    }


    //############################
    //API GET methods
    //############################

    public static void findAllPopular(final IMovieCallback cbInterface) {
        // Build url
        String url = getPopularMoviesUrl();

        // Create new response listener
        Response.Listener<ArrayList<Movie>> responseListener = new Response.Listener<ArrayList<Movie>>() {
            @Override
            public void onResponse(ArrayList<Movie> response) {
                Log.d(TAG, response.toString());
                cbInterface.findPopularMoviesCb(response);
            }
        };

        // Create new response error listener
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Server Request Error: " + error.getMessage());
            }
        };

        // Make GSON Object request
        Type listType = new TypeToken<List<Movie>>() {}.getType();
        GsonRequest<ArrayList<Movie>> gsonRequest =
                new GsonRequest<ArrayList<Movie>>(url, listType, responseListener, errorListener);

        // Add request to (global) request queue
        App.getInstance().addToRequestQueue(gsonRequest, TAG);
    }

}
