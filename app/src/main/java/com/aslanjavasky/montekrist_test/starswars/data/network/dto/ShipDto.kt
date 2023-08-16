package com.aslanjavasky.montekrist_test.starswars.data.network.dto

import com.squareup.moshi.JsonClass
import java.util.UUID

@JsonClass(generateAdapter = true)
data class ShipDto(
    val MGLT: String,
    val cargo_capacity: String,
    val consumables: String,
    val cost_in_credits: String,
    val created: String,
    val crew: String,
    val edited: String,
    val films: List<String>,
    val hyperdrive_rating: String,
    val length: String,
    val manufacturer: String,
    val max_atmosphering_speed: String,
    val model: String,
    val name: String,
    val passengers: String,
    val pilots: List<Any>,
    val starship_class: String,
    val url: String,
    var id:String= UUID.randomUUID().toString(),
    var isFavourite: Boolean = false
)
