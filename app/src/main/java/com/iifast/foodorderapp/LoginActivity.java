package com.iifast.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.iifast.foodorderapp.Database.DbHelper;
import com.iifast.foodorderapp.databinding.ActivityLoginBinding;
import com.iifast.foodorderapp.databinding.ActivityRegisterBinding;

public class LoginActivity extends AppCompatActivity {


    ActivityLoginBinding binding;

    DbHelper DB;
    String user,pass,email,address,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DB=new DbHelper(
        this);

        binding.signin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 user = binding.email1.getText().toString().trim();
                 pass = binding.password1.getText().toString().trim();




                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

               else  if ((user.equals("admin")) && (pass.equals("admin"))) {
                    Intent intent = new Intent(getApplicationContext(), AddFoodActivity.class);
                    intent.putExtra("admin","admin");
                    startActivity(intent);
                }
                else

                {
                    Boolean checkuserpass = DB.checkemailpassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("current",user);

                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    }
