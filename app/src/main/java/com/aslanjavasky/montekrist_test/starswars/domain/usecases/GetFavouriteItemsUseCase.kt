package com.aslanjavasky.montekrist_test.starswars.domain.usecases

import com.aslanjavasky.montekrist_test.starswars.domain.repos.FavouriteRepo
import javax.inject.Inject

class GetFavouriteItemsUseCase @Inject constructor(
    private val repo: FavouriteRepo
) {
    suspend operator fun invoke()=repo.getFavourites()
}