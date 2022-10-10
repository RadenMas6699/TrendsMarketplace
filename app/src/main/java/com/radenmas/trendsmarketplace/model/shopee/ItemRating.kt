package com.radenmas.trendsmarketplace.model.shopee

import com.google.gson.annotations.SerializedName

data class ItemRating(

	@field:SerializedName("rating_star")
	val ratingStar: Double
)