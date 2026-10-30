package com.example.ojas.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ojas.R;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.ViewHolder> {

    private final List<String[]> quotes;

    public QuoteAdapter(List<String[]> quotes) {
        this.quotes = quotes;
    }

    @NonNull @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_quote, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String[] q = quotes.get(position);
        holder.tvQuote.setText("\"" + q[0] + "\"");
        holder.tvAuthor.setText("— " + q[1]);
    }

    @Override
    public int getItemCount() { return quotes.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuote, tvAuthor;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuote  = itemView.findViewById(R.id.tv_quote_text);
            tvAuthor = itemView.findViewById(R.id.tv_quote_author);
        }
    }
}