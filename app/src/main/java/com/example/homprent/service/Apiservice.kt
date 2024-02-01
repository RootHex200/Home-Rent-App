package com.example.homprent.service
import com.example.homprent.model.data_class.HotelModelClass
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface Apiservice {
    @GET("location")
    fun getHotel(@Query("name") locationname:String):Call<HotelModelClass>
}