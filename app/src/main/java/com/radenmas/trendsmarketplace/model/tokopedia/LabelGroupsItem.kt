package com.radenmas.trendsmarketplace.model.tokopedia

import com.google.gson.annotations.SerializedName

data class LabelGroupsItem(

	@field:SerializedName("__typename")
	val typename: String,

	@field:SerializedName("position")
	val position: String,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("url")
	val url: String
)