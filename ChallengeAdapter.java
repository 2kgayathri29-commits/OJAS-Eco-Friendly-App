package com.example.ojas.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ojas.R;
import com.example.ojas.model.Challenge;

import java.util.List;

public class ChallengeAdapter
        extends RecyclerView.Adapter<ChallengeAdapter.ViewHolder> {

    private final List<Challenge> challenges;
    private final OnChallengeSelectListener listener;
    private String activeChallengeId = null;

    public interface OnChallengeSelectListener {
        void onSelectChallenge(Challenge challenge);
    }

    public ChallengeAdapter(List<Challenge> challenges,
                            OnChallengeSelectListener listener) {
        this.challenges = challenges;
        this.listener   = listener;
    }

    public void setActiveChallengeId(String id) {
        this.activeChallengeId = id;
        notifyDataSetChanged();
    }

    @NonNull @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_challenge, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Challenge challenge = challenges.get(position);
        holder.tvEmoji.setText(challenge.getEmoji());
        holder.tvName.setText(challenge.getName());
        holder.tvDesc.setText(challenge.getDescription());

        boolean isActive = challenge.getId().equals(activeChallengeId);
        holder.btnSelect.setText(isActive ? "Active ✓" : "Select");
        holder.btnSelect.setEnabled(!isActive);
        holder.btnSelect.setAlpha(isActive ? 0.6f : 1.0f);

        holder.btnSelect.setOnClickListener(v -> {
            if (!isActive) listener.onSelectChallenge(challenge);
        });
    }

    @Override
    public int getItemCount() { return challenges.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvEmoji, tvName, tvDesc;
        Button btnSelect;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmoji   = itemView.findViewById(R.id.tv_challenge_emoji);
            tvName    = itemView.findViewById(R.id.tv_challenge_name);
            tvDesc    = itemView.findViewById(R.id.tv_challenge_desc);
            btnSelect = itemView.findViewById(R.id.btn_select_challenge);
        }
    }
}