package com.udacity.mozgul.popularmovies.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.udacity.mozgul.popularmovies.Adapters.MovieAdapter;
import com.udacity.mozgul.popularmovies.DAO.IMovieCallback;
import com.udacity.mozgul.popularmovies.DAO.MovieDAO;
import com.udacity.mozgul.popularmovies.Models.Movie;
import com.udacity.mozgul.popularmovies.R;

import java.util.ArrayList;


public class MovieGridFragment extends Fragment implements IMovieCallback {
    private String TAG = "MovieGridFragment";

    private static final String KEY = "movies";

    private ArrayList<Movie> movies;

    private RecyclerView moviesRecyclerView;
    private RecyclerView.Adapter moviesAdapter;
    private RecyclerView.LayoutManager moviesLayoutManager;

    private Context context;


    public MovieGridFragment() {
        // Required empty public constructor
    }

    public static MovieGridFragment newInstance(ArrayList<Movie> movies) {
        MovieGridFragment fragment = new MovieGridFragment();
//        Bundle bundle = new Bundle();
//        bundle.putParcelableArrayList(KEY, movies);
//        fragment.setArguments(bundle);

        return fragment;
    }


    //############################
    //IOrderCallback Interface Methods
    //############################

    @Override
    public void findPopularMoviesCb(ArrayList<Movie> movies) {
        this.movies.addAll(movies);
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
//        MovieDAO.findAllPopular(this);

//        Bundle bundle = getArguments();
//        movies = bundle.getParcelableArrayList(KEY);
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

        //initialize movies to empty list
        movies = new ArrayList<Movie>();
        movies.add(new Movie(123L, "Indiana Jones"));
        movies.add(new Movie(124L, "Indiana Jones2"));
        movies.add(new Movie(125L, "Indiana Jones3"));

        moviesRecyclerView = (RecyclerView) view.findViewById(R.id.moviesRecyclerView);

        moviesLayoutManager = new LinearLayoutManager(context);
        moviesRecyclerView.setLayoutManager(moviesLayoutManager);

        moviesAdapter = new MovieAdapter(movies, context);
        moviesRecyclerView.setAdapter(moviesAdapter);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }
}
