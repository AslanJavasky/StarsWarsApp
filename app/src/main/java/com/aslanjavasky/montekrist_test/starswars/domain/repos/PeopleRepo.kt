package com.aslanjavasky.montekrist_test.starswars.domain.repos

import androidx.paging.Pager
import com.aslanjavasky.montekrist_test.starswars.domain.models.PeopleItem

interface PeopleRepo {
    fun getPager(): Pager<Int,PeopleItem>
    suspend fun getPeopleFromDb():List<PeopleItem>
    suspend fun insertPeopleItemToDb(peopleItem: PeopleItem)
    suspend fun changeFavouriteState(peopleItem: PeopleItem)
    suspend fun removePeopleItem(peopleItem: PeopleItem)

}