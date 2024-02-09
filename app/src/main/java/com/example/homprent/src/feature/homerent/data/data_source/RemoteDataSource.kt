package com.example.homprent.src.feature.homerent.data.data_source
import com.example.homprent.src.core.common.RequestCompleteListener
import com.example.homprent.src.feature.homerent.data.model.HotelModelClass
import retrofit2.Response

interface RemoteDataSource {
    fun getHotelData(locationName:String,callback:RequestCompleteListener<Response<HotelModelClass>>)
}