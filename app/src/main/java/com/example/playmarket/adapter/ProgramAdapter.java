package com.example.playmarket.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playmarket.databinding.ItemProgramBinding;
import com.example.playmarket.model.Program;

import java.util.List;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.MyViewHolder> {

    private List<Program> programList;
    private onItemClickListener listener;

    public ProgramAdapter(List<Program> programList, onItemClickListener listener) {
        this.programList = programList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(ItemProgramBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.programImg.setImageResource(programList.get(position).getImg());
        holder.binding.programTv.setText(programList.get(position).getName());

        holder.itemView.setOnClickListener(v -> {
            listener.onItemClick(programList,position);
        });
    }

    @Override
    public int getItemCount() {
        return programList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ItemProgramBinding binding;
        public MyViewHolder(@NonNull ItemProgramBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

    }
    public interface onItemClickListener{
        void onItemClick(List<Program> programList,int position);
    }
}
