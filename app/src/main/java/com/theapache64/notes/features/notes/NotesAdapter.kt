package com.theapache64.notes.features.notes


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.theapache64.notes.data.remote.getnotes.Note
import com.theapache64.notes.databinding.ItemNoteBinding

/**
 * Created by theapache64 : Aug 29 Sat,2020 @ 16:37
 */
class NotesAdapter(
    context: Context,
    private val notes: List<Note>,
    private val callback: (position: Int) -> Unit
) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNoteBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.binding.note = note
    }

    inner class ViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                callback(layoutPosition)
            }
        }
    }
}