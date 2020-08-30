package com.theapache64.notes.data

import com.theapache64.notes.data.remote.ApiInterface
import javax.inject.Inject

/**
 * Created by theapache64 : Aug 29 Sat,2020 @ 09:59
 */
class MainRepository @Inject constructor(
    private val apiInterface: ApiInterface
) {
    fun getNames() = apiInterface.getNames()
}