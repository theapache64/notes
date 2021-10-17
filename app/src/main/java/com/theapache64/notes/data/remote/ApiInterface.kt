package com.theapache64.notes.data.remote

import com.github.theapache64.retrosheet.annotations.Read
import com.github.theapache64.retrosheet.annotations.Write
import com.theapache64.notes.data.remote.addnote.AddNoteRequest
import com.theapache64.notes.data.remote.getnotes.Note
import com.theapache64.notes.utils.Const
import com.theapache64.notes.utils.calladapter.flow.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by theapache64 : Aug 29 Sat,2020 @ 10:14
 */
interface ApiInterface {


    @Read("SELECT * ORDER BY created_at DESC")
    @GET("notes")
    fun getNotes(): Flow<Resource<List<Note>>> // you can also use suspend and return List<Note>

    @Write
    @POST(Const.ADD_NOTE_ENDPOINT)
    fun addNote(@Body note: AddNoteRequest): Flow<Resource<AddNoteRequest>> // you can also use suspend and return AddNoteRequest
}