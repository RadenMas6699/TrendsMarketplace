package com.radenmas.trendsmarketplace.model.shopee

import com.google.gson.annotations.SerializedName

data class ResponseShopee(

	@field:SerializedName("items")
	val items: List<ItemsItem>
)