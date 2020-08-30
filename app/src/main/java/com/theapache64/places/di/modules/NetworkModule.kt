package com.theapache64.places.di.modules

import com.theapache64.places.data.remote.ApiInterface
import com.theapache64.places.utils.calladapter.flow.FlowResourceCallAdapterFactory
import com.theapache64.retrosheet.RetrosheetInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by theapache64 : Aug 29 Sat,2020 @ 10:14
 */
@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    @Provides
    fun provideRetrosheetInterceptor(): RetrosheetInterceptor {
        return RetrosheetInterceptor.Builder()
            .addSheet("names", "name")
            .build()
    }

    @Provides
    fun provideOkHttpClient(retrosheetInterceptor: RetrosheetInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(retrosheetInterceptor)
            .build()
    }

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://docs.google.com/spreadsheets/d/1P5SQzhO5GKrz60QkNInfFK3V-xr18m92LHD5oeqihPM/")
            .client(okHttpClient)
            .addCallAdapterFactory(FlowResourceCallAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApi(retrofit: Retrofit): ApiInterface {
        return retrofit
            .create(ApiInterface::class.java)
    }
}