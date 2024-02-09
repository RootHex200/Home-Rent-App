package com.example.homprent.src.feature.homerent.domain.repositories
import com.example.homprent.src.core.common.RequestCompleteListener
import com.example.homprent.src.feature.homerent.data.model.HotelModelClass

interface HotelsRepository {
    fun getHotelsList(locationName:String,callback:RequestCompleteListener<HotelModelClass>)
}