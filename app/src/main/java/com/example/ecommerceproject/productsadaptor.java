package com.example.ecommerceproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.protobuf.StringValue;

import java.util.List;

public class productsadaptor extends RecyclerView.Adapter<productsadaptor.ViewHolder> {

    List<products> p;
    private Context context;

    public productsadaptor(Context context,List<products> p) {
        this.p = p;
        this.context=context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivimg;
        TextView tvname,tvprice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivimg = itemView.findViewById(R.id.ivimg);
            tvname = itemView.findViewById(R.id.tvname);
            tvprice = itemView.findViewById(R.id.tvprice);

        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View w=(LayoutInflater.from(parent.getContext()).inflate(R.layout.products_layout,parent, false));
        return new ViewHolder(w);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(p.get(position).getImage()).into(holder.ivimg);
        if (p.get(position).getImage().equals("fs1") ) {
              holder.ivimg.setImageResource(R.drawable.fs1);
            }
        holder.tvprice.setText(String.valueOf(p.get(position).getPrice()));
        holder.tvname.setText(p.get(position).getName());
        holder.itemView.setTag(p.get(position));

    }


    @Override
    public int getItemCount() {
        return p.size();
    }


}
