package com.tabardel.weather.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;

/**
 * Created by TABARDEL_Remy on 03/01/2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private WeakReference<Context> mWeakContext;

    public ForecastAdapter(Context context) {
        mWeakContext = new WeakReference<Context>(context);
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override public int getItemCount() {
        return 0;
    }
}
