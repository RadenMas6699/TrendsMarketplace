package com.radenmas.trendsmarketplace.model.blibli

data class ProductsItem(
	val images: List<String>,
	val price: Price,
	val review: Review,
	val name: String,
	val soldRangeCount: SoldRangeCount,
	val location: String,
	val uniqueSellingPoint: String,
	val url: String
)
