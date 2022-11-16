package com.iifast.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.iifast.foodorderapp.Database.DbHelper;
import com.iifast.foodorderapp.Models.MainModel;
import com.iifast.foodorderapp.databinding.ActivityLoginBinding;
import com.iifast.foodorderapp.databinding.ActivityMainBinding;
import com.iifast.foodorderapp.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding binding;
    DbHelper DB;
    String user;

    String id,name,address,pass,email,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DB=new DbHelper(this);

        user=getIntent().getStringExtra("user");
        binding.email1.setEnabled(false);


        Cursor cursor = DB.Readuser(user);
        while(cursor.moveToNext())
        {
             id = cursor.getString(0);
             name = cursor.getString(1);
             email = cursor.getString(2);
            address = cursor.getString(3);
            phone = cursor.getString(4);
             pass = cursor.getString(5);

        }

        binding.username1.setText(name);
        binding.address1.setText(address);
        binding.phone1.setText(phone);
        binding.email1.setText(email);
        binding.password1.setText(pass);

        binding.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
boolean result=DB.UpdateUser(binding.username1.getText().toString(),email,binding.address1.getText().toString(),binding.phone1.getText().toString(),binding.password1.getText().toString());

if(result){

    Toast.makeText(ProfileActivity.this, "Updated..Login Again", Toast.LENGTH_SHORT).show();
    Intent i=new Intent(getApplicationContext(),LoginActivity.class);
    startActivity(i);
    finish();
}else{
    Toast.makeText(ProfileActivity.this, "Update Failed ", Toast.LENGTH_SHORT).show();
}

            }
        });


    }
}