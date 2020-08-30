package com.theapache64.notes.data.remote

import com.theapache64.notes.utils.calladapter.flow.Resource
import com.theapache64.retrosheet.core.Read
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

/**
 * Created by theapache64 : Aug 29 Sat,2020 @ 10:14
 */
interface ApiInterface {

    @Read("SELECT *")
    @GET("notes")
    fun getNotes(): Flow<Resource<List<Note>>>

}