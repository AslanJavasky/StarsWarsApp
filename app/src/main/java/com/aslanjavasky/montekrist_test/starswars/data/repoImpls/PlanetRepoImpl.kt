package com.aslanjavasky.montekrist_test.starswars.data.repoImpls

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.aslanjavasky.montekrist_test.starswars.data.localDb.dao.ItemDao
import com.aslanjavasky.montekrist_test.starswars.data.localDb.mapper.MapperDbModel
import com.aslanjavasky.montekrist_test.starswars.data.network.datasources.PagingSourcePlanets
import com.aslanjavasky.montekrist_test.starswars.domain.models.PlanetItem
import com.aslanjavasky.montekrist_test.starswars.domain.repos.PlanetRepo
import javax.inject.Inject

class PlanetRepoImpl @Inject constructor(
    private val pagingSourcePlanets: PagingSourcePlanets,
    private val dao: ItemDao,
    private val mapper: MapperDbModel
): PlanetRepo {
    override fun getPager()=Pager(
        config = PagingConfig(ITEMS_PER_PAGE,enablePlaceholders = false),
        pagingSourceFactory = {pagingSourcePlanets}
    )

    override suspend fun getPlanetsFromDb(): List<PlanetItem> {
        return dao.getAllItemsByType(MapperDbModel.PLANET_TYPE).map {
            mapper.mapDbModelToPlanetItem(it)
        }
    }

    override suspend fun insertPlanetItemToDb(planetItem: PlanetItem) {
        dao.insertItem(
            mapper.mapPlanetToDbModel(planetItem)
        )
    }

    override suspend fun changeFavouriteState(planetItem: PlanetItem) {
        dao.insertItem(
            mapper.mapPlanetToDbModel(
                planetItem.copy(
                    isFavourite = !planetItem.isFavourite
                )
            )
        )
    }

    override suspend fun removePlanetItem(planetItem: PlanetItem) {
        dao.removeItem(planetItem.name, MapperDbModel.PLANET_TYPE)
    }

    companion object {
        private const val ITEMS_PER_PAGE = 10
    }
}