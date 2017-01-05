package com.tabardel.weather.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tabardel.weather.R;
import com.tabardel.weather.services.models.Forecast;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TABARDEL_Remy on 03/01/2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textview_day) TextView textViewDay;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private List<Forecast> mDataset;
    private WeakReference<Context> mWeakContext;

    public ForecastAdapter(Context context) {
        mWeakContext = new WeakReference<>(context);
        mDataset = new ArrayList<>();
    }

    public void setData(List<Forecast> forecasts) {
        mDataset = forecasts;
        notifyDataSetChanged();
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        Forecast currentForecast = mDataset.get(position);
        holder.textViewDay.setText("date : " + currentForecast.date);
    }

    @Override public int getItemCount() {
        return mDataset.size();
    }
}
