package com.aslanjavasky.montekrist_test.starswars.domain.models

import java.util.UUID

data class PeopleItem(
    val birth_year: String,
    val created: String="",
    val edited: String="",
    val eye_color: String="",
    val films: List<String> = emptyList(),
    val gender: String,
    val hair_color: String="",
    val height: String="",
    val homeworld: String="",
    val mass: String="",
    val name: String="",
    val skin_color: String="",
    val species: List<Any> = emptyList(),
    val starships: List<String> = emptyList(),
    val url: String="",
    val vehicles: List<String> = emptyList(),
    val id:String=UUID.randomUUID().toString(),
    var isFavourite: Boolean = false
)