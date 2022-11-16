package com.iifast.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.iifast.foodorderapp.Database.DbHelper;
import com.iifast.foodorderapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {


    ActivityDetailBinding binding;
    int q=1;
    DbHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.foodname.setText(getIntent().getStringExtra("name"));
        binding.detailDescription.setText(getIntent().getStringExtra("desc"));
        binding.foodprice.setText(getIntent().getStringExtra("price"));
        binding.detailImage.setImageResource(getIntent().getIntExtra("image",0));

        DB=new DbHelper(this);

        binding.orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(binding.nameBox.getText().toString().equals("")||binding.phoneBox.getText().toString().equals("")){
                    Toast.makeText(DetailActivity.this, "Enter Fields", Toast.LENGTH_SHORT).show();
                }

                else{
                    DB.insert_cart( getIntent().getStringExtra("name"),getIntent().getStringExtra("price"),binding.quantity.getText().toString(),"12332");
                    Intent i=new Intent(getApplicationContext(),OrderActivity.class);
                    startActivity(i);
                }

            }
        });


        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(q<10)
                {
                    q=q+1;
                   binding.quantity.setText(q+"");
                }


            }
        });

        binding.subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(q>1)
                {
                    q=q-1;
                    binding.quantity.setText(q+"");
                }


            }
        });






    }
}