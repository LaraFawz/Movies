package com.example.lara.movies.pojos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Lara on 4/16/2018.
 */

public class Genre {
    public int id;
    public String name;


    public static Genre fromJSON(JSONObject jsonObject) {
        Genre genre = new Genre();
        if (jsonObject.has("id")) {
            genre.id = jsonObject.optInt("id");
        }
        if (jsonObject.has("name")) {
            genre.name = jsonObject.optString("name");
        }
        return genre;
    }

    public static ArrayList<Genre> fromJSONArray(JSONArray jsonArrayGenres) {
        ArrayList<Genre> genreArrayList = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArrayGenres.length(); i++) {
                genreArrayList.add(Genre
                        .fromJSON(jsonArrayGenres
                                .getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return genreArrayList;

    }
}
