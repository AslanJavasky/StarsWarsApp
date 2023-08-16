package com.aslanjavasky.montekrist_test.starswars.domain.usecases

import com.aslanjavasky.montekrist_test.starswars.domain.models.PeopleItem
import com.aslanjavasky.montekrist_test.starswars.domain.models.PlanetItem
import com.aslanjavasky.montekrist_test.starswars.domain.repos.PeopleRepo
import com.aslanjavasky.montekrist_test.starswars.domain.repos.PlanetRepo
import javax.inject.Inject

class RemovePlanetItemUseCase @Inject constructor(
    private val repo: PlanetRepo
) {
    suspend operator fun invoke(planetItem: PlanetItem){
        repo.removePlanetItem(planetItem)
    }
}