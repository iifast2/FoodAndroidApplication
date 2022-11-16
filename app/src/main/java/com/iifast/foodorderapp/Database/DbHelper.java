package com.iifast.foodorderapp.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {
    public static final String name = "food.db";
    public SQLiteDatabase db;
    public static final int version = 1;
    private static DbHelper instance;



    public DbHelper(Context context) {
        super(context, name, null, version);
    }
    public static synchronized DbHelper getInstance(Context context) {
        if (instance == null) {
            instance = new DbHelper(context.getApplicationContext());
        }
        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        this.db = db;
        db.execSQL("create table users(id integer primary key autoincrement ,username TEXT,email TEXT,address TEXT,phone TEXT,password TEXT)");
        db.execSQL("create table food(id integer primary key autoincrement ,name TEXT,price TEXT,description TEXT)");
        db.execSQL("create table cart(cart_id integer primary key autoincrement ,name TEXT,price TEXT,quantity Text,order_num TEXT)");

       


    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");

        onCreate(db);

    }
 
    


    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }





    public Boolean insert_user(String username,String email,String address,String phone,String password)
    {
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("address",address);
        contentValues.put("phone",phone);
        contentValues.put("password",password);
        long res = mydb.insert("users",null,contentValues);
        if(res==-1)
            return false;
        else
            return true;
    }


    public Boolean insert_food(String name,String price,String description)
    {
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("price",price);
        contentValues.put("description",description);
        long res = mydb.insert("food",null,contentValues);
        if(res==-1)
            return false;
        else
            return true;
    }


    public Boolean insert_cart(String name,String price,String quantity,String order_num)
    {
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        contentValues.put("id",id);
        contentValues.put("name",name);
        contentValues.put("price",price);
        contentValues.put("quantity",quantity);
        contentValues.put("order_num",order_num);
        long res = mydb.insert("cart",null,contentValues);
        if(res==-1)
            return false;
        else
            return true;
    }


    public Boolean checkemail(String email){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where email=?", new String[] {email});
        if (cursor.getCount()>0){
            return true;
        }else
        {
            return false;
        }
    }

    public Boolean checkemailpassword(String email,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from users where email=? and password=? ", new String[] {email,password});
        if (cursor.getCount()>0){
            return true;
        }else
        {
            return false;
        }
    }



    public Cursor fetchResult(String id)
    {
        SQLiteDatabase mydb = getWritableDatabase();
        String qry =  "select * from quiz_result where user_id='"+id+"'";
        Cursor cursor = mydb.rawQuery(qry,null);
        return cursor;
    }





    public Cursor Readuser(String email)
    {
        SQLiteDatabase mydb = getWritableDatabase();
        String qry = "select * from users where email='"+email+"'";
        Cursor cursor = mydb.rawQuery(qry,null);
        return cursor;
    }
    public Boolean UpdateUser(String name,String email,String address,String phone,String password)
    {
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",name);
        contentValues.put("email",email);
        contentValues.put("address",address);
        contentValues.put("phone",phone);
        contentValues.put("password",password);
        long res = mydb.update("users",contentValues,"email = ?",new String[] {email});
        if(res==-1)
            return false;
        else
            return true;
    }

    public boolean DeleteUser(String em)
    {
        SQLiteDatabase mydb = this.getWritableDatabase();
        long res = mydb.delete("users", "email" + "=?", new String[]{em});
        if(res==-1)
            return false;
        else
            return true;
    }


    public Cursor FetchFood()
    {
        SQLiteDatabase mydb = getWritableDatabase();
        String qry = "select * from food ";
        Cursor cursor = mydb.rawQuery(qry,null);
        return cursor;
    }



    public Cursor FetchCart()
    {
        SQLiteDatabase mydb = getWritableDatabase();
        String qry = "select * from cart ";
        Cursor cursor = mydb.rawQuery(qry,null);
        return cursor;
    }


    public void DeleteAllCart()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("cart",null,null);
    }

    public boolean ReadCart()
    {
        SQLiteDatabase mydb = getWritableDatabase();
        String qry = "select * from cart";
        Cursor cursor = mydb.rawQuery(qry,null);
        if (cursor.getCount()>0)
        {
            return true;
        }
        else
            return false;
    }

}
