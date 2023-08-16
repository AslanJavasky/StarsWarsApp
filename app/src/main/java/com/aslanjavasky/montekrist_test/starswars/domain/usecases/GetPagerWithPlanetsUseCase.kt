package com.aslanjavasky.montekrist_test.starswars.domain.usecases

import com.aslanjavasky.montekrist_test.starswars.domain.repos.PlanetRepo
import javax.inject.Inject

class GetPagerWithPlanetsUseCase @Inject constructor(
    private val repo:PlanetRepo
) {
    operator fun invoke() = repo.getPager()
}

