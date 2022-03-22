package com.ley.favsitcomcharacters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ley.favsitcomcharacters.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class SitcomAdapter extends RecyclerView.Adapter<SitcomAdapter.SitcomHolder>{

    ArrayList<Sitcom> sitcomArrayList;

    public SitcomAdapter(ArrayList<Sitcom> sitcomArrayList) {
        this.sitcomArrayList = sitcomArrayList;
    }

    @NonNull
    @Override
    public SitcomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new SitcomHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(SitcomAdapter.SitcomHolder holder, int position) {
        holder.binding.recyclerViewTextView.setText(sitcomArrayList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenSitcom(sitcomArrayList.get(position));
                //intent.putExtra("landmark",landmarkList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sitcomArrayList.size();
    }

    public class SitcomHolder extends RecyclerView.ViewHolder{

        private RecyclerRowBinding binding;

        public SitcomHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
