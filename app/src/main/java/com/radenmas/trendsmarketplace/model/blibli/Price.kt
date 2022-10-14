package com.radenmas.trendsmarketplace.model.blibli

import com.google.gson.annotations.SerializedName

data class Price(

	@field:SerializedName("minPrice")
	val minPrice: Int
)