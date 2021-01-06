package com.example.mvvmexample.modules

import android.content.Context
import com.example.mvvmexample.api.Api
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    private var apiBuilder: Api

    init {
        apiBuilder = initRetrofit().create<Api>(Api::class.java)
    }

    @Singleton
    @Provides
    fun providesApiEndPoints(): Api {
        return apiBuilder
    }

    companion object {
        fun initRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
        }
    }
}