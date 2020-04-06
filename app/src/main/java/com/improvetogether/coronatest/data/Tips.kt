package com.improvetogether.coronatest.data

import com.google.gson.annotations.SerializedName

data class Tips(
	val allItems: List<Item?>?
) {
	data class Item(
			val image: String?,
			val description: String?,
			val title: String?,
			val url: String?
	)
}