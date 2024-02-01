package com.example.homprent.model.data_class

data class NearPlace(
    val bathroom: String,
    val bedroom: String,
    val bill: String,
    val description: String,
    val distance: String,
    val galary: List<String>,
    val hotel_name: String,
    val hotel_thum_image: String,
    val location_url: String,
    val owrner: Owrner,
    val sub_title: String,
    val type: String
)