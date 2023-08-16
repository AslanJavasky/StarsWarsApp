package com.aslanjavasky.montekrist_test.starswars.di

import android.app.Application
import com.aslanjavasky.montekrist_test.starswars.App
import com.aslanjavasky.montekrist_test.starswars.data.localDb.dao.ItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class HiltModule {

    @Provides
    fun provideCharacterDao(application: Application): ItemDao {
        return App.INSTANCE.db.dao()
    }

}