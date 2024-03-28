package com.example.werescue;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.werescue.HomeFragment;
import com.example.werescue.R;
import com.example.werescue.Search;
import com.example.werescue.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

    int id = item.getItemId();

    if (id == R.id.home) {
        replaceFragment(new HomeFragment());
    } else if (id == R.id.search) {
        replaceFragment(new Search());
    } else if (id == R.id.pets) {
        replaceFragment(new PetsFragment());
    } else if (id == R.id.profile) {
        replaceFragment(new ProfileFragment());
    }

            return true;

});

    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}