package com.iifast.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iifast.foodorderapp.Database.DbHelper;
import com.iifast.foodorderapp.databinding.ActivityMainBinding;
import com.iifast.foodorderapp.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {


    ActivityRegisterBinding binding;


    String user,pass,email,address,phone;

    DbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DB = new DbHelper(this);

        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 user = binding.username.getText().toString();
                 pass = binding.password.getText().toString();
                 address = binding.address.getText().toString();
                 email = binding.email.getText().toString();
                 phone = binding.phone.getText().toString();

                if(user.equals("")||pass.equals("")||address.equals("")||email.equals("")||phone.equals(""))
                    Toast.makeText(getApplicationContext(), "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(pass)){
                        Boolean checkuser = DB.checkemail(user);
                        if(checkuser==false){

                            Boolean insert = DB.insert_user(user,email,address,phone,pass);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(), "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);


                                startActivity(intent);
                            }else{
                                Toast.makeText(getApplicationContext(), "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                } }
        });
        binding.signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.putExtra("user",user);
                intent.putExtra("pass",pass);
                intent.putExtra("address",address);
                intent.putExtra("email",email);
                intent.putExtra("phone",phone);
                startActivity(intent);
            }
        });


    }
}