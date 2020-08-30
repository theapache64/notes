package com.theapache64.places.features.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.theapache64.places.data.MainRepository
import com.theapache64.places.data.remote.Place
import com.theapache64.places.utils.calladapter.flow.Resource
import timber.log.Timber

/**
 * Created by theapache64 : Aug 29 Sat,2020 @ 09:59
 */
class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _shouldLoadNames = MutableLiveData<Boolean>()
    val names: LiveData<Resource<List<Place>>> = _shouldLoadNames.switchMap {
        mainRepository.getNames().asLiveData()
    }

    init {
        loadNames()
    }

    fun onAddNameClicked() {
        Timber.d("onAddNameClicked: Add name clicked ")
    }

    private fun loadNames() {
        _shouldLoadNames.value = true
    }
}