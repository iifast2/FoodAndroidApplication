package com.iifast.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.iifast.foodorderapp.Adapters.CartAdapter;
import com.iifast.foodorderapp.Database.DbHelper;
import com.iifast.foodorderapp.Models.CartModel;
import com.iifast.foodorderapp.databinding.ActivityOrderBinding;

import java.util.ArrayList;
import java.util.Random;

public class OrderActivity extends AppCompatActivity {

    ActivityOrderBinding binding;
    LinearLayoutManager linearLayoutManager;
    DbHelper DB;
    CartAdapter cartAdapter;

    ArrayList<CartModel> cartList;
    int total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DB = new DbHelper(this);
        cartList = new ArrayList<>();
        cartAdapter = new CartAdapter(this, cartList);


        linearLayoutManager = new LinearLayoutManager(this);
        binding.ordersRecyclerView.setLayoutManager(linearLayoutManager);

        int i=0;
        Cursor cursor = DB.FetchCart();
        while(cursor.moveToNext())
        {
           String id = cursor.getString(0);
            String name= cursor.getString(1);
            String price = cursor.getString(2);
            String quantity = cursor.getString(3);
            String ordernum = cursor.getString(4);

            final int random = new Random().nextInt(61) + 20;
            CartModel cartModel = new CartModel(R.drawable.burger1,name,price,quantity,String.valueOf(random));
            cartList.add(cartModel);
            cartAdapter = new CartAdapter(this,cartList);
            binding.ordersRecyclerView.setAdapter(cartAdapter);

            i+=Integer.parseInt(price)*Integer.parseInt(quantity);

            total=total+Integer.parseInt(quantity);

        }


       binding.txtreport.setText("No. of Items : "+String.valueOf(total+ "\n$" + i));

        binding.checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean check = DB.ReadCart();
                if(check==true)
                {
                    DB.DeleteAllCart();
                    Toast.makeText(getApplicationContext(), "Thanks for Choosing Us", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "No record found", Toast.LENGTH_SHORT).show();
                }
            }
        });


        binding.carttrash.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DB.DeleteAllCart();
                Toast.makeText(getApplicationContext(), "Your cart has been cleared out !", Toast.LENGTH_SHORT).show();
                finish();
            }
        });



    }
}