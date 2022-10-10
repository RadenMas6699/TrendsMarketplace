package com.radenmas.trendsmarketplace.model.shopee

import com.google.gson.annotations.SerializedName

data class ItemsItem(

	@field:SerializedName("item_basic")
	val itemBasic: ItemBasic
)