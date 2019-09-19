package com.example.sphtest.data.api

import DataUsageResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitEndpoint {
    @GET("action/datastore_search?resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f")
    fun getDataUsageListAsync(@Query("limit") pageLimit: Int): Deferred<DataUsageResponse>
}