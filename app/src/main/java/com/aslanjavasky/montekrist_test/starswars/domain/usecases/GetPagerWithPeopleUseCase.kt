package com.aslanjavasky.montekrist_test.starswars.domain.usecases

import com.aslanjavasky.montekrist_test.starswars.domain.repos.PeopleRepo
import javax.inject.Inject

class GetPagerWithPeopleUseCase @Inject constructor(
    private val repo: PeopleRepo
) {
    operator fun invoke() = repo.getPager()

}