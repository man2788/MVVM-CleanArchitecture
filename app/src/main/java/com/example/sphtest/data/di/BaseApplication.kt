package com.example.sphtest.data.di

import android.app.Application
import android.content.Context
import com.example.sphtest.data.di.BaseModule
import com.example.sphtest.data.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        initKoin()
    }
    private fun initKoin() {
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                    listOf(
                            BaseModule.mainModule,
                            NetworkModule.retrofitModule
                    )
            )
        }
    }
    companion object {
        lateinit  var appContext: Context
    }

}