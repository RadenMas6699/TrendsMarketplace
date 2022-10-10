package com.radenmas.trendsmarketplace.model.tokopedia

data class ProductsItem(
	val shop: Shop,
	val price: String,
	val imageUrl: String,
	val name: String,
	val url: String,
	val ratingAverage: String
)
