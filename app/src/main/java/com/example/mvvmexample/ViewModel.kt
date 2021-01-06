package com.example.mvvmexample

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.base.App
import com.example.mvvmexample.entities.PostEntity
import com.example.mvvmexample.entities.PostEntityDB
import com.example.mvvmexample.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ViewModel(context: Context) : ViewModel(){

    @Inject
    lateinit var repository: Repository

    var data = MutableLiveData<List<PostEntityDB>>()

    init {
        App[context].injector?.injectViewModel(this)
    }

    fun getPosts() : LiveData<List<PostEntityDB>>{
        repository.getPosts().observeOn(AndroidSchedulers.mainThread())
            .subscribe { notes: List<PostEntity> ->
                this.setNotesToDb(notes)
            }
        return data
    }

    private fun setNotesToDb(list: List<PostEntity>){
        var l = mutableListOf<PostEntityDB>()
        list.forEach {
            l.add(PostEntityDB(userId = it.userId, title = it.title, body = it.body, id = it.id))
        }
        repository.insertPosts(l).subscribeOn(Schedulers.newThread())
            .subscribe { id ->
                println(id)
                repository.getPostsFromDB().observeOn(AndroidSchedulers.mainThread())
                    .subscribe { notes ->
                        data.value = notes
                    }
            }
    }
}