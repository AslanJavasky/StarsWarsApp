package com.aslanjavasky.montekrist_test.starswars.data.network.dto

import com.squareup.moshi.JsonClass
import java.util.UUID

@JsonClass(generateAdapter = true)
data class PlanetDto(
    val climate: String,
    val created: String,
    val diameter: String,
    val edited: String,
    val films: List<String>,
    val gravity: String,
    val name: String,
    val orbital_period: String,
    val population: String,
    val residents: List<Any>,
    val rotation_period: String,
    val surface_water: String,
    val terrain: String,
    val url: String,
    var id:String= UUID.randomUUID().toString(),
    var isFavourite: Boolean = false
)
