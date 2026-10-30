package com.example.ojas.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ojas.R;
import com.example.ojas.model.EcoProduct;

import java.util.List;

public class EcoProductAdapter
        extends RecyclerView.Adapter<EcoProductAdapter.ViewHolder> {

    private List<EcoProduct> products;
    private final OnProductClickListener listener;

    public interface OnProductClickListener {
        void onProductClick(EcoProduct product);
    }

    public EcoProductAdapter(List<EcoProduct> products, OnProductClickListener listener) {
        this.products = products;
        this.listener = listener;
    }

    public void updateList(List<EcoProduct> newList) {
        this.products = newList;
        notifyDataSetChanged();
    }

    @NonNull @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_eco_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EcoProduct product = products.get(position);
        holder.tvEmoji.setText(product.getEmoji());
        holder.tvName.setText(product.getName());
        holder.tvTagline.setText(product.getTagline());
        holder.itemView.setOnClickListener(v -> listener.onProductClick(product));
    }

    @Override
    public int getItemCount() { return products.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvEmoji, tvName, tvTagline;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmoji   = itemView.findViewById(R.id.tv_product_emoji);
            tvName    = itemView.findViewById(R.id.tv_product_name);
            tvTagline = itemView.findViewById(R.id.tv_product_tagline);
        }
    }
}