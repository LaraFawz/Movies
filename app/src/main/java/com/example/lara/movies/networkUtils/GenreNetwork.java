package com.example.lara.movies.networkUtils;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.lara.movies.AppController;
import com.example.lara.movies.networkUtils.volleyStuff.VolleyErrorHelper;
import com.example.lara.movies.networkUtils.volleyStuff.VolleyInstance;
import com.example.lara.movies.pojos.Genre;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Lara on 4/16/2018.
 */

public class GenreNetwork {

    public static void loadGenreList(final OnGenreListFinished onGenreListFinished) {
        String url = UrlBuilder.getGenreListURL();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
//                        response.getJSONObject()

                        try {
                            JSONArray genres = response.getJSONArray("genres");
                            onGenreListFinished.onGenreListFinishedSuccessfully(Genre.fromJSONArray(genres));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            onGenreListFinished.onGenreListFailed("Invalid data, try again later");
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        onGenreListFinished.onGenreListFailed(VolleyErrorHelper.getMessage(error));

                    }
                });
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy());
        jsonObjectRequest.setTag("LoadGenres");
        VolleyInstance
                .getInstance(AppController.getmInstance())
                .addToRequestQueue(jsonObjectRequest);


    }


    public static interface OnGenreListFinished {
        public void onGenreListFinishedSuccessfully(ArrayList<Genre> genreArrayList);

        public void onGenreListFailed(String friendlyErrorMessage);
    }
}

