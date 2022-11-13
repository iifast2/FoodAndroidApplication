package com.iifast.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.iifast.foodorderapp.Adapters.OrdersAdapter;
import com.iifast.foodorderapp.Models.OrdersModel;
import com.iifast.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOrderBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        ArrayList<OrdersModel> list = new ArrayList<>();
        list.add(new OrdersModel(R.drawable.burger , "Cheese burger" , "4" , "123456789"));
        list.add(new OrdersModel(R.drawable.burger , "Cheese burger" , "4" , "123456789"));
        list.add(new OrdersModel(R.drawable.burger , "Cheese burger" , "4" , "123456789"));
        list.add(new OrdersModel(R.drawable.burger , "Cheese burger" , "4" , "123456789"));
        list.add(new OrdersModel(R.drawable.burger , "Cheese burger" , "4" , "123456789"));
        list.add(new OrdersModel(R.drawable.burger , "Cheese burger" , "4" , "123456789"));
        list.add(new OrdersModel(R.drawable.burger , "Cheese burger" , "4" , "123456789"));


        OrdersAdapter adapter = new OrdersAdapter(list, this);
        binding.ordersRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.ordersRecyclerView.setLayoutManager(layoutManager);


    }
}