package com.udacity.mozgul.popularmovies.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.udacity.mozgul.popularmovies.Application.App;

import java.io.Serializable;


public class Movie implements Serializable, Parcelable {
    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("overview")
    private String overview;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("popularity")
    private float popularity;

    @SerializedName("vote_average")
    private float voteAverage;


    //############################
    //Constructors
    //############################

    public Movie(long id, String overview, float popularity, String posterPath,
                 String releaseDate, String title, float voteAverage) {
        this.id = id;
        this.overview = overview;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.title = title;
        this.voteAverage = voteAverage;
    }

    public Movie(long id, String title) {
        this.id = id;
        this.title = title;
        this.overview = "Placeholder Overview";
        this.posterPath = "/fYzpM9GmpBlIC893fNjoWCwE24H.jpg";
    }

    public Movie(){}


    //############################
    //Getters & Setters
    //############################

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getPosterUrl() {
        //http://image.tmdb.org/t/p/w500/fYzpM9GmpBlIC893fNjoWCwE24H.jpg
        StringBuilder url = new StringBuilder()
                .append(App.getInstance().getImageApiUrl())
                .append(this.posterPath);

        return url.toString();
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }


    //############################
    //Parcelable Interface Methods
    //############################

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeLong(id);
        out.writeString(title);
        out.writeString(posterPath);
        out.writeString(overview);
        out.writeString(releaseDate);
        out.writeFloat(popularity);
        out.writeFloat(voteAverage);
    }

    // All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    // constructor that takes a Parcel and gives you an object populated with it's values
    private Movie(Parcel in) {
        //read in the same order as writes
        this.id = in.readInt();
        this.title = in.readString();
        this.posterPath = in.readString();
        this.overview = in.readString();
        this.releaseDate = in.readString();
        this.popularity = in.readFloat();
        this.voteAverage = in.readFloat();
    }


    //############################
    //Other Methods
    //############################

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.title);
        sb.append(" (");
        sb.append(this.releaseDate);
        sb.append("): ");
        sb.append(this.overview);
        return sb.toString();
    }

}
