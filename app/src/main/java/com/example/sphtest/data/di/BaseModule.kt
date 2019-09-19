package com.example.sphtest.data.di

import com.example.sphtest.data.api.ApiServiceRepository
import com.example.sphtest.data.api.RetrofitEndpoint
import com.example.sphtest.domain.usecase.DataUsageListUseCase
import com.example.sphtest.viewmodel.DataUsageViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

@ExperimentalCoroutinesApi
object BaseModule {

    val mainModule = module {
        factory { provideApiService(get()) }
        factory { ApiServiceRepository(apiService = get()) }
        factory { DataUsageListUseCase(apiServiceRepo = get()) }
        viewModel { DataUsageViewModel(dataUsageListUseCase = get()) }
    }

    private fun provideApiService(retrofit: Retrofit): RetrofitEndpoint {
        return retrofit.create(RetrofitEndpoint::class.java)
    }

}