package com.example.lara.movies.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lara.movies.R;
import com.example.lara.movies.pojos.Movie;

import java.util.ArrayList;

/**
 * Created by Lara on 4/16/2018.
 */

public class MoviesListAdapter extends RecyclerView.Adapter<MoviesListAdapter.MoviesListViewHolder> {

    private ArrayList<Movie> movieArrayList = new ArrayList<>();

    public void setMovieArrayList(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }

    @Override
    public MoviesListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View movieListItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        return new MoviesListViewHolder(movieListItem);
    }

    @Override
    public void onBindViewHolder(MoviesListViewHolder holder, int position) {
        holder.bind(movieArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    public static class MoviesListViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView_movieThumbnail;
        private final TextView textView_movieName;
        private final RatingBar ratingBar_movieRating;
        private final TextView textView_releaseDate;

        public MoviesListViewHolder(View itemView) {
            super(itemView);

            imageView_movieThumbnail = (ImageView) itemView.findViewById(R.id.imageView_movieThumbnail);
            textView_movieName = (TextView) itemView.findViewById(R.id.textView_movieName);
            ratingBar_movieRating = (RatingBar) itemView.findViewById(R.id.ratingBar_movieRating);
            textView_releaseDate = (TextView) itemView.findViewById(R.id.textView_releaseDate);


        }

        public void bind(Movie movie) {
            textView_movieName.setText(movie.movieName);
        }
    }
}

