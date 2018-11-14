package com.example.lara.movies.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lara.movies.R;
import com.example.lara.movies.adapters.MoviesListAdapter;
import com.example.lara.movies.networkUtils.MovieNetwork;
import com.example.lara.movies.pojos.Movie;

import java.util.ArrayList;


public class MoviesListFragment extends BaseFragment {
    private RecyclerView recyclerView_moviesList;
    private MoviesListAdapter moviesListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupViews(view);
        setupRecyclerView();

        getData();
    }

    private void getData() {
        MovieNetwork.loadMovieListByGenre("Action", new MovieNetwork.OnMovieListByGenreFinished() {
            @Override
            public void onMovieListRetrievedSuccessfully(ArrayList<Movie> movieArrayList) {
                onMovieArrayListRetrieved(movieArrayList);
            }

            @Override
            public void onMovieListRetrievedFailed(String friendlyErrorMessage) {
                onMovieArrayListRetrievedFailed(friendlyErrorMessage);

            }
        });
    }

    private void onMovieArrayListRetrievedFailed(String friendlyErrorMessage) {
        Snackbar.make(getView(), friendlyErrorMessage, Snackbar.LENGTH_SHORT).show();
    }

    private void onMovieArrayListRetrieved(ArrayList<Movie> movieArrayList) {
        moviesListAdapter.setMovieArrayList(movieArrayList);
        moviesListAdapter.notifyDataSetChanged();
    }

    private void setupRecyclerView() {
        recyclerView_moviesList.setLayoutManager(new LinearLayoutManager(getContext()));

        moviesListAdapter = new MoviesListAdapter();
        recyclerView_moviesList.setAdapter(moviesListAdapter);

        moviesListAdapter.setMovieArrayList(Movie.getDummyMovieNames());
        moviesListAdapter.notifyDataSetChanged();

    }

    private void setupViews(View view) {
        recyclerView_moviesList = (RecyclerView) view.findViewById(R.id.recyclerView_moviesList);


    }
}
