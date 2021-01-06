package com.example.mvvmexample.api

import com.example.mvvmexample.entities.PostEntity
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface Api {

    @GET("/posts")
    fun getRequest(): Observable<List<PostEntity>>

}