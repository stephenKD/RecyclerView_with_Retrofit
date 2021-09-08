package com.android.recyclerview_with_retrofit.model


data class Data(
    val address: String,
    val category: List<Category>,
    val distric: String,
    val elong: Double,
    val email: String,
    val facebook: String,
    val fax: String,
    val files: List<Any>,
    val friendly: List<Friendly>,
    val id: Int,
    val images: List<Image>,
    val introduction: String,
    val links: List<Link>,
    val modified: String,
    val months: String,
    val name: String,
    val name_zh: Any,
    val nlat: Double,
    val official_site: String,
    val open_status: Int,
    val open_time: String,
    val remind: String,
    val service: List<Service>,
    val staytime: String,
    val target: List<Target>,
    val tel: String,
    val ticket: String,
    val url: String,
    val zipcode: String
)