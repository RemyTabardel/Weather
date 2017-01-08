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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TABARDEL_Remy on 03/01/2017.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textview_date) TextView textViewDate;
        @BindView(R.id.textview_temp) TextView textViewTemp;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private List<Forecast> mDataset;
    private WeakReference<Context> mWeakContext;
    private SimpleDateFormat mDayDateFormat;
    private OnItemClickListener mOnItemClickListener;

    public ForecastAdapter(Context context, OnItemClickListener onItemClickListener) {
        mWeakContext = new WeakReference<>(context);
        mDataset = new ArrayList<>();
        mDayDateFormat = new SimpleDateFormat("EEEE dd MMM yyyy", Locale.getDefault());
        mOnItemClickListener = onItemClickListener;
    }

    public void setData(List<Forecast> forecasts) {
        mDataset = forecasts;
        notifyDataSetChanged();
    }

    public List<Forecast> getData() {
        return mDataset;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forecast, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        final Forecast currentForecast = mDataset.get(position);

        holder.textViewDate.setText(mDayDateFormat.format(currentForecast.date));

        if (mWeakContext != null) {
            String temp = mWeakContext.get().getString(R.string.item_forecast_celcius, currentForecast.temperature.day);
            holder.textViewTemp.setText(temp);
        }

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    mOnItemClickListener.onItemClick(currentForecast);
                }
            });
        }
    }

    @Override public int getItemCount() {
        return mDataset.size();
    }

    public interface OnItemClickListener {
        public void onItemClick(Forecast forecast);
    }
}
