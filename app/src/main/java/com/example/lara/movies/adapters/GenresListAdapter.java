package com.example.lara.movies.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lara.movies.R;
import com.example.lara.movies.pojos.Genre;

import java.util.ArrayList;

/**
 * Created by Lara on 4/16/2018.
 */

public class GenresListAdapter extends RecyclerView.Adapter<GenresListAdapter.MoviesListViewHolder> {

    private ArrayList<Genre> genreArrayList = new ArrayList<>();

    public void setGenreArrayList(ArrayList<Genre> genreArrayList) {
        this.genreArrayList = genreArrayList;
    }

    @Override
    public MoviesListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View movieListItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.genre_list_item, parent, false);
        return new MoviesListViewHolder(movieListItem);
    }

    @Override
    public void onBindViewHolder(MoviesListViewHolder holder, int position) {
        holder.bind(genreArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return genreArrayList.size();
    }

    public static class MoviesListViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView_genreName;
        private final TextView textView_genreID;


        public MoviesListViewHolder(View itemView) {
            super(itemView);
            textView_genreName = (TextView) itemView.findViewById(R.id.textView_genreName);
            textView_genreID = (TextView) itemView.findViewById(R.id.textView_genreID);
        }

        public void bind(Genre genre) {
            textView_genreID.setText(String.valueOf(genre.id));
            textView_genreName.setText(genre.name);
        }
    }
}

