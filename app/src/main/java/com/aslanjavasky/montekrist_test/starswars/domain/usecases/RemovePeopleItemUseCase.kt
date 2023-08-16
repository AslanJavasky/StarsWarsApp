package com.aslanjavasky.montekrist_test.starswars.domain.usecases

import com.aslanjavasky.montekrist_test.starswars.domain.models.PeopleItem
import com.aslanjavasky.montekrist_test.starswars.domain.repos.PeopleRepo
import javax.inject.Inject

class RemovePeopleItemUseCase @Inject constructor(
    private val repo: PeopleRepo
) {
    suspend operator fun invoke(peopleItem: PeopleItem){
        repo.removePeopleItem(peopleItem)
    }
}