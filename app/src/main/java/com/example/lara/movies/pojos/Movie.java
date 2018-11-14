package com.example.lara.movies.pojos;

import java.util.ArrayList;

/**
 * Created by Lara on 4/16/2018.
 */

public class Movie {
    public String movieName;


    public static ArrayList<Movie> getDummyMovieNames() {

        ArrayList<Movie> movieArrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Movie movie = new Movie();
            movie.movieName = "movie #" + i;
            movieArrayList.add(movie);
        }

        return movieArrayList;
    }

}
