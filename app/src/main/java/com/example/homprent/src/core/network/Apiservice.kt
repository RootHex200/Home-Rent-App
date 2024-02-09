package com.example.homprent.src.core.network
import com.example.homprent.src.feature.homerent.data.model.HotelModelClass
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface Apiservice {
    @GET("location")
    fun getHotel(@Query("name") locationname:String):Call<HotelModelClass>
}