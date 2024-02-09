package com.example.homprent.src.feature.homerent.data.data_source

import android.util.Log
import com.example.homprent.src.core.common.RequestCompleteListener
import com.example.homprent.src.core.network.ApiClient
import com.example.homprent.src.feature.homerent.data.model.HotelModelClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSourceImpl():RemoteDataSource {
    override fun getHotelData(locationName:String,callback:RequestCompleteListener<Response<HotelModelClass>>){
        val response= ApiClient.getApiClient().getHotel(locationName)
        response.enqueue(object :Callback<HotelModelClass>{
            override fun onResponse(
                call: Call<HotelModelClass>,
                response: Response<HotelModelClass>
            ) {
                callback.onSuccess(response)
            }

            override fun onFailure(call: Call<HotelModelClass>, t: Throwable) {
                Log.d("RemoteDataSourceImpl.getHotelData",t.toString())
                callback.onFailed(t.toString())
            }

        })
    }
}
