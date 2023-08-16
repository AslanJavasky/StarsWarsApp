package com.aslanjavasky.montekrist_test.starswars.data.repoImpls

import com.aslanjavasky.montekrist_test.starswars.data.localDb.dao.ItemDao
import com.aslanjavasky.montekrist_test.starswars.data.localDb.mapper.MapperDbModel
import com.aslanjavasky.montekrist_test.starswars.domain.models.FavouriteItem
import com.aslanjavasky.montekrist_test.starswars.domain.repos.FavouriteRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouriteRepoImpl @Inject constructor(
    private val dao: ItemDao,
    private val mapper: MapperDbModel
) : FavouriteRepo {

    override suspend fun getFavourites(): List<FavouriteItem> {

        return mapper.mapItemDbToFavouriteItem_list(
            dao.getAllItems()
        )
    }
}