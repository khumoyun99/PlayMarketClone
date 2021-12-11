package com.example.playmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.playmarket.databinding.ActivityDataBinding;
import com.example.playmarket.model.Program;

public class DataActivity extends AppCompatActivity {

    private ActivityDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Program program = (Program) getIntent().getSerializableExtra("data");
        binding.nameTv.setText(program.getName());
        binding.imageView.setImageResource(program.getImg());
        binding.descriptionTv.setText(program.getDescription());

    }
}