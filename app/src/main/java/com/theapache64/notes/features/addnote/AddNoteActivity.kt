package com.theapache64.notes.features.addnote

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.theapache64.notes.R
import com.theapache64.notes.databinding.ActivityAddNoteBinding
import com.theapache64.notes.utils.calladapter.flow.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteActivity : AppCompatActivity() {
    companion object {
        const val RQ_CODE = 2332
        fun getStartIntent(context: Context): Intent {
            return Intent(context, AddNoteActivity::class.java).apply {
                // data goes here
            }
        }
    }

    private val viewModel: AddNoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityAddNoteBinding>(this, R.layout.activity_add_note)

        binding.viewModel = viewModel

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.addNoteResponse.observe(this, Observer {
            when (it) {
                is Resource.Loading -> {
                    binding.bAddNote.isEnabled = false
                }
                is Resource.Success -> {
                    Toast.makeText(this, "Note added", Toast.LENGTH_SHORT).show();
                    binding.bAddNote.isEnabled = true
                    setResult(Activity.RESULT_OK)
                    finish()
                }
                is Resource.Error -> {
                    binding.bAddNote.isEnabled = true
                    Toast.makeText(this, it.errorData, Toast.LENGTH_SHORT).show();
                }
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == android.R.id.home) {
            onBackPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

}