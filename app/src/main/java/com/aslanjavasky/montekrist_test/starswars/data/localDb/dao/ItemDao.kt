package com.aslanjavasky.montekrist_test.starswars.data.localDb.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.aslanjavasky.montekrist_test.starswars.data.localDb.entity.ItemDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM items")
    suspend fun getAllItems(): List<ItemDbModel>

    @Query("SELECT * FROM items WHERE type=:type")
    suspend fun getAllItemsByType(type:String): List<ItemDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(itemDbModel: ItemDbModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateItem(itemDbModel: ItemDbModel)

    @Query("DELETE FROM items WHERE name=:name AND type=:type")
    suspend fun removeItem(name:String, type:String)
}