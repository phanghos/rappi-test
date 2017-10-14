package com.ghoss.android.rappitest.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ghoss.android.rappitest.R;
import com.ghoss.android.rappitest.domain.model.Movie;

import java.util.List;

/**
 * Created by roberto on 10/14/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private final List<Movie> movies;

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_row_layout, parent, false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie m = movies.get(position);
        holder.title.setText(m.getTitle());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
