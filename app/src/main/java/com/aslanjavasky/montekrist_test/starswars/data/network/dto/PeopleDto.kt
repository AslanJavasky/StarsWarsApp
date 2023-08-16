package com.aslanjavasky.montekrist_test.starswars.data.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.UUID

@JsonClass(generateAdapter = true)
data class PeopleDto (
    @Json(name = "birth_year")
    val birth_year: String,
    @Json(name = "created")
    val created: String,
    @Json(name = "edited")
    val edited: String,
    @Json(name = "eye_color")
    val eye_color: String,
    @Json(name = "films")
    val films: List<String>,
    @Json(name = "gender")
    val gender: String,
    @Json(name = "hair_color")
    val hair_color: String,
    @Json(name = "height")
    val height: String,
    @Json(name = "homeworld")
    val homeworld: String,
    @Json(name = "mass")
    val mass: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "skin_color")
    val skin_color: String,
    @Json(name = "species")
    val species: List<Any>,
    @Json(name = "starships")
    val starships: List<String>,
    @Json(name = "url")
    val url: String,
    @Json(name = "vehicles")
    val vehicles: List<String>,
    var id:String= UUID.randomUUID().toString(),
    var isFavourite: Boolean = false
)
