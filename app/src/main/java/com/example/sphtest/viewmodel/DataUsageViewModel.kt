package com.example.sphtest.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sphtest.data.result.Result
import com.example.sphtest.domain.usecase.DataUsageListUseCase
import com.example.sphtest.domain.Entity.DataUsageEntity
import kotlinx.coroutines.launch

class DataUsageViewModel(private val dataUsageListUseCase: DataUsageListUseCase) : ViewModel() {

    val isLoadingLiveData: MutableLiveData<Boolean> = MutableLiveData()
    private val dataUsageListLiveData: MutableLiveData<MutableList<DataUsageEntity>> =
        MutableLiveData()

    val datausageList: MutableLiveData<MutableList<DataUsageEntity>>
        get() = dataUsageListLiveData



    init {
        initAPIService()
    }

    private fun initAPIService() {
        viewModelScope.launch {
            updateLiveData(dataUsageListUseCase.getDataUsageList(59))
        }
    }

    private fun updateLiveData(dataUsageList: Result<MutableList<DataUsageEntity>>) {
        dataUsageListLiveData.postValue(dataUsageList.data)
    }



}