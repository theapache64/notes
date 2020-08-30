package com.theapache64.notes.features.addnote

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.switchMap
import com.theapache64.notes.data.NotesRepo
import com.theapache64.notes.data.remote.addnote.AddNoteRequest
import com.theapache64.notes.utils.calladapter.flow.Resource
import kotlinx.coroutines.flow.onEach

/**
 * Created by theapache64 : Aug 30 Sun,2020 @ 10:46
 */
class AddNoteViewModel @ViewModelInject constructor(
    private val notesRepo: NotesRepo
) : ViewModel() {

    var title = ""
    var description = ""

    private val _addNoteRequest = MutableLiveData<AddNoteRequest>()
    val addNoteResponse = _addNoteRequest.switchMap { it ->
        notesRepo.addNote(it)
            .onEach { resp ->
                if (resp is Resource.Success) {
                    title = ""
                    description = ""
                }
            }
            .asLiveData()
    }

    fun onAddNoteClicked() {
        _addNoteRequest.value = AddNoteRequest(
            title,
            description
        )
    }
}