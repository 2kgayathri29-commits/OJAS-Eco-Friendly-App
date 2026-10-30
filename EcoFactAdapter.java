package com.example.ojas.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ojas.R;

import java.util.List;

public class EcoFactAdapter extends RecyclerView.Adapter<EcoFactAdapter.ViewHolder> {

    private final List<String[]> facts;

    public EcoFactAdapter(List<String[]> facts) {
        this.facts = facts;
    }

    @NonNull @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_eco_fact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String[] fact = facts.get(position);
        holder.tvIcon.setText(fact[0]);
        holder.tvTitle.setText(fact[1]);
        holder.tvDesc.setText(fact[2]);
    }

    @Override
    public int getItemCount() { return facts.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvIcon, tvTitle, tvDesc;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIcon  = itemView.findViewById(R.id.tv_fact_icon);
            tvTitle = itemView.findViewById(R.id.tv_fact_title);
            tvDesc  = itemView.findViewById(R.id.tv_fact_desc);
        }
    }
}