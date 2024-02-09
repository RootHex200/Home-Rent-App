package com.example.homprent.src.feature.homerent.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homprent.src.core.common.RequestCompleteListener
import com.example.homprent.src.feature.homerent.data.model.BestPlace
import com.example.homprent.src.feature.homerent.data.model.HotelModelClass
import com.example.homprent.src.feature.homerent.data.model.NearPlace
import com.example.homprent.src.feature.homerent.domain.usecase.HotelUseCases

class HotelListViewModel(private val useCases: HotelUseCases):ViewModel() {
    val nearHotelList = MutableLiveData<List<NearPlace>>();
    val bestHotelList = MutableLiveData<List<BestPlace>>();
    var isLoading=MutableLiveData<Boolean>();
    var failedString =MutableLiveData<String>();

    fun getHotelListData(locationName:String){
        isLoading.value=true;
        useCases.getHotelList(locationName,object :RequestCompleteListener<HotelModelClass>{
            override fun onSuccess(data: HotelModelClass) {

                nearHotelList.value=data[0].near_place
                bestHotelList.value=data[0].best_place
                isLoading.value=false;
            }
            override fun onFailed(error: String) {
                failedString.value=error.toString();
            }
        })
    }
}