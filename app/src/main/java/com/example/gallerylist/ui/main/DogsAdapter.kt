package com.example.gallerylist.ui.main

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.gallerylist.R
import com.example.gallerylist.common.infalte
import kotlinx.android.synthetic.main.dog_item.view.*
import kotlinx.android.synthetic.main.header_item.view.*

class DogsAdapter(val click: (String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object AdapterTypes {
        const val NORMAL = 1
    }

    private var dogList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> HeaderHolder(parent)
            else -> DogHolder(parent)
        }
    }

    // how to bind my data to my view
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentDog = dogList[position]

        when (getItemViewType(position)) {
            NORMAL -> (holder as HeaderHolder).bind("Header")
            else -> (holder as DogHolder).bind(currentDog)
        }
    }

    // how much items I need to show?
    override fun getItemCount() = dogList.size

    fun showDogs(list: List<String>) {
        dogList = list.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            1,8 ->  NORMAL
            else -> super.getItemViewType(position)
        }
    }

    inner class HeaderHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.infalte(R.layout.header_item)) {
        fun bind(text: String) = with(itemView) {
            title.text = text
            setOnClickListener {
                click.invoke(text)
            }
        }
    }

    // holder that holds the logic for specific type of view
    inner class DogHolder(parent: ViewGroup) :
        RecyclerView.ViewHolder(parent.infalte(R.layout.dog_item)) {

        fun bind(url: String) = with(itemView) {
            // here we are going to load
            Glide.with(this)
                .load(url)
                .into(image)
            // click listener
            setOnClickListener {
                click.invoke(url)
            }

        }
    }
}