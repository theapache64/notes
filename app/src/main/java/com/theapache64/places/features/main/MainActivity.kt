package com.theapache64.places.features.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.theapache64.places.R
import com.theapache64.places.databinding.ActivityMainBinding
import com.theapache64.places.utils.calladapter.flow.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(
                this,
                R.layout.activity_main
            )

        binding.viewModel = viewModel

        viewModel.names.observe(this, Observer {
            when (it) {

                is Resource.Loading -> {

                }

                is Resource.Success -> {

                }

                is Resource.Error -> {

                }
            }
        })
    }
}