package com.aslanjavasky.montekrist_test.starswars.domain.repos

import com.aslanjavasky.montekrist_test.starswars.domain.models.FavouriteItem
import kotlinx.coroutines.flow.Flow

interface FavouriteRepo {
    suspend fun getFavourites(): List<FavouriteItem>
}