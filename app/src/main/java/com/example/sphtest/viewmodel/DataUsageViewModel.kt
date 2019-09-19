package com.example.sphtest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sphtest.domain.usecase.DataUsageListUseCase
import com.example.sphtest.domain.Entity.Year
import kotlinx.coroutines.launch

class DataUsageViewModel(private val dataUsageListUseCase: DataUsageListUseCase) : ViewModel() {
    val isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val dataUsageListLiveData: MutableLiveData<List<Year>> = MutableLiveData()

    init {
        initAPIService()
    }

    private fun initAPIService() {
        viewModelScope.launch {
            isLoadingLiveData.postValue(true)
            dataUsageListUseCase.getDataUsageList(59, {
                dataUsageListLiveData.postValue(it)
                isLoadingLiveData.postValue(false)
            }, {
                isLoadingLiveData.postValue(false)
                /*Handle Error*/
            })
        }
    }

}