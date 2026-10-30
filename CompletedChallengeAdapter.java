package com.example.ojas.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ojas.R;
import com.example.ojas.data.local.entities.ChallengeEntity;

import java.util.List;

public class CompletedChallengeAdapter
        extends RecyclerView.Adapter<CompletedChallengeAdapter.ViewHolder> {

    private List<ChallengeEntity> challenges;

    public CompletedChallengeAdapter(List<ChallengeEntity> challenges) {
        this.challenges = challenges;
    }

    public void updateList(List<ChallengeEntity> newList) {
        this.challenges = newList;
        notifyDataSetChanged();
    }

    @NonNull @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_completed_challenge, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChallengeEntity challenge = challenges.get(position);
        holder.tvEmoji.setText(challenge.emoji);
        holder.tvName.setText(challenge.name);
        holder.tvDate.setText("Completed on: " + challenge.completedDate);
        holder.tvScore.setText("⭐ +" + challenge.points + " Points Earned");
    }

    @Override
    public int getItemCount() { return challenges.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvEmoji, tvName, tvDate, tvScore;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmoji = itemView.findViewById(R.id.tv_completed_emoji);
            tvName  = itemView.findViewById(R.id.tv_completed_name);
            tvDate  = itemView.findViewById(R.id.tv_completed_date);
            tvScore = itemView.findViewById(R.id.tv_completed_score);
        }
    }
}