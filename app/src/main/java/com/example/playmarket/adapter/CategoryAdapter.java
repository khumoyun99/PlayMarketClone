package com.example.playmarket.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playmarket.AllActivity;
import com.example.playmarket.DataActivity;
import com.example.playmarket.MainActivity;
import com.example.playmarket.databinding.ItemCategoryBinding;
import com.example.playmarket.model.Category;
import com.example.playmarket.model.Program;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private List<Category> categoryList;
    private onItemClickListener listener;

    public CategoryAdapter(List<Category> categoryList, onItemClickListener listener) {
        this.categoryList = categoryList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.categoryTv.setText(categoryList.get(position).getName());

        ProgramAdapter programAdapter = new ProgramAdapter(categoryList.get(position).getProgramList(), new ProgramAdapter.onItemClickListener() {
            @Override
            public void onItemClick(List<Program> programList, int position1) {
                Intent intent = new Intent(holder.binding.getRoot().getContext(),DataActivity.class);
                intent.putExtra("data",programList.get(position1));
                holder.itemView.getContext().startActivity(intent);
                Toast.makeText(holder.binding.getRoot().getContext(), categoryList.get(position).getProgramList().get(position1).getName(), Toast.LENGTH_SHORT).show();

            }
        });
        holder.binding.rvGameItem.setAdapter(programAdapter);


        holder.binding.allTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), AllActivity.class);
                intent.putExtra("all",categoryList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ItemCategoryBinding binding;
        public MyViewHolder(@NonNull ItemCategoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public interface onItemClickListener{
        void onItemClick(List<Category> categoryList,int position);
    }
}
