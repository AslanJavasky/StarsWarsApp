package com.aslanjavasky.montekrist_test.starswars.di

import com.aslanjavasky.montekrist_test.starswars.data.repoImpls.FavouriteRepoImpl
import com.aslanjavasky.montekrist_test.starswars.data.repoImpls.PeopleRepoImpl
import com.aslanjavasky.montekrist_test.starswars.data.repoImpls.PlanetRepoImpl
import com.aslanjavasky.montekrist_test.starswars.data.repoImpls.ShipRepoImpl
import com.aslanjavasky.montekrist_test.starswars.domain.repos.FavouriteRepo
import com.aslanjavasky.montekrist_test.starswars.domain.repos.PeopleRepo
import com.aslanjavasky.montekrist_test.starswars.domain.repos.PlanetRepo
import com.aslanjavasky.montekrist_test.starswars.domain.repos.ShipRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BindImpls {

    @Binds
    fun bindsPlanetRepo(
        planetRepoImpl: PlanetRepoImpl
    ):PlanetRepo

    @Binds
    fun bindsPeopleRepo(
        peopleRepoImpl: PeopleRepoImpl
    ):PeopleRepo

    @Binds
    fun bindsShipRepo(
        shipRepoImpl: ShipRepoImpl
    ):ShipRepo

    @Binds
    fun bindsFavouriteRepo(
        favouriteRepoImpl: FavouriteRepoImpl
    ):FavouriteRepo
}