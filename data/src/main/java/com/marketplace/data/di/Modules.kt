package com.marketplace.data.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.marketplace.data.service.preferenceservice.PreferenceService
import com.marketplace.data.service.preferenceservice.PreferenceServiceImpl
import com.marketplace.data.service.retrofitservice.RetrofitService
import com.marketplace.data.util.BASE_URL
import com.marketplace.data.util.interceptor.HeaderInterceptor
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Mushegh Sahakyan on 2/14/2022.
 */
val apiModule = module {
    single { Moshi.Builder().build() }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .apply {
                client(
                    OkHttpClient.Builder()
                        .addNetworkInterceptor(StethoInterceptor())
                        .addInterceptor(HeaderInterceptor(get()))
                        .connectTimeout(120, TimeUnit.SECONDS)
                        .writeTimeout(120, TimeUnit.SECONDS)
                        .readTimeout(120, TimeUnit.SECONDS)
                        .retryOnConnectionFailure(true)
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.HEADERS
                        })
                        .build()
                )
            }
            .build()
    }

    single<RetrofitService> { get<Retrofit>().create(RetrofitService::class.java) }
//    single<BatteriesApiService> { get<Retrofit>().create(BatteriesApiService::class.java) }
//    single<VehicleApiService> { get<Retrofit>().create(VehicleApiService::class.java) }
//    single<MultiListService> { get<Retrofit>().create(MultiListService::class.java) }
//    single<LocationApiService> { get<Retrofit>().create(LocationApiService::class.java) }
//    single<MaintenanceApiService> { get<Retrofit>().create(MaintenanceApiService::class.java) }
}
//val databaseModule = module {
//    fun provideDatabase(application: Application): AppDatabase {
//        return Room.databaseBuilder(application, AppDatabase::class.java, "BikeDB")
//            .fallbackToDestructiveMigration()
//            .allowMainThreadQueries()
//            .build()
//    }
//    single { provideDatabase(androidApplication()) }
//    single { get<AppDatabase>().roomDao() }
//    single { get<AppDatabase>().readoutDAO() }
//    single { get<AppDatabase>().vegaDao() }
//    single { get<AppDatabase>().logisticsScanDao() }
//}

val repositoryModule = module {

}

val serviceModule = module {
    single<PreferenceService> { PreferenceServiceImpl(get()) }
}