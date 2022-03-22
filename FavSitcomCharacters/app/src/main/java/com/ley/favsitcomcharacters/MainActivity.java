package com.ley.favsitcomcharacters;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.ley.favsitcomcharacters.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    ArrayList<Sitcom> SitcomArrayList;
    private ActivityMainBinding binding;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        SitcomArrayList = new ArrayList<>();

        Sitcom b99 = new Sitcom("Jake Peralta","Brooklyn 99",R.drawable.jake);
        Sitcom modernFamily = new Sitcom("Cameraon Tucker","Modern Family", R.drawable.cam);
        Sitcom office = new Sitcom("Pam Beesly","The Office",R.drawable.pam);
        Sitcom friends = new Sitcom("Phoebe Buffay","Friends",R.drawable.phoebe);

        SitcomArrayList.add(b99);
        SitcomArrayList.add(modernFamily);
        SitcomArrayList.add(office);
        SitcomArrayList.add(friends);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SitcomAdapter sitcomAdapter = new SitcomAdapter(SitcomArrayList);
        binding.recyclerView.setAdapter(sitcomAdapter);

    }
}