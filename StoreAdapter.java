package com.example.ojas.adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ojas.R;
import com.example.ojas.model.EcoStore;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    private List<EcoStore> stores;

    public StoreAdapter(List<EcoStore> stores) {
        this.stores = stores;
    }

    public void updateList(List<EcoStore> newList) {
        this.stores = newList;
        notifyDataSetChanged();
    }

    @NonNull @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_store, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EcoStore store = stores.get(position);
        holder.tvEmoji.setText(store.getEmoji());
        holder.tvName.setText(store.getName());
        holder.tvAddress.setText(store.getFullAddress());

        holder.btnMaps.setOnClickListener(v -> {
            Uri uri = Uri.parse(store.getMapsUrl());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setPackage("com.google.android.apps.maps");
            if (intent.resolveActivity(v.getContext().getPackageManager()) != null) {
                v.getContext().startActivity(intent);
            } else {
                v.getContext().startActivity(
                        new Intent(Intent.ACTION_VIEW, uri));
            }
        });
    }

    @Override
    public int getItemCount() { return stores.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvEmoji, tvName, tvAddress;
        Button btnMaps;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmoji   = itemView.findViewById(R.id.tv_store_emoji);
            tvName    = itemView.findViewById(R.id.tv_store_name);
            tvAddress = itemView.findViewById(R.id.tv_store_address);
            btnMaps   = itemView.findViewById(R.id.btn_maps);
        }
    }
}