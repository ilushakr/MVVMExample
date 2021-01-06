package com.example.mvvmexample.repository

import android.content.Context
import com.example.mvvmexample.api.Api
import com.example.mvvmexample.base.App
import com.example.mvvmexample.database.PostRepository
import com.example.mvvmexample.entities.PostEntity
import com.example.mvvmexample.entities.PostEntityDB
import javax.inject.Inject

class Repository @Inject constructor(context: Context) {

    @Inject
    lateinit var api : Api

    @Inject
    lateinit var postRepository : PostRepository

    init {
        App[context].injector?.injectRepository(this)
    }

    fun getPosts() = api.getRequest()

    fun insertPosts(posts : List<PostEntityDB>) = postRepository.insertPosts(posts)

    fun getPostsFromDB() = postRepository.getPosts()
}