package com.udacity.mozgul.popularmovies.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.mozgul.popularmovies.Adapters.MovieAdapter;
import com.udacity.mozgul.popularmovies.DAO.IMovieCallback;
import com.udacity.mozgul.popularmovies.DAO.MovieDAO;
import com.udacity.mozgul.popularmovies.Models.Movie;
import com.udacity.mozgul.popularmovies.R;

import java.util.ArrayList;


public class MovieGridFragment extends Fragment implements IMovieCallback {
    private String TAG = "MovieGridFragment";

    private static final String KEY = "movies";

    private RecyclerView moviesRecyclerView;
    private MovieAdapter moviesAdapter;
    private RecyclerView.LayoutManager moviesLayoutManager;

    private Context context;


    public MovieGridFragment() {
        // Required empty public constructor
    }

    public static MovieGridFragment newInstance(ArrayList<Movie> movies) {
        MovieGridFragment fragment = new MovieGridFragment();

        return fragment;
    }


    //############################
    //IOrderCallback Interface Methods
    //############################

    @Override
    public void findPopularMoviesCb(ArrayList<Movie> movies) {
        this.moviesAdapter.setMovies(movies);
        this.moviesAdapter.notifyDataSetChanged();
    }


    //############################
    //Override methods
    //############################

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movie_grid, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        context = getActivity();

        moviesRecyclerView = (RecyclerView) view.findViewById(R.id.moviesRecyclerView);

        moviesLayoutManager = new GridLayoutManager(context, 2);
        moviesRecyclerView.setLayoutManager(moviesLayoutManager);

        moviesAdapter = new MovieAdapter(context);
        moviesRecyclerView.setAdapter(moviesAdapter);

        MovieDAO.findAllPopular(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }
}
