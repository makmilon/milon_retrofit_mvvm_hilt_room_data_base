package com.example.mvvmwithhiltwithretrofit.di

import com.example.mvvmwithhiltwithretrofit.netWork.RetroInstance
import com.example.mvvmwithhiltwithretrofit.netWork.dataClass.api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    val baseUrl="https://run.mocky.io/"

    @Singleton
    @Provides
    fun getRetroServiceInstance(retrofit: Retrofit): RetroInstance{
        return retrofit.create(RetroInstance::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit{

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}