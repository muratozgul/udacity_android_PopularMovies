package com.udacity.mozgul.popularmovies.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.udacity.mozgul.popularmovies.Models.Movie;
import com.udacity.mozgul.popularmovies.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private static final String TAG = "MovieAdapter";
    private ArrayList<Movie> movies;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public MovieViewHolder(View itemView){
            super(itemView);
        }

        @Override
        public void onClick(View v) {
            int position = this.getAdapterPosition();
        }
    }


    public MovieAdapter(ArrayList<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //don't need final if not making a toast
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_movie, parent, false);

        MovieViewHolder mvh = new MovieViewHolder(view);

        return mvh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MovieViewHolder orderViewHolder, int position) {
        Movie movie = getMovie(position);

    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }

    public Movie getMovie(int position) {
        return this.movies.get(position);
    }
}
