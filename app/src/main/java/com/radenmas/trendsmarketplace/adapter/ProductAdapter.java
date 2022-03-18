package com.radenmas.trendsmarketplace.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.radenmas.trendsmarketplace.R;
import com.radenmas.trendsmarketplace.model.ProductModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private ArrayList<ProductModel> productModels;
    private Context context;


    public ProductAdapter(ArrayList<ProductModel> productModels, Context context) {
        this.productModels = productModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        ProductModel productModel = productModels.get(position);
        holder.title.setText(productModel.getTitle());
        holder.desc.setText(productModel.getDesc());
//        Picasso.get().load(productModel.getImg()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return productModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView title, desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            desc = itemView.findViewById(R.id.desc);

        }
    }
}
