package com.example.sphtest.domain.usecase

import DataUsageResponse
import com.example.sphtest.constants.NetworkError
import com.example.sphtest.data.api.ApiServiceRepository
import com.example.sphtest.data.result.Result
import com.example.sphtest.data.result.ResultTypes
import com.example.sphtest.domain.Entity.DataUsageEntity
import kotlin.collections.HashMap
import kotlin.collections.HashSet


class DataUsageListUseCase(private val apiServiceRepo: ApiServiceRepository) {
    private lateinit var result: Result<MutableList<DataUsageEntity>>
    var finalDataUsageList = mutableListOf<DataUsageEntity>()

    suspend fun getDataUsageList(pageLimit: Int): Result<MutableList<DataUsageEntity>> {
        val response = apiServiceRepo.getDataUsageList(pageLimit)
        result = if (response.resultType == ResultTypes.SUCCESS) {
            Result.success(prepareDataList(response))
        } else {
            Result.error(NetworkError.API_ERROR)
        }
        return result
    }

    private fun prepareDataList(response: Result<DataUsageResponse>): MutableList<DataUsageEntity>? {
        var recordItemByYear = response!!.data!!.result.records
        var recordsByYear: MutableList<Triple<String, String, Double>> = mutableListOf()
        var sortedHashMap = HashMap<String, List<Triple<String, String, Double>>>()
        val yearHashSet = HashSet<String>()
        recordItemByYear.forEach { item ->
            val splitItem = item.quarter.split("-")
            var year = splitItem[0]
            var quarter = splitItem[1]
            yearHashSet.add(year)
            recordsByYear.add(Triple(year, quarter, item.volume_of_mobile_data))
        }
        yearHashSet.forEach { year ->
            val data = recordsByYear.let { it ->
                it.filter {
                    it.first == year
                }
            }
            sortedHashMap[year] = data
        }
        prepareDataUsageList(sortedHashMap)
        return finalDataUsageList
    }

    private fun prepareDataUsageList(sortedHashMap: HashMap<String, List<Triple<String, String, Double>>>): MutableList<DataUsageEntity> {
        sortedHashMap.forEach {
            prepareFinalList(it)
        }
        return finalDataUsageList
    }

    private fun prepareFinalList(it: Map.Entry<String, List<Triple<String, String, Double>>>) {
        var year = it.key.toInt()
        var quarters = it.value.map {
            (it.third)
        }

        var totalDataUsage = it.value.sumByDouble {
            it.third
        }

        finalDataUsageList.add(DataUsageEntity(year, quarters, totalDataUsage, false))
    }

}

