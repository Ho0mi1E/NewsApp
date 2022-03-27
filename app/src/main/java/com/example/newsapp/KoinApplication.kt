package com.example.newsapp

import android.app.Application
import com.example.newsapp.data.di.dataModule
import com.example.newsapp.domain.di.domainModule
import com.example.newsapp.presentation.di.viewModelModule
import org.koin.core.context.startKoin

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(viewModelModule, domainModule, dataModule))
        }
    }
}