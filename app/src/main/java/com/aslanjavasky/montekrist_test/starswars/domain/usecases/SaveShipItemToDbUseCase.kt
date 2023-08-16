package com.aslanjavasky.montekrist_test.starswars.domain.usecases

import com.aslanjavasky.montekrist_test.starswars.domain.models.PeopleItem
import com.aslanjavasky.montekrist_test.starswars.domain.models.ShipItem
import com.aslanjavasky.montekrist_test.starswars.domain.repos.PeopleRepo
import com.aslanjavasky.montekrist_test.starswars.domain.repos.ShipRepo
import javax.inject.Inject

class SaveShipItemToDbUseCase @Inject constructor(
    private val repo: ShipRepo
) {
    suspend operator fun invoke(shipItem: ShipItem) =
        repo.insertShipItemToDb(shipItem)
}