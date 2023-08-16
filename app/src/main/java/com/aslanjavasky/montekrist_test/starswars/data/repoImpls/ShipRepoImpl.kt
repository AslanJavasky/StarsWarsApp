package com.aslanjavasky.montekrist_test.starswars.data.repoImpls

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.aslanjavasky.montekrist_test.starswars.data.localDb.dao.ItemDao
import com.aslanjavasky.montekrist_test.starswars.data.localDb.mapper.MapperDbModel
import com.aslanjavasky.montekrist_test.starswars.data.network.datasources.PagingSourceShips
import com.aslanjavasky.montekrist_test.starswars.domain.models.ShipItem
import com.aslanjavasky.montekrist_test.starswars.domain.repos.ShipRepo
import javax.inject.Inject

class ShipRepoImpl @Inject constructor(
    private val pagingSourceShips: PagingSourceShips,
    private val dao: ItemDao,
    private val mapper: MapperDbModel
) : ShipRepo {
    override fun getPager() = Pager(
        config = PagingConfig(ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { pagingSourceShips }
    )

    override suspend fun getShipsFromDb(): List<ShipItem> {
        return dao.getAllItemsByType(MapperDbModel.SHIP_TYPE).map {
            mapper.mapDbModelToShipItem(it)
        }
    }

    override suspend fun insertShipItemToDb(shipItem: ShipItem) {
        dao.insertItem(
            mapper.mapShipToDbModel(shipItem)
        )
    }

    override suspend fun changeFavouriteState(shipItem: ShipItem) {
        dao.insertItem(
            mapper.mapShipToDbModel(
                shipItem.copy(
                    isFavourite = !shipItem.isFavourite
                )
            )
        )
    }

    override suspend fun removeShipItem(shipItem: ShipItem) {
        dao.removeItem(shipItem.name, MapperDbModel.SHIP_TYPE)
    }

    companion object {
        private const val ITEMS_PER_PAGE = 10
    }
}