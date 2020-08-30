package com.theapache64.notes.data

import com.theapache64.notes.data.remote.ApiInterface
import com.theapache64.notes.data.remote.addnote.AddNoteRequest
import javax.inject.Inject

/**
 * Created by theapache64 : Aug 29 Sat,2020 @ 09:59
 */
class NotesRepo @Inject constructor(
    private val apiInterface: ApiInterface
) {
    fun getNotes() = apiInterface.getNotes()
    fun addNote(addNoteRequest: AddNoteRequest) = apiInterface.addNote(addNoteRequest)
}