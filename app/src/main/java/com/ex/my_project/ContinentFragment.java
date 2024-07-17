package com.ex.my_project;



import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.ex.my_project.databinding.FragmentContinentBinding;
import java.util.Arrays;
import java.util.List;


public class ContinentFragment extends Fragment {
    private FragmentContinentBinding binding;
    private List<String> continents;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentContinentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        continents = Arrays.asList("Africa", "Asia", "Europe", "North America", "South America");

        ContinentAdapter adapter = new ContinentAdapter(continents, continent -> {
            Bundle bundle = new Bundle();
            bundle.putString("continent", continent);
            CountryFragment countryFragment = new CountryFragment();
            countryFragment.setArguments(bundle);

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, countryFragment)
                    .addToBackStack(null)
                    .commit();
        });

        binding.rvContinents.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvContinents.setAdapter(adapter);
    }


}
