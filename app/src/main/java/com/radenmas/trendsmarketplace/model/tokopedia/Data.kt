package com.radenmas.trendsmarketplace.model.tokopedia

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("organic")
	val organic: Organic,

	@field:SerializedName("products")
	val products: List<ProductsItem>
)