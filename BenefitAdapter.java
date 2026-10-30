package com.example.ojas.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ojas.R;

import java.util.List;

public class BenefitAdapter extends RecyclerView.Adapter<BenefitAdapter.ViewHolder> {

    private final List<String[]> benefits;

    public BenefitAdapter(List<String[]> benefits) {
        this.benefits = benefits;
    }

    @NonNull @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_benefit, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String[] b = benefits.get(position);
        holder.tvIcon.setText(b[0]);
        holder.tvTitle.setText(b[1]);
        holder.tvDesc.setText(b[2]);
    }

    @Override
    public int getItemCount() { return benefits.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvIcon, tvTitle, tvDesc;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIcon  = itemView.findViewById(R.id.tv_benefit_icon);
            tvTitle = itemView.findViewById(R.id.tv_benefit_title);
            tvDesc  = itemView.findViewById(R.id.tv_benefit_desc);
        }
    }
}
