package com.example.mvvmexample.modules

import android.content.Context
import androidx.room.Room
import com.example.mvvmexample.database.DataBase
import com.example.mvvmexample.database.PostDao
import com.example.mvvmexample.database.PostRepository
import com.example.mvvmexample.database.PostsDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(context: Context) {

    private var dataBase : DataBase = Room.databaseBuilder( context, DataBase::class.java, "data_base")
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun providesRoomDatabase(): DataBase {
        return dataBase
    }

    @Singleton
    @Provides
    fun providesPostDao(dataBase: DataBase): PostDao {
        return dataBase.postDao()
    }

    @Singleton
    @Provides
    fun postsRepository(postDao: PostDao): PostRepository {
        return PostsDataSource(postDao)
    }
}