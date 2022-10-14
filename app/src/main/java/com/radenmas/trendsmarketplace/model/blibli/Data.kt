package com.radenmas.trendsmarketplace.model.blibli

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("products")
	val products: List<ProductsItem>
)