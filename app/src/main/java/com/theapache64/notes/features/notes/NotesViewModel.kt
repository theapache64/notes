package com.theapache64.notes.features.notes

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.theapache64.notes.data.NotesRepo
import com.theapache64.notes.data.remote.getnotes.Note
import com.theapache64.notes.utils.calladapter.flow.Resource
import com.theapache64.notes.utils.livedata.SingleLiveEvent
import timber.log.Timber

/**
 * Created by theapache64 : Aug 29 Sat,2020 @ 09:59
 */
class NotesViewModel @ViewModelInject constructor(
    private val notesRepo: NotesRepo
) : ViewModel() {

    private val _shouldLoadNotes = MutableLiveData<Boolean>()
    val notes: LiveData<Resource<List<Note>>> = _shouldLoadNotes.switchMap {
        notesRepo.getNotes().asLiveData()
    }

    private val _shouldLaunchAddNote = SingleLiveEvent<Boolean>()
    val shouldLaunchAddNote: LiveData<Boolean> = _shouldLaunchAddNote

    init {
        _shouldLoadNotes.value = true
    }

    fun onAddNameClicked() {
        Timber.d("onAddNameClicked: Add name clicked ")
        _shouldLaunchAddNote.value = true
    }

    fun onRefreshClicked() {
        Timber.d("onRefreshClicked: On refresh clicked")
        _shouldLoadNotes.value = true
    }

    fun onNewNoteAdded() {
        _shouldLoadNotes.value = true
    }
}