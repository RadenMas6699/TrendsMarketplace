package com.radenmas.trendsmarketplace.model.tokopedia

import com.google.gson.annotations.SerializedName

data class ResponseTokopedia(

	@field:SerializedName("data")
	val data: Data
)