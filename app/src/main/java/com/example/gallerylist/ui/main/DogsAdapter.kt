package com.example.gallerylist.ui.main

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.gallerylist.R
import com.example.gallerylist.common.infalte
import kotlinx.android.synthetic.main.dog_item.view.*

// create adapter class
// extend to recyclerview.adapter class
// implement adapter interfaces
// create viewholder
class DogsAdapter : RecyclerView.Adapter<DogsAdapter.DogHolder>() {

    //  my data
    private var dogList: MutableList<String> = arrayListOf()

    // iteration number 99% size list
    override fun getItemCount() = dogList.size

    // view
    override fun onCreateViewHolder(parent: ViewGroup, type: Int) = DogHolder(parent)

    override fun onBindViewHolder(holder: DogHolder, position: Int) {
        holder.bind(dogList[position])
    }

    // here we will load the dogs newDogs from Retrofit
    fun showDogs(newDogs: MutableList<String>) {
        this.dogList = newDogs
        notifyDataSetChanged()
    }

    class DogHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.infalte(R.layout.dog_item)) {
        fun bind(url: String) = with(itemView) {
            Glide.with(context).load(url).into(image)
        }
    }
}


//
//class DogsAdapter(val click: (String) -> Unit)
//    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    companion object AdapterTypes {
//        const val NORMAL = 1
//    }
//
//    private var dogList = mutableListOf<String>()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        return when (viewType) {
//            NORMAL -> HeaderHolder(parent)
//            else -> DogHolder(parent)
//        }
//    }
//
//    // how to bind my data to my view
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        val currentDog = dogList[position]
//
//        when (getItemViewType(position)) {
//            NORMAL -> (holder as HeaderHolder).bind("Header")
//            else -> (holder as DogHolder).bind(currentDog)
//        }
//    }
//
//    // how much items I need to show?
//    override fun getItemCount() = dogList.size
//
//    fun showDogs(list: List<String>) {
//        dogList = list.toMutableList()
//        notifyDataSetChanged()
//    }
//
//    override fun getItemViewType(position: Int): Int {
//        return when(position) {
//            1,8 ->  NORMAL
//            else -> super.getItemViewType(position)
//        }
//    }
//
//    inner class HeaderHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.infalte(R.layout.header_item)) {
//        fun bind(text: String) = with(itemView) {
//            title.text = text
//            setOnClickListener {
//                click.invoke(text)
//            }
//        }
//    }
//
//    // holder that holds the logic for specific type of view
//    inner class DogHolder(parent: ViewGroup) :
//        RecyclerView.ViewHolder(parent.infalte(R.layout.dog_item)) {
//
//        fun bind(url: String) = with(itemView) {
//            // here we are going to load
//            Glide.with(this)
//                .load(url)
//                .into(image)
//            // click listener
//            setOnClickListener {
//                click.invoke(url)
//            }
//        }
//    }
//}