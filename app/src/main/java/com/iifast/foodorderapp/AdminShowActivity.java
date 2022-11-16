package com.iifast.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.database.Cursor;
import android.os.Bundle;

import com.iifast.foodorderapp.Adapters.MainAdapter;
import com.iifast.foodorderapp.Database.DbHelper;
import com.iifast.foodorderapp.Models.MainModel;
import com.iifast.foodorderapp.databinding.ActivityAdminShowBinding;
import com.iifast.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class AdminShowActivity extends AppCompatActivity {

    ActivityAdminShowBinding binding;
    ArrayList<MainModel> list;
    MainAdapter adapter;
    DbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityAdminShowBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DB=new DbHelper(this);
        list= new ArrayList<>();



        binding.currentuser1.setText("admin");
        adapter = new MainAdapter(list, this,"admin");

        binding.recyclerview1.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview1.setLayoutManager(layoutManager);


    }

    @Override
    protected void onResume() {
        super.onResume();
        updateDataInList();
        adapter.notifyDataSetChanged();
    }

    private void updateDataInList() {


        list.clear();
        Cursor cursor = DB.FetchFood();
        while(cursor.moveToNext())
        {
            String id = cursor.getString(0);
            String name = cursor.getString(1);
            String price = cursor.getString(2);
            String desc = cursor.getString(3);

            MainModel mainModel = new MainModel(id,name,price,desc,R.drawable.burger1);
            list.add(mainModel);


        }



    }
}