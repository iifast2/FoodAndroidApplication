package com.iifast.foodorderapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.iifast.foodorderapp.DetailActivity;
import com.iifast.foodorderapp.Models.MainModel;
import com.iifast.foodorderapp.R;

//import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder>{

    ArrayList<MainModel> list;
    Context context;
    String user;

    public MainAdapter(ArrayList<MainModel> list, Context context,String user) {
        this.list = list;
        this.context = context;
        this.user = user;
    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood , parent , false );
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

     final MainModel model = list.get(position);
     holder.foodimage.setImageResource(model.getImage());
     holder.mainName.setText(model.getName());
     holder.price.setText(model.getPrice());
     holder.description.setText(model.getDescription());

     holder.card.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {


             if (!user.equals("admin")){
                 Intent i=new Intent(context, DetailActivity.class);
                 i.putExtra("name",model.getName());
                 i.putExtra("image",model.getImage());
                 i.putExtra("price",model.getPrice());
                 i.putExtra("desc",model.getDescription());
                 context.startActivity(i);
             }

             else{

                 Toast.makeText(context, "admin", Toast.LENGTH_SHORT).show();
             }

             }
     });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder {

        ImageView foodimage ;
        CardView card;
        TextView mainName , price , description ;

        public viewholder(@NonNull View itemView) {
            super(itemView);


            foodimage = itemView.findViewById(R.id.imageView);
            card = itemView.findViewById(R.id.card);
            mainName = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            description = itemView.findViewById(R.id.description);

        }
    }


}
