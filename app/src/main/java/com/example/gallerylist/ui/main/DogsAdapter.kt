package com.example.gallerylist.ui.main

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.gallerylist.R
import com.example.gallerylist.common.infalte
import kotlinx.android.synthetic.main.dog_item.view.*

class DogsAdapter : RecyclerView.Adapter<DogsAdapter.DogHolder>() {

    private var dogList = mutableListOf<String>()

    // ask for what view?
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = DogHolder(parent)

    // how much items I need to show?
    override fun getItemCount() = dogList.size

    // how to bind my data to my view
    override fun onBindViewHolder(holder: DogHolder, position: Int) {
        val currentDog = dogList[position]
        holder.bind(currentDog)
    }

    fun showDogs(list: List<String>) {
        dogList = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) return 1

        return super.getItemViewType(position)
    }

    // holder that holds the logic for specific type of view
    class DogHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.infalte(R.layout.dog_item)) {

        fun bind(url: String) = with(itemView) {
            // here we are going to load
            Glide.with(this)
                .load(url)
                .into(image)
        }
    }
}