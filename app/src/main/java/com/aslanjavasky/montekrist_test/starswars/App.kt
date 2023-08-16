package com.aslanjavasky.montekrist_test.starswars

import android.app.Application
import com.aslanjavasky.montekrist_test.starswars.data.localDb.database.ItemsDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    lateinit var db: ItemsDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        db = ItemsDatabase.getInstance(this)
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }
}