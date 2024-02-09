package com.example.homprent.src.feature.homerent.domain.usecase

import com.example.homprent.src.core.common.RequestCompleteListener
import com.example.homprent.src.feature.homerent.data.model.HotelModelClass
import com.example.homprent.src.feature.homerent.domain.repositories.HotelsRepository

class HotelUseCases(private val hotelRepo:HotelsRepository) {

    fun getHotelList(locationName: String,callback:RequestCompleteListener<HotelModelClass>) {
        hotelRepo.getHotelsList(locationName,object:RequestCompleteListener<HotelModelClass>{
            override fun onSuccess(data: HotelModelClass) {
                callback.onSuccess(data)
            }
            override fun onFailed(error: String) {
                callback.onFailed(error)
            }
        })
    }
}