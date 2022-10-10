package com.radenmas.trendsmarketplace.model.shopee

import com.google.gson.annotations.SerializedName

data class ItemBasic(

	@field:SerializedName("itemid")
	val itemid: Long,

	@field:SerializedName("image")
	val image: String,

	@field:SerializedName("sold")
	val sold: Int,

	@field:SerializedName("item_rating")
	val itemRating: ItemRating,

	@field:SerializedName("price")
	val price: Long,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("historical_sold")
	val historicalSold: Int,

	@field:SerializedName("shop_location")
	val shopLocation: String,

	@field:SerializedName("shopid")
	val shopid: Int,

	@field:SerializedName("stock")
	val stock: Int,

	@field:SerializedName("status")
	val status: Int
)