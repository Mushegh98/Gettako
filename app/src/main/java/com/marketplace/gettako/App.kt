package com.marketplace.gettako

import android.app.Application
import com.marketplace.data.di.apiModule
import com.marketplace.data.di.repositoryModule
import com.marketplace.data.di.serviceModule
import com.marketplace.domain.di.interactorModule
import com.marketplace.gettako.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

/**
 * Created by Mushegh Sahakyan on 2/14/2022.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            modules(modules)
        }
    }

    private val modules = listOf<Module>(
        viewModelModule,
        interactorModule,
        apiModule,
        repositoryModule,
        serviceModule
    )
}