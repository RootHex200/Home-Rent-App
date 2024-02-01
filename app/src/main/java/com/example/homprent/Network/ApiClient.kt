package com.example.homprent.Network

import android.util.Log
import com.example.homprent.service.Apiservice

class ApiClient{
    companion object{
        var apiservice: Apiservice?=null;
        fun getApiClient(): Apiservice {
            if(apiservice==null){
                apiservice= RetrofitClient.retrofit().create(Apiservice::class.java)
                Log.d("apiservice", apiservice.toString());
                return apiservice!!;
            }
            return  apiservice!!;
        }

    }
}