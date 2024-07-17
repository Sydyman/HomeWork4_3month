package com.ex.my_project;


import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ex.my_project.databinding.ItemContinentBinding;

import java.util.List;

public class ContinentAdapter extends RecyclerView.Adapter<ContinentAdapter.ContinentViewHolder> {
    private List<String> continents;
    private OnContinentClickListener listener;

    public interface OnContinentClickListener {
        void onContinentClick(String continent);
    }

    public ContinentAdapter(List<String> continents, OnContinentClickListener listener) {
        this.continents = continents;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemContinentBinding binding = ItemContinentBinding.inflate(inflater, parent, false);
        return new ContinentViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, int position) {
        String continent = continents.get(position);
        holder.binding.tvContinentName.setText(continent);
        holder.itemView.setOnClickListener(v -> listener.onContinentClick(continent));
    }

    @Override
    public int getItemCount() {
        return continents.size();
    }

   class ContinentViewHolder extends RecyclerView.ViewHolder {
        private final ItemContinentBinding binding;

        ContinentViewHolder(ItemContinentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
