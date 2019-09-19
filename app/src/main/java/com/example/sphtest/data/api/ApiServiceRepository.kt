package com.example.sphtest.data.api

import DataUsageResponse
import com.example.sphtest.data.result.Result
import com.example.sphtest.constants.NetworkError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class ApiServiceRepository(private val apiService: RetrofitEndpoint) {
    lateinit var result : Result<DataUsageResponse>

    suspend fun getDataUsageList(pageLimit: Int): Result<DataUsageResponse> {
        withContext(Dispatchers.IO) {
            try {
                val request = apiService.getDataUsageListAsync(pageLimit)
                val response = request?.await()
                request?.let {
                    if (it.isCompleted) result = Result.success(response)
                    else if (it.isCancelled) result =
                            Result.error(NetworkError.API_ERROR)
                }
            } catch (ex: Exception) {
                result = Result.error(NetworkError.API_ERROR)
            }
        }

        return result
    }

}