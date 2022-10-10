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
import com.radenmas.trendsmarketplace.model.shopee.ItemsItem
import com.radenmas.trendsmarketplace.utils.Utils

class AdapterShopee(val context: Context) : RecyclerView.Adapter<AdapterShopee.UserViewHolder>() {

    private val productItem: MutableList<ItemsItem> = mutableListOf()

    inner class UserViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val image: ImageView = item.findViewById(R.id.imgProduct)
        private val title: TextView = item.findViewById(R.id.tvTitle)
        private val price: TextView = item.findViewById(R.id.tvPrice)
        private val city: TextView = item.findViewById(R.id.tvCity)
        private val rating: TextView = item.findViewById(R.id.tvRating)
        private val sold: TextView = item.findViewById(R.id.tvSold)

        fun bindUser(b: ItemsItem) {
            Glide.with(context).load("https://cf.shopee.co.id/file/${b.itemBasic.image}")
                .into(image)
            title.text = b.itemBasic.name
            val harga = b.itemBasic.price/100000
            price.text = Utils.formatRupiah(harga.toInt())
            city.text = b.itemBasic.shopLocation
            rating.text = "${Utils.formatComma1(b.itemBasic.itemRating.ratingStar.toFloat())} | "
            sold.text = "${b.itemBasic.historicalSold} Terjual"
        }
    }

    fun setProduct(data: List<ItemsItem>) {
        productItem.clear()
        productItem.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_shopee_grid, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindUser(productItem[position])
    }

    override fun getItemCount(): Int {
        return productItem.size
    }
}