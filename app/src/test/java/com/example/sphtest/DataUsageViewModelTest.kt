package com.example.sphtest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.sphtest.Utils.MainCoroutineRule
import com.example.sphtest.domain.usecase.DataUsageListUseCase
import com.example.sphtest.viewmodel.DataUsageViewModel
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class DataUsageViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Rule
    @JvmField
    val mainCoroutineRule = MainCoroutineRule()

    private var mockDataUsageListUseCase: DataUsageListUseCase = mock()
    private lateinit var mockViewModel: DataUsageViewModel

    @Test
    fun assertIsLoadingLiveData() {
        mockViewModel = DataUsageViewModel(mockDataUsageListUseCase)
        mockViewModel.isLoadingLiveData.value = true
        val realResult = mockViewModel.isLoadingLiveData.value
        Assert.assertEquals(true, realResult)
    }
}