package com.radenmas.trendsmarketplace.model.blibli

import com.google.gson.annotations.SerializedName

data class ProductsItem(

	@field:SerializedName("images")
	val images: List<String>,

	@field:SerializedName("price")
	val price: Price,

	@field:SerializedName("review")
	val review: Review,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("soldRangeCount")
	val soldRangeCount: SoldRangeCount,

	@field:SerializedName("location")
	val location: String,

	@field:SerializedName("url")
	val url: String
)