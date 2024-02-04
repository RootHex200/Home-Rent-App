package com.example.homprent.model.data_class
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class DetailsPageModel(
    val house_image:String,
    val house_name:String,
    val  house_subtitle:String,
    val house_details:String,
    val bedroom:String,
    val bathroom:String,
    val owner_name:String,
    val owner_phone:String,
    val gallery_list:List<String>,
    val location:String,
    val price:String
):Parcelable
