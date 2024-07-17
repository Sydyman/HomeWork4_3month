package com.ex.my_project;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ex.my_project.databinding.ItemCountryBinding;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    private List<String> countries;

    public CountryAdapter(List<String> countries) {
        this.countries = countries;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemCountryBinding binding = ItemCountryBinding.inflate(inflater, parent, false);
        return new CountryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        String country = countries.get(position);
        holder.binding.tvCountryName.setText(country);
    }

    @Override
    public int getItemCount() {

        return countries.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {
        private final ItemCountryBinding binding;

        CountryViewHolder(ItemCountryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

