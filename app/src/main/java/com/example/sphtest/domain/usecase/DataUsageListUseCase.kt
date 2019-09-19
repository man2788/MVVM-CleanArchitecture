package com.example.sphtest.domain.usecase

import DataUsageResponse
import com.example.sphtest.data.api.ApiServiceRepository
import com.example.sphtest.data.result.Result
import com.example.sphtest.data.result.ResultTypes
import com.example.sphtest.domain.Entity.Quarter
import com.example.sphtest.domain.Entity.Year
import quarterName
import year

class DataUsageListUseCase(private val apiServiceRepo: ApiServiceRepository) {
    suspend fun getDataUsageList(
        pageLimit: Int,
        onSuccess: (List<Year>) -> Unit,
        onError: () -> Unit
    ) {
        val response = apiServiceRepo.getDataUsageList(pageLimit)
        if (response.resultType == ResultTypes.SUCCESS) {
            onSuccess.invoke(prepareData(response))
        } else {
            onError.invoke()
        }
    }

    private fun prepareData(response: Result<DataUsageResponse>) =
        /*  Split the result data by Year add to to the entity class and sort by the year*/
        response.data?.result?.records?.groupBy {
            it.year()
        }?.map { item ->
            Year(
                item.value.map {
                    Quarter(it.quarterName(), it.volume_of_mobile_data, it._id) },
                item.key
            )
        }?.sortedByDescending { it.yName } ?: listOf()

}

