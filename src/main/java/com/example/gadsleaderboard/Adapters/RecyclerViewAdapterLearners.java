package com.example.gadsleaderboard.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.DataModel.DataModelLearners;
import com.example.gadsleaderboard.R;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

public class RecyclerViewAdapterLearners extends RecyclerView.Adapter<RecyclerViewAdapterLearners.ViewHolder> {
    List<DataModelLearners> dataModelLearners;

    public RecyclerViewAdapterLearners(List<DataModelLearners> dataModelLearners) {
        this.dataModelLearners = dataModelLearners;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterLearners.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_learners_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterLearners.ViewHolder holder, int position) {
        holder.name.setText(dataModelLearners.get(position).getName());
        String placeHolder = dataModelLearners.get(position).getHours() + " learning hours, " + dataModelLearners.get(position).getCountry();
        holder.hourScoreCountry.setText(placeHolder);
        URL image = dataModelLearners.get(position).getBadgeUrl();
        Picasso.get()
                .load(String.valueOf(image))
                .placeholder(R.drawable.top_learner)
                .fit()
                .centerInside()
                .into(holder.imageUrl);

    }

    @Override
    public int getItemCount() {
        return dataModelLearners.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageUrl;
        TextView name;
        TextView hourScoreCountry;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageUrl = itemView.findViewById(R.id.imageUrl);
            name = itemView.findViewById(R.id.name);
            hourScoreCountry = itemView.findViewById(R.id.hoursScoreCountry);

        }
    }
}
