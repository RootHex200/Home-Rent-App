package com.example.homprent.src.core.network

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {
    companion object{
        var retrofit: Retrofit?=null;
        fun retrofit(): Retrofit {
            if(retrofit==null){
                retrofit= Retrofit.Builder().baseUrl("http://192.168.1.21:3000/").addConverterFactory(GsonConverterFactory.create()).build()
                Log.d("retrofitclient", retrofit.toString());
                return retrofit!!;
            }
            return  retrofit!!;
        }
    }
}