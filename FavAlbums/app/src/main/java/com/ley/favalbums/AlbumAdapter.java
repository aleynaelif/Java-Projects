package com.ley.favalbums;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ley.favalbums.databinding.RecycleRowBinding;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumHolder>{

    ArrayList<Album> albumArrayList;

    public  AlbumAdapter(ArrayList<Album>albumArrayList){
        this.albumArrayList = albumArrayList;
    }

    @NonNull
    @Override
    public AlbumHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecycleRowBinding recycleRowBinding = RecycleRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent,false);
        return new AlbumHolder(recycleRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumHolder holder, int position) {
        holder.binding.recycleViewTextView.setText(albumArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(),AlbumActivity.class);
                intent.putExtra("info","old");
                intent.putExtra("albumId",albumArrayList.get(position).id);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    public class AlbumHolder extends RecyclerView.ViewHolder{
        private RecycleRowBinding binding;

        public AlbumHolder(RecycleRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
