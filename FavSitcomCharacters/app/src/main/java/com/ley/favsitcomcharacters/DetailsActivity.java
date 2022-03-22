package com.ley.favsitcomcharacters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.ley.favsitcomcharacters.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        //Landmark selectedLandmark = (Landmark) intent.getSerializableExtra("landmark");

        Singleton singleton = Singleton.getInstance();
        Sitcom selectedSitcom = singleton.getSelectedSitcom();

        binding.nameText.setText(selectedSitcom.name);
        binding.sitcomText.setText(selectedSitcom.sitcom);
        binding.imageView.setImageResource(selectedSitcom.image);
    }
}