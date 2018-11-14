package com.example.lara.movies.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.lara.movies.R;
import com.example.lara.movies.adapters.GenresListAdapter;
import com.example.lara.movies.networkUtils.GenreNetwork;
import com.example.lara.movies.pojos.Genre;

import java.util.ArrayList;

public class GenresListFragment extends BaseFragment {
    private RecyclerView recyclerView_genresList;
    private GenresListAdapter genresListAdapter;
    private ProgressBar progressBar_loadingGenres;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_genres_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupViews(view);
        setupRecyclerView();

        getData();
    }

    private void getData() {
        progressBar_loadingGenres.setVisibility(View.VISIBLE);
        GenreNetwork.loadGenreList(new GenreNetwork.OnGenreListFinished() {
            @Override
            public void onGenreListFinishedSuccessfully(ArrayList<Genre> genreArrayList) {
                onGenreArrayListRetrieved(genreArrayList);
                progressBar_loadingGenres.setVisibility(View.GONE);
            }

            @Override
            public void onGenreListFailed(String friendlyErrorMessage) {
                onGenreArrayListRetrievedFailed(friendlyErrorMessage);
                progressBar_loadingGenres.setVisibility(View.GONE);
            }
        });
    }

    private void onGenreArrayListRetrievedFailed(String friendlyErrorMessage) {
        Snackbar.make(getView(), friendlyErrorMessage, Snackbar.LENGTH_SHORT).show();
    }

    private void onGenreArrayListRetrieved(ArrayList<Genre> movieArrayList) {
        genresListAdapter.setGenreArrayList(movieArrayList);
        genresListAdapter.notifyDataSetChanged();
    }

    private void setupRecyclerView() {
        recyclerView_genresList.setLayoutManager(new LinearLayoutManager(getContext()));

        genresListAdapter = new GenresListAdapter();
        recyclerView_genresList.setAdapter(genresListAdapter);
//
//        genresListAdapter.setGenreArrayList(Movie.getDummyMovieNames());
//        genresListAdapter.notifyDataSetChanged();

    }

    private void setupViews(View view) {
        recyclerView_genresList = (RecyclerView) view.findViewById(R.id.recyclerView_genresList);
        progressBar_loadingGenres = (ProgressBar) view.findViewById(R.id.progressBar_loadingGenres);


    }
}
