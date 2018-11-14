package com.example.lara.movies;

import android.os.Bundle;

import com.example.lara.movies.fragments.GenresListFragment;
import com.example.lara.movies.fragments.MoviesListFragment;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        showGenresListFragment();
    }

    private void showMoviesListFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout_fragmentContainer, new MoviesListFragment(), MoviesListFragment.class.getSimpleName())
                .commit();
    }

    private void showGenresListFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout_fragmentContainer, new GenresListFragment(), GenresListFragment.class.getSimpleName())
                .commit();
    }
}
