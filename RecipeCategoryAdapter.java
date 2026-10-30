package com.example.ojas.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ojas.R;
import com.example.ojas.model.RecipeCategory;

import java.util.List;

public class RecipeCategoryAdapter
        extends RecyclerView.Adapter<RecipeCategoryAdapter.ViewHolder> {

    private final List<RecipeCategory> categories;
    private final OnCategoryClickListener listener;

    public interface OnCategoryClickListener {
        void onCategoryClick(RecipeCategory category);
    }

    public RecipeCategoryAdapter(List<RecipeCategory> categories,
                                 OnCategoryClickListener listener) {
        this.categories = categories;
        this.listener   = listener;
    }

    @NonNull @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecipeCategory cat = categories.get(position);
        holder.tvEmoji.setText(cat.getEmoji());
        holder.tvName.setText(cat.getName());
        holder.flBg.setBackgroundColor(cat.getBackgroundColor());
        holder.itemView.setOnClickListener(v -> listener.onCategoryClick(cat));
    }

    @Override
    public int getItemCount() { return categories.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        FrameLayout flBg;
        TextView tvEmoji, tvName;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            flBg    = itemView.findViewById(R.id.fl_category_bg);
            tvEmoji = itemView.findViewById(R.id.tv_category_emoji);
            tvName  = itemView.findViewById(R.id.tv_category_name);
        }
    }
}