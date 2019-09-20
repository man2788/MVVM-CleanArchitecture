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
    val data = MockData.loadResponse()

    @Test
    fun verifyUseCaseCallRepository() {
        runBlocking {
            given(apiServiceRepository.getDataUsageList(Constants.PAGE_LIMIT))
                .willReturn(Result.success(data))
            getDataListUseCase.getDataUsageList(Constants.PAGE_LIMIT, {}, {})
            verify(apiServiceRepository, times(1)).getDataUsageList(Constants.PAGE_LIMIT)
        }
    }

    @Test
    fun verifyResultWhenRepoMockReturnSuccessState() {
        runBlocking {
            val result = Result.success(data)
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

    @Test
    fun verifyTheYearIsSortedFromResponse() {
        runBlocking {
            val realResult = getDataListUseCase.prepareData(Result.success(data)).map {
                it.yName }
            val expectedResult = listOf("2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004")
            Assert.assertEquals(expectedResult,realResult)
        }
    }

}




