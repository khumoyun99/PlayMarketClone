package com.example.playmarket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.playmarket.adapter.CategoryAdapter;
import com.example.playmarket.databinding.ActivityMainBinding;
import com.example.playmarket.databinding.ItemCategoryBinding;
import com.example.playmarket.model.Category;
import com.example.playmarket.model.Program;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private List<Category> categoryList;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadData();
        categoryAdapter = new CategoryAdapter(categoryList, new CategoryAdapter.onItemClickListener() {
            @Override
            public void onItemClick(List<Category> categoryList, int position) {
            }
        });
        binding.rv.setAdapter(categoryAdapter);

    }

    private void loadData() {
        categoryList = new ArrayList<>();

        int[] theBestAppImgId = {R.drawable.tiktok1,R.drawable.facebook_logos,R.drawable.insagram,R.drawable.messenger,
                R.drawable.twitter,R.drawable.youtube};
        int[] instrumentsImgId = {R.drawable.googltr,R.drawable.scanner,R.drawable.calculator,R.drawable.sgareit,R.drawable.app_lock,
                R.drawable.winrar};
        String[] theBestAppName = {"Tik tok","Facebook","Instagram","Messenger","Twitter","YouTube"};
        String[] instrumentsName = {"Google translate","Scanner","Calculator","SHAREit","App-Lock","WinRar"};

        List<Program> the_best_applicationsList = new ArrayList<>();
        for (int i = 0; i < theBestAppImgId.length; i++) {
            the_best_applicationsList.add(new Program(theBestAppName[i],theBestAppImgId[i],"Matn"));
        }

        List<Program> instrumentsList = new ArrayList<>();
        for (int i = 0; i < instrumentsImgId.length; i++) {
            instrumentsList.add(new Program(instrumentsName[i],instrumentsImgId[i],"Matn"));
        }

        categoryList.add(new Category("The best application",the_best_applicationsList));
        categoryList.add(new Category("Instruments",instrumentsList));
        categoryList.add(new Category("The best application",the_best_applicationsList));
        categoryList.add(new Category("Instruments",instrumentsList));
        categoryList.add(new Category("The best application",the_best_applicationsList));
        categoryList.add(new Category("Instruments",instrumentsList));







    }
}