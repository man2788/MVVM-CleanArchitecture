package com.example.sphtest


import com.example.sphtest.Utils.MockData
import com.example.sphtest.constants.Constants
import com.example.sphtest.constants.NetworkError
import com.example.sphtest.data.api.ApiServiceRepository
import com.example.sphtest.data.result.Result
import com.example.sphtest.data.result.ResultTypes
import com.example.sphtest.domain.usecase.DataUsageListUseCase
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test



class DataUsageListUseCaseTest {
    private val apiServiceRepository: ApiServiceRepository = mock()
    private val getDataListUseCase = DataUsageListUseCase(apiServiceRepository)

    @Test
    fun verifyUseCaseCallRepository() {
        runBlocking {
            given(apiServiceRepository.getDataUsageList(Constants.PAGE_LIMIT))
                .willReturn(Result.success(MockData.loadResponse()))
            getDataListUseCase.getDataUsageList(Constants.PAGE_LIMIT,{},{})
            verify(apiServiceRepository, times(1)).getDataUsageList(Constants.PAGE_LIMIT)
        }
    }

    @Test
    fun verifyResultWhenRepoMockReturnSuccessState() {
        runBlocking {
            val result = Result.success(MockData.loadResponse())
            given(apiServiceRepository.getDataUsageList(Constants.PAGE_LIMIT)).willReturn(result)
            val expectedResult = ResultTypes.SUCCESS
            val realResult = result.resultType
            Assert.assertEquals(expectedResult, realResult)
        }
    }

    @Test
    fun <T> verifyBusinessErrorWhenRepoMockReturnNetworkError() {
        runBlocking {
            given(apiServiceRepository.getDataUsageList(Constants.PAGE_LIMIT))
                .willReturn(Result.error(NetworkError.API_ERROR))
            val realResult = Result.error<T>(NetworkError.API_ERROR).error
            val expectedResult = NetworkError.API_ERROR
            Assert.assertEquals(expectedResult, realResult)
        }
    }

}




