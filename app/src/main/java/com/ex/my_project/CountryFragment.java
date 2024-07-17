package com.ex.my_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.ex.my_project.databinding.FragmentCountryBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryFragment extends Fragment {
    private FragmentCountryBinding binding;
    private Map<String, List<String>> continentCountries;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentCountryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        continentCountries = new HashMap<>();
        continentCountries.put("Africa", Arrays.asList("NIGGER","Nigeria", "Kamerun", "Kenya", "Egypt"));
        continentCountries.put("Asia", Arrays.asList("Kyrgyzstan", "Chuy", "China", "Japan", "India"));
        continentCountries.put("Europe", Arrays.asList("Gogouziya", "Russia","Germany", "France", "Spain"));
        continentCountries.put("North America", Arrays.asList("USA","Cuba","Hawaii", "Canada", "Mexico"));
        continentCountries.put("South America", Arrays.asList("Braziliya","Venesuela","Urugway", "Argentina", "Chile"));

        String continent = getArguments().getString("continent");
        List<String> countries = continentCountries.getOrDefault(continent, new ArrayList<>());

        CountryAdapter adapter = new CountryAdapter(countries);
        binding.rvCountries.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvCountries.setAdapter(adapter);
    }


}
