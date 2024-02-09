package com.example.homprent.src.feature.homerent.data.repository

import android.util.Log
import com.example.homprent.src.core.common.RequestCompleteListener
import com.example.homprent.src.feature.homerent.data.data_source.RemoteDataSource
import com.example.homprent.src.feature.homerent.data.model.HotelModelClass
import com.example.homprent.src.feature.homerent.domain.repositories.HotelsRepository
import retrofit2.Response

class HotelRepositoryImpl(private val dataSource: RemoteDataSource):HotelsRepository {

    override fun getHotelsList(locationName:String,callback:RequestCompleteListener<HotelModelClass>){
        try {
            dataSource.getHotelData(locationName,object : RequestCompleteListener<Response<HotelModelClass>>{
                override fun onSuccess(data: Response<HotelModelClass>) {
                    if(data.isSuccessful){
                        callback.onSuccess(data.body()!!)
                    }
                }
                override fun onFailed(error: String) {
                    callback.onFailed(error.toString())
                }
            } );

        }catch (e:Exception){
            callback.onFailed(e.toString())
            Log.d("HotelRepositoryImpl.getHotelsList",e.toString())

        }
    }
}