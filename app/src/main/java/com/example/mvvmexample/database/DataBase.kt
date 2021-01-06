package com.example.mvvmexample.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmexample.entities.PostEntity
import com.example.mvvmexample.entities.PostEntityDB

@Database(
    entities = [PostEntityDB::class],
    version = 1,
    exportSchema = false
)
abstract class DataBase : RoomDatabase() {
    abstract fun postDao(): PostDao
}