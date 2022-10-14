package com.radenmas.trendsmarketplace.model.blibli

import com.google.gson.annotations.SerializedName

data class Review(

	@field:SerializedName("absoluteRating")
	val absoluteRating: Double,

	@field:SerializedName("count")
	val count: Int
)