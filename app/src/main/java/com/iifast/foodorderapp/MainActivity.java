package com.iifast.foodorderapp;
//   48:48

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Layout;

import com.iifast.foodorderapp.Adapters.MainAdapter;
import com.iifast.foodorderapp.Models.MainModel;
import com.iifast.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burger , "Burger", "5" , "Ham burger with Extra cheese"));
        list.add(new MainModel(R.drawable.pizza , "Pizza", "20" , "4 seasons pizza with mozzarella cheese"));
        list.add(new MainModel(R.drawable.chiken , "Chicken", "10" , "Fried chicken wings"));
        list.add(new MainModel(R.drawable.pasta , "Pasta", "15" , "Carbonara pasta with bacon"));


        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);

       //

    }


}







