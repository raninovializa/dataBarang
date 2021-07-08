package com.informatika.databarang.model

import com.google.gson.annotations.SerializedName

data class ResBarang(

	@field:SerializedName("ResBarang")
	val resBarang: List<ResBarangItem?>? = null
)

data class ResBarangItem(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
)
