package com.example.mvvmexample.database

import com.example.mvvmexample.entities.PostEntityDB
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface PostRepository {

    fun insertPosts(posts : List<PostEntityDB>): Single<List<Long>>
    fun getPosts(): Observable<List<PostEntityDB>>
}