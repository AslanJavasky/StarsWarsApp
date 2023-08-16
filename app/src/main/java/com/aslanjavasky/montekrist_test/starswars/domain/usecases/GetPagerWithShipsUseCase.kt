package com.aslanjavasky.montekrist_test.starswars.domain.usecases

import com.aslanjavasky.montekrist_test.starswars.domain.repos.ShipRepo
import javax.inject.Inject

class GetPagerWithShipsUseCase @Inject constructor(
    private val repo: ShipRepo
) {
    operator fun invoke() = repo.getPager()
}