package com.example.mvvmexample.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmexample.entities.PostEntity
import com.example.mvvmexample.entities.PostEntityDB
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(posts : List<PostEntityDB>) : Single<List<Long>>

    @Query("SELECT * FROM PostEntityDB")
    fun getPosts(): Observable<List<PostEntityDB>>

    @Query("DELETE FROM PostEntityDB")
    suspend fun delete()
}