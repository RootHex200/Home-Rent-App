package com.example.homprent.src.core.common

interface RequestCompleteListener<T> {

    fun onSuccess(data:T);

    fun onFailed(error:String)

}