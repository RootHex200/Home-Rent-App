package com.example.homprent.src.core.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.homprent.src.feature.homerent.domain.usecase.HotelUseCases
import com.example.homprent.src.feature.homerent.presentation.viewmodel.HotelListViewModel

class HotelListViewModelFactory(private val hotelUseCases: HotelUseCases) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HotelListViewModel::class.java)) {
            return HotelListViewModel(hotelUseCases) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}