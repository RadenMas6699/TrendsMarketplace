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
import com.radenmas.trendsmarketplace.model.blibli.ProductsItem
import com.radenmas.trendsmarketplace.utils.Utils

class AdapterBlibli(val context: Context) : RecyclerView.Adapter<AdapterBlibli.BlibliViewHolder>() {

    private val productItem: MutableList<ProductsItem> = mutableListOf()

    inner class BlibliViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val image: ImageView = item.findViewById(R.id.imgProduct)
        private val title: TextView = item.findViewById(R.id.tvTitle)
        private val price: TextView = item.findViewById(R.id.tvPrice)
        private val city: TextView = item.findViewById(R.id.tvCity)
        private val rating: TextView = item.findViewById(R.id.tvRating)
        private val sold: TextView = item.findViewById(R.id.tvSold)

        fun bindProduct(b: ProductsItem) {

            Glide.with(context).load(b.images[0]).into(image)
            title.text = b.name
            price.text = Utils.formatRupiah(b.price.minPrice)
            city.text = b.location
            if (b.review.absoluteRating > 0) {
                rating.visibility = View.VISIBLE
                rating.text = "${b.review.absoluteRating} (${b.review.count}) | "
            } else {
                rating.visibility = View.GONE
            }
            sold.text = "Terjual ${b.soldRangeCount.id}"
        }
    }

    fun setProduct(data: List<ProductsItem>) {
        productItem.clear()
        productItem.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlibliViewHolder {
        return BlibliViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_blibli, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BlibliViewHolder, position: Int) {
        holder.bindProduct(productItem[position])
    }

    override fun getItemCount(): Int {
        return productItem.size
    }
}