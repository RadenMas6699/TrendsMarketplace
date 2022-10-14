package com.radenmas.trendsmarketplace.model.blibli

import com.google.gson.annotations.SerializedName

data class ResponseBlibli(

	@field:SerializedName("data")
	val data: Data
)