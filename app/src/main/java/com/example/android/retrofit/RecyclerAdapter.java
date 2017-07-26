package com.example.android.retrofit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.retrofit.pojo.Features;
import com.example.android.retrofit.pojo.Properties;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static com.example.android.retrofit.R.layout.display;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<Features> data;

    public RecyclerAdapter(ArrayList<Features> data) {
        this.data = data;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(display, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Properties features = data.get(position).getProperties();

        holder.title.setText(features.getTitle());
        holder.date.setText(getDateString(features.getTime()));
        holder.alert.setText(getTsunamiAlertString(features.getTsunami()));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private String getDateString(long timeInMillis) {
        @SuppressWarnings("SimpleDateFormat")
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy 'at' HH:mm:ss z");
        return simpleDateFormat.format(timeInMillis);
    }

    private String getTsunamiAlertString(int tsunamiAlert) {
        switch (tsunamiAlert) {
            case 0:
                return "No";
            case 1:
                return "Yes";
            case 2:
                return "Not available";
            default:
                return null;
        }

    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView title, date, alert;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView) itemView.findViewById(R.id.date);
            alert = (TextView) itemView.findViewById(R.id.tsunami_alert);
        }


    }
}