package com.theapache64.notes.data.remote.getnotes

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by theapache64 : Aug 29 Sat,2020 @ 10:13
 */
@JsonClass(generateAdapter = true)
data class Note(
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "title")
    val title: String,
    @Json(name = "description")
    val description: String
)