package com.iifast.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.iifast.foodorderapp.Database.DbHelper;
import com.iifast.foodorderapp.databinding.ActivityAddFoodBinding;
import com.iifast.foodorderapp.databinding.ActivityMainBinding;

public class AddFoodActivity extends AppCompatActivity {

    ActivityAddFoodBinding binding;
    DbHelper DB;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        DB = new DbHelper(this);


        user=getIntent().getStringExtra("admin");
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.name.getText().toString();
                String price = binding.price.getText().toString();
                String description = binding.description.getText().toString();



                if(name.equals("")||price.equals("")||description.equals(""))
                    Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean insert = DB.insert_food(name,price,description);
                    if(insert==true){
                        Toast.makeText(getApplicationContext(), "Added successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),AdminShowActivity.class);
                        intent.putExtra("admin",user);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}