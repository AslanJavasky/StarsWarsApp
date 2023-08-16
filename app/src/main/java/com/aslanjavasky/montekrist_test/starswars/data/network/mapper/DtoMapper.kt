package com.aslanjavasky.montekrist_test.starswars.data.network.mapper

import com.aslanjavasky.montekrist_test.starswars.data.network.dto.PeopleDto
import com.aslanjavasky.montekrist_test.starswars.data.network.dto.PlanetDto
import com.aslanjavasky.montekrist_test.starswars.data.network.dto.ShipDto
import com.aslanjavasky.montekrist_test.starswars.domain.models.PeopleItem
import com.aslanjavasky.montekrist_test.starswars.domain.models.PlanetItem
import com.aslanjavasky.montekrist_test.starswars.domain.models.ShipItem
import java.util.UUID
import javax.inject.Inject

class DtoMapper @Inject constructor() {

    fun mapPeopleDtoToDomainItem(peopleDto: PeopleDto) = PeopleItem(
        peopleDto.birth_year,
        peopleDto.created,
        peopleDto.edited,
        peopleDto.eye_color,
        peopleDto.films,
        peopleDto.gender,
        peopleDto.hair_color,
        peopleDto.height,
        peopleDto.homeworld,
        peopleDto.mass,
        peopleDto.name,
        peopleDto.skin_color,
        peopleDto.species,
        peopleDto.starships,
        peopleDto.url,
        peopleDto.vehicles,
        peopleDto.id,
        peopleDto.isFavourite
    )

    fun mapPeopleDomainItemToDto(peopleItem: PeopleItem) = PeopleDto(
        peopleItem.birth_year,
        peopleItem.created,
        peopleItem.edited,
        peopleItem.eye_color,
        peopleItem.films,
        peopleItem.gender,
        peopleItem.hair_color,
        peopleItem.height,
        peopleItem.homeworld,
        peopleItem.mass,
        peopleItem.name,
        peopleItem.skin_color,
        peopleItem.species,
        peopleItem.starships,
        peopleItem.url,
        peopleItem.vehicles,
        peopleItem.id,
        peopleItem.isFavourite
    )

    fun mapPlanetDtoToDomainItem(planetDto: PlanetDto) = PlanetItem(
        planetDto.climate,
        planetDto.created,
        planetDto.diameter,
        planetDto.edited,
        planetDto.films,
        planetDto.gravity,
        planetDto.name,
        planetDto.orbital_period,
        planetDto.population,
        planetDto.residents,
        planetDto.rotation_period,
        planetDto.rotation_period,
        planetDto.terrain,
        planetDto.url,
        planetDto.id,
        planetDto.isFavourite
    )

    fun mapPlanetDomainItemToDto(planetItem: PlanetItem) = PlanetDto(
        planetItem.climate,
        planetItem.created,
        planetItem.diameter,
        planetItem.edited,
        planetItem.films,
        planetItem.gravity,
        planetItem.name,
        planetItem.orbital_period,
        planetItem.population,
        planetItem.residents,
        planetItem.rotation_period,
        planetItem.rotation_period,
        planetItem.terrain,
        planetItem.url,
        planetItem.id,
        planetItem.isFavourite
    )

    fun mapShipDtoToDomainItem(shipDto: ShipDto) = ShipItem(
        shipDto.MGLT,
        shipDto.cargo_capacity,
        shipDto.consumables,
        shipDto.cost_in_credits,
        shipDto.created,
        shipDto.crew,
        shipDto.edited,
        shipDto.films,
        shipDto.hyperdrive_rating,
        shipDto.length,
        shipDto.manufacturer,
        shipDto.hyperdrive_rating,
        shipDto.model,
        shipDto.name,
        shipDto.passengers,
        shipDto.pilots,
        shipDto.starship_class,
        shipDto.url,
        shipDto.id,
        shipDto.isFavourite
    )

    fun mapShipDomainItemToDto(shipItem: ShipItem) = ShipDto(
        shipItem.MGLT,
        shipItem.cargo_capacity,
        shipItem.consumables,
        shipItem.cost_in_credits,
        shipItem.created,
        shipItem.crew,
        shipItem.edited,
        shipItem.films,
        shipItem.hyperdrive_rating,
        shipItem.length,
        shipItem.manufacturer,
        shipItem.hyperdrive_rating,
        shipItem.model,
        shipItem.name,
        shipItem.passengers,
        shipItem.pilots,
        shipItem.starship_class,
        shipItem.url,
        shipItem.id,
        shipItem.isFavourite
    )

}