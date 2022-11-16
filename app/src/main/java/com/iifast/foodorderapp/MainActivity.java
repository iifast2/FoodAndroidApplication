package com.iifast.foodorderapp;
//   02:1300

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.iifast.foodorderapp.Adapters.MainAdapter;
import com.iifast.foodorderapp.Database.DbHelper;
import com.iifast.foodorderapp.Models.MainModel;
import com.iifast.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    ArrayList<MainModel> list;
    MainAdapter adapter;
    DbHelper DB;
    String user,admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DB=new DbHelper(this);
        list= new ArrayList<>();

        user=getIntent().getStringExtra("current");



            binding.currentuser.setText(user);
            adapter = new MainAdapter(list, this,user);

        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);









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

            MainModel mainModel = new MainModel(id,name,price,desc,R.drawable.burger);
            list.add(mainModel);


        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_add:
                    Intent i=new Intent(MainActivity.this,ProfileActivity.class);
                    i.putExtra("user",user);
                    startActivity(i);

                return true;


            case  R.id.logout:
                Intent in=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(in);
                finish();

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}









