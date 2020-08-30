package com.theapache64.places.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by theapache64 : Aug 29 Sat,2020 @ 10:13
 */
@JsonClass(generateAdapter = true)
class Place(
    @Json(name = "name")
    val name: String
)