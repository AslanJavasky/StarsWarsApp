package com.aslanjavasky.montekrist_test.starswars.domain.repos

import androidx.paging.Pager
import com.aslanjavasky.montekrist_test.starswars.domain.models.PeopleItem
import com.aslanjavasky.montekrist_test.starswars.domain.models.PlanetItem
import com.aslanjavasky.montekrist_test.starswars.domain.models.ShipItem

interface ShipRepo {
    fun getPager(): Pager<Int, ShipItem>
    suspend fun getShipsFromDb(): List<ShipItem>
    suspend fun insertShipItemToDb(shipItem: ShipItem)
    suspend fun changeFavouriteState(shipItem: ShipItem)
    suspend fun removeShipItem(shipItem: ShipItem)
}