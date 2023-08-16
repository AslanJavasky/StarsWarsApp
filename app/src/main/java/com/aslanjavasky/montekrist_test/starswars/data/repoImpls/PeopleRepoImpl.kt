package com.aslanjavasky.montekrist_test.starswars.data.repoImpls

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.aslanjavasky.montekrist_test.starswars.data.localDb.dao.ItemDao
import com.aslanjavasky.montekrist_test.starswars.data.localDb.mapper.MapperDbModel
import com.aslanjavasky.montekrist_test.starswars.data.network.datasources.PagingSourcePeople
import com.aslanjavasky.montekrist_test.starswars.domain.models.PeopleItem
import com.aslanjavasky.montekrist_test.starswars.domain.repos.PeopleRepo
import javax.inject.Inject

class PeopleRepoImpl @Inject constructor(
    private val pagingSourcePeople: PagingSourcePeople,
    private val dao: ItemDao,
    private val mapper: MapperDbModel
) : PeopleRepo {

    override fun getPager() = Pager(
        config = PagingConfig(ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { pagingSourcePeople }
    )

    override suspend fun getPeopleFromDb(): List<PeopleItem> {
        return dao.getAllItemsByType(MapperDbModel.PEOPLE_TYPE).map {
            mapper.mapDbModelToPeopleItem(it)
        }
    }

    override suspend fun insertPeopleItemToDb(peopleItem: PeopleItem) {
        dao.insertItem(
            mapper.mapPeopleToDbModel(peopleItem)
        )
    }

    override suspend fun changeFavouriteState(peopleItem: PeopleItem) {
        dao.insertItem(
            mapper.mapPeopleToDbModel(
                peopleItem.copy(
                    isFavourite = !peopleItem.isFavourite
                )
            )
        )
    }

    override suspend fun removePeopleItem(peopleItem: PeopleItem) {
        dao.removeItem(peopleItem.name, MapperDbModel.PEOPLE_TYPE)
    }

    companion object {
        private const val ITEMS_PER_PAGE = 10
    }
}