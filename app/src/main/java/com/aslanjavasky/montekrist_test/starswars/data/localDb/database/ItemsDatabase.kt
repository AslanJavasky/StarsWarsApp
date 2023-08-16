package com.aslanjavasky.montekrist_test.starswars.data.localDb.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aslanjavasky.montekrist_test.starswars.data.localDb.dao.ItemDao
import com.aslanjavasky.montekrist_test.starswars.data.localDb.entity.ItemDbModel
import dagger.hilt.android.qualifiers.ApplicationContext

@Database(entities = [ItemDbModel::class], version = 1, exportSchema = false)
abstract class ItemsDatabase:RoomDatabase() {
    abstract fun dao():ItemDao

    companion object {
        private var INSTANCE: ItemsDatabase? = null
        private const val DB_NAME = "items.db"
        private val LOCK = Any()

        fun getInstance(@ApplicationContext application: Application): ItemsDatabase {
            INSTANCE?.let { db ->
                return db
            }

            synchronized(LOCK) {
                INSTANCE?.let { db ->
                    return db
                }
                val db = Room.databaseBuilder(
                    application,
                    ItemsDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = db
                return db
            }
        }
    }


}