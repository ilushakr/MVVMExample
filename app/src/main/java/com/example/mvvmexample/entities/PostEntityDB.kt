package com.example.mvvmexample.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class PostEntityDB (
    @PrimaryKey
    var id: Int? = null,

    @ColumnInfo
    var userId: Int? = null,

    @ColumnInfo
    var title: String? = null,

    @ColumnInfo
    var body: String? = null

)