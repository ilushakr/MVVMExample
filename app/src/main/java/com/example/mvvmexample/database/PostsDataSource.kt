package com.example.mvvmexample.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmexample.entities.PostEntity
import com.example.mvvmexample.entities.PostEntityDB
import javax.inject.Inject

class PostsDataSource @Inject constructor(private val postDao: PostDao) : PostRepository {

    val posts = MutableLiveData<List<PostEntityDB>>()

    override fun insertPosts(posts: List<PostEntityDB>) = postDao.insertPost(posts)

    override fun getPosts() = postDao.getPosts()

}