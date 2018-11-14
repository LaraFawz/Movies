package com.example.lara.movies.networkUtils;

/**
 * Created by Lara on 4/16/2018.
 */

public class UrlBuilder {
    private static final String API_KEY = "cef87e25e9835e78f4fdcc225d9d3138";
    public static final String BASE_URL = "http://api.themoviedb.org/3/";

    public static final String GET_MOVIES_GENRE_LIST = "genre/movie/list";
    public static final String GET_MOVIES_LIST = "";


    /**
     * @return
     */
    public static String getGenreListURL() {
        String url = BASE_URL + GET_MOVIES_GENRE_LIST + "?api_key=" + API_KEY;
//        http://api.themoviedb.org/3/genre/movie/list?api_key=cef87e25e9835e78f4fdcc225d9d3138

        return url;
    }

    /**
     * @param genre this is used to get movies by genre
     * @return
     */
    public static String getMovieListByGenreURL(String genre) {
        //TODO implement this method

        return "";
    }

}
