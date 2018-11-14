package com.example.lara.movies.networkUtils;

import com.example.lara.movies.pojos.Movie;

import java.util.ArrayList;

/**
 * Created by Lara on 4/16/2018.
 */

public class MovieNetwork {


    public static void loadMovieListByGenre(String genre, OnMovieListByGenreFinished onMovieListByGenreFinished) {

        boolean isSuccess = true;

        if (isSuccess) {
            onMovieListByGenreFinished.onMovieListRetrievedSuccessfully(new ArrayList<Movie>());
        } else {
            onMovieListByGenreFinished.onMovieListRetrievedFailed("");
        }
    }



    public static interface OnMovieListByGenreFinished {
        public void onMovieListRetrievedSuccessfully(ArrayList<Movie> movieArrayList);

        public void onMovieListRetrievedFailed(String friendlyErrorMessage);
    }
}
