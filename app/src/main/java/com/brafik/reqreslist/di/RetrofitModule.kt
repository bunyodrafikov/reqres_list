package com.brafik.reqreslist.di

import com.brafik.reqreslist.data.network.ReqresAPI
import com.brafik.reqreslist.data.network.RetrofitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {
    private val BASE_URL = "https://reqres.in/api/"

    @Provides
    @Singleton
    fun provideRetrofitClient(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Provides
    fun provideRetrofitRepository(reqresAPI: ReqresAPI): RetrofitRepository = RetrofitRepository(reqresAPI)

    @Provides
    fun provideReqresAPI(retrofit: Retrofit): ReqresAPI = retrofit.create(ReqresAPI::class.java)
}