package com.iifast.foodorderapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.iifast.foodorderapp.Models.CartModel;
import com.iifast.foodorderapp.Models.MainModel;
import com.iifast.foodorderapp.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewHolder> {

    Context context;
    ArrayList<CartModel> cartArrayList;


    public CartAdapter(Context context, ArrayList<CartModel> cartArrayList) {
        this.context = context;
        this.cartArrayList = cartArrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {



        final CartModel model = cartArrayList.get(position);
        holder.name.setText(model.getName());
        holder.order_price.setText(model.getPrice());
        holder.order_num.setText(model.getOrder_num());
        holder.order_quantity.setText(model.getQuantity());


//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Boolean delete =  openHelper.DeleteCart(cart_id);
//               if(delete==true)
//               {
//                   v.getContext().startActivity(new Intent(v.getContext(),CartActivity.class));
//
//                   /*Boolean update = openHelper.UpdateQuantity(quantity,pro_id);
//                   if(update==true)
//                   {
//                      v.getContext().startActivity(new Intent(v.getContext(),CartActivity.class));
//                   }
//
//                    */
//               }
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return cartArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView name,order_price,order_num,order_quantity;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.orderItemName);
            order_price = itemView.findViewById(R.id.order_price);
            order_num = itemView.findViewById(R.id.order_num);
            order_quantity = itemView.findViewById(R.id.order_quantity);

        }
    }
}
