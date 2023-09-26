package com.accidentaldeveloper.hilt_example2.di

import com.accidentaldeveloper.hilt_example2.api.ApiServices
import com.accidentaldeveloper.hilt_example2.helper.AppConstant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseURL() = AppConstant.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance(BASE_URL: String):ApiServices = Retrofit
        .Builder()
        .baseUrl(provideBaseURL())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiServices::class.java)



}