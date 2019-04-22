package com.example.gallerylist

import com.google.gson.annotations.SerializedName

data class DogResponse(@SerializedName("message") val imagesList: List<String>? = null)