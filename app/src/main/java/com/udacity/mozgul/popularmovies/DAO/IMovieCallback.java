package com.udacity.mozgul.popularmovies.DAO;


import com.udacity.mozgul.popularmovies.Models.Movie;

import java.util.ArrayList;

public interface IMovieCallback {

    public void findPopularMoviesCb(ArrayList<Movie> movies);
}
