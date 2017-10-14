package com.ghoss.android.rappitest.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ghoss.android.rappitest.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roberto on 10/14/17.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.title) TextView title;

    public MovieViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
