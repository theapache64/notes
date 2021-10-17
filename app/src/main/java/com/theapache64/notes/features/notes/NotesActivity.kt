package com.theapache64.notes.features.notes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.theapache64.notes.R
import com.theapache64.notes.databinding.ActivityMainBinding
import com.theapache64.notes.features.addnote.AddNoteActivity
import com.theapache64.notes.utils.calladapter.flow.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesActivity : AppCompatActivity() {

    private val viewModel: NotesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(
                this,
                R.layout.activity_main
            )

        binding.viewModel = viewModel

        viewModel.notes.observe(this, {
            when (it) {

                is Resource.Loading -> {
                    Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show();
                    binding.rvNames.visibility = View.INVISIBLE
                }

                is Resource.Success -> {
                    val adapter = NotesAdapter(this, it.data) { position ->
                        Toast.makeText(this, "Clicked on '$position'", Toast.LENGTH_SHORT).show();
                    }

                    binding.rvNames.adapter = adapter
                    binding.rvNames.visibility = View.VISIBLE
                }

                is Resource.Error -> {
                    Toast.makeText(this, it.errorData, Toast.LENGTH_SHORT).show();
                }
            }
        })

        viewModel.shouldLaunchAddNote.observe(this, {
            if (it) {
                // TODO:
                startActivityForResult(
                    AddNoteActivity.getStartIntent(this),
                    AddNoteActivity.RQ_CODE
                )
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == AddNoteActivity.RQ_CODE && resultCode == Activity.RESULT_OK) {
            // new note added so refresh
            viewModel.onNewNoteAdded()
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}