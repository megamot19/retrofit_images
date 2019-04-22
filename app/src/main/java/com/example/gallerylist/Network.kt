package com.example.gallerylist

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    fun call(): DogService =
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogService::class.java)
}