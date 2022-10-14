package com.radenmas.trendsmarketplace.model.tokopedia

import com.google.gson.annotations.SerializedName

data class ProductsItem(

	@field:SerializedName("countReview")
	val countReview: Int,

	@field:SerializedName("shop")
	val shop: Shop,

	@field:SerializedName("labelGroups")
	val labelGroups: List<LabelGroupsItem>,

	@field:SerializedName("price")
	val price: String,

	@field:SerializedName("imageUrl")
	val imageUrl: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("ratingAverage")
	val ratingAverage: String
)