package com.example.ecommerceproject;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class allpadptr extends RecyclerView.Adapter<allpadptr.ViewHolder> {

    List<allproducts> a;
    private Context context;

    public allpadptr(Context context,List<allproducts> a) {
        this.a = a;
        this.context=context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itmimg;
        TextView itname,itmprice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itmimg = itemView.findViewById(R.id.itmimg);
            itname = itemView.findViewById(R.id.itname);
            itmprice = itemView.findViewById(R.id.itmprice);


        }
    }
    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View w=(LayoutInflater.from(parent.getContext()).inflate(R.layout.allproducts_layout,parent, false));
        return new ViewHolder(w);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(a.get(position).getI()).into(holder.itmimg);
        holder.itname.setText(a.get(position).getN());
        holder.itmprice.setText(String.valueOf(a.get(position).getP()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,informationactivity
                        .class);
                intent.putExtra("information",a.get(position));
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return a.size();
    }


}
