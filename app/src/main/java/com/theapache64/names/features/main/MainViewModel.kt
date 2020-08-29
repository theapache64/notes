package com.theapache64.names.features.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import timber.log.Timber

/**
 * Created by theapache64 : Aug 29 Sat,2020 @ 09:59
 */
class MainViewModel @ViewModelInject constructor() : ViewModel() {
    fun onAddNameClicked() {
        Timber.d("onAddNameClicked: Add name clicked ")
    }
}