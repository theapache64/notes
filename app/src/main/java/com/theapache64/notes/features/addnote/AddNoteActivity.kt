package com.theapache64.notes.features.addnote

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.theapache64.notes.R

class AddNoteActivity : AppCompatActivity() {
    companion object {
        const val RQ_CODE = 2332
        fun getStartIntent(context: Context): Intent {
            return Intent(context, AddNoteActivity::class.java).apply {
                // data goes here
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
    }

}