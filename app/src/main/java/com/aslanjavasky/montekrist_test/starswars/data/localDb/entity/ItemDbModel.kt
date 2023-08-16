package com.aslanjavasky.montekrist_test.starswars.data.localDb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ItemDbModel(
    @PrimaryKey
    val id:String,
    @ColumnInfo(name = "name")
    val name:String,
    @ColumnInfo(name = "field2")
    val field2:String,
    @ColumnInfo(name = "field3")
    val field3:String,
    @ColumnInfo(name="is_favourite")
    val isFavourite:Boolean,
    @ColumnInfo(name="type")
    val type:String
)
