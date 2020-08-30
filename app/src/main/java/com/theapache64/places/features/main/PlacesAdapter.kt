package com.theapache64.places.features.main

/**
 * Created by theapache64 : Aug 29 Sat,2020 @ 16:37
 */
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.theapache64.places.data.remote.Place
import com.theapache64.places.databinding.ItemPlaceBinding

class PlacesAdapter(
    context: Context,
    private val places: List<Place>,
    private val callback: (position: Int) -> Unit
) : RecyclerView.Adapter<PlacesAdapter.ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPlaceBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = places.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = places[position]
        holder.binding.place = place
    }

    inner class ViewHolder(val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                callback(layoutPosition)
            }
        }
    }
}