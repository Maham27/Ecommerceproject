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

import java.util.ArrayList;
import java.util.List;

public class itemsadaptor extends RecyclerView.Adapter<itemsadaptor.ViewHolder> {

    List<itemsnames> items;
    private Context context;

    public itemsadaptor(Context context,List<itemsnames> items) {
        this.items = items;
        this.context=context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            tvTitle = itemView.findViewById(R.id.tvTitle);


        }
    }
    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View w=(LayoutInflater.from(parent.getContext()).inflate(R.layout.items_layout,parent, false));
       return new ViewHolder(w);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(items.get(position).getImg()).into(holder.img);
        //if (items.get(position).getImg().equals("menshoes") ) {
          //  holder.img.setImageResource(R.drawable.menshoes);
        //}
          //  else if (items.get(position).getImg().equals("menkurta")) {
            //holder.img.setImageResource(R.drawable.menkurta);
        //}
        //else if (items.get(position).getImg().equals("bagp")) {
            //holder.img.setImageResource(R.drawable.bagp);
        //}


        holder.tvTitle.setText(items.get(position).getTitle());

        holder.itemView.setTag(items.get(position));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


}
