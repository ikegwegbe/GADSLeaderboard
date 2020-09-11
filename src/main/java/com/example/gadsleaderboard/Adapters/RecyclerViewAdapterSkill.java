package com.example.gadsleaderboard.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gadsleaderboard.DataModel.DataModelSkillIq;
import com.example.gadsleaderboard.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapterSkill extends RecyclerView.Adapter<RecyclerViewAdapterSkill.ViewHolder> {
    List<DataModelSkillIq> dataModelSkillIqs;

    public RecyclerViewAdapterSkill(List<DataModelSkillIq> dataModelSkillIqs) {
        this.dataModelSkillIqs = dataModelSkillIqs;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterSkill.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.fragment_skill_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterSkill.ViewHolder holder, int position) {
        holder.name.setText(dataModelSkillIqs.get(position).getName());
        String placeholder = dataModelSkillIqs.get(position).getScore() + " skill IQ Score, " + dataModelSkillIqs.get(position).getCountry();
        holder.hourScoreCountry.setText(placeholder);
        String image = dataModelSkillIqs.get(position).getBadgeUrl();
        Picasso.get()
                .load(image)
                .placeholder(R.drawable.skill_iq_trimmed)
                .into(holder.imageUrl);

    }

    @Override
    public int getItemCount() {
        return dataModelSkillIqs.size();
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
