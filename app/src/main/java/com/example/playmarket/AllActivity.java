package com.example.playmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.playmarket.adapter.ProgramAdapter;
import com.example.playmarket.databinding.ActivityAllBinding;
import com.example.playmarket.model.Category;
import com.example.playmarket.model.Program;

import java.util.ArrayList;
import java.util.List;

public class AllActivity extends AppCompatActivity {

    private ActivityAllBinding binding;
    private ProgramAdapter programAdapter;
    private List<Program> programList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAllBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        programAdapter = new ProgramAdapter(programList, new ProgramAdapter.onItemClickListener() {
            @Override
            public void onItemClick(List<Program> programList, int position) {
                Intent intent = new Intent(AllActivity.this,DataActivity.class);
                intent.putExtra("data",programList.get(position));
                startActivity(intent);
            }
        });
        binding.rvAll.setAdapter(programAdapter);

    }

    private void loadData() {
        programList = new ArrayList<>();

        Category category = (Category) getIntent().getSerializableExtra("all");

        for (Program program:category.getProgramList()){
            programList.add(program);
        }

    }
}