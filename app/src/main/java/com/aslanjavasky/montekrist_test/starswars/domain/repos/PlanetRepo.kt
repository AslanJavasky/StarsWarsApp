package com.aslanjavasky.montekrist_test.starswars.domain.repos

import androidx.paging.Pager
import com.aslanjavasky.montekrist_test.starswars.domain.models.PeopleItem
import com.aslanjavasky.montekrist_test.starswars.domain.models.PlanetItem

interface PlanetRepo {
    fun getPager(): Pager<Int, PlanetItem>
    suspend fun getPlanetsFromDb(): List<PlanetItem>
    suspend fun insertPlanetItemToDb(planetItem: PlanetItem)
    suspend fun changeFavouriteState(planetItem: PlanetItem)
    suspend fun removePlanetItem(planetItem: PlanetItem)
}