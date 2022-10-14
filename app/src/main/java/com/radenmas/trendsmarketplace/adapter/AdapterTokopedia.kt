/*
 * Created by RadenMas on 10/3/2022.
 * Copyright (c) 2022.
 */

package com.radenmas.trendsmarketplace.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.radenmas.trendsmarketplace.R
import com.radenmas.trendsmarketplace.model.tokopedia.ProductsItem

class AdapterTokopedia(val context: Context) :
    RecyclerView.Adapter<AdapterTokopedia.TokopediaViewHolder>() {

    private val productItem: MutableList<ProductsItem> = mutableListOf()

    inner class TokopediaViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val image: ImageView = item.findViewById(R.id.imgProduct)
        private val title: TextView = item.findViewById(R.id.tvTitle)
        private val price: TextView = item.findViewById(R.id.tvPrice)
        private val city: TextView = item.findViewById(R.id.tvCity)
        private val rating: TextView = item.findViewById(R.id.tvRating)
        private val sold: TextView = item.findViewById(R.id.tvSold)

        fun bindUser(b: ProductsItem) {
            Glide.with(context).load(b.imageUrl)
                .into(image)
            title.text = b.name
            price.text = b.price
            city.text = b.shop.city
            rating.text = "${b.ratingAverage}"
//            sold.text =
        }
    }

    fun setProduct(data: List<ProductsItem>) {
        productItem.clear()
        productItem.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TokopediaViewHolder {
        return TokopediaViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_tokopedia, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TokopediaViewHolder, position: Int) {
        holder.bindUser(productItem[position])
    }

    override fun getItemCount(): Int {
        return productItem.size
    }
}