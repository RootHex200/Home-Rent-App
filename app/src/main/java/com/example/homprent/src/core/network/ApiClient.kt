package com.example.homprent.src.core.network

import android.util.Log

class ApiClient private constructor(){
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