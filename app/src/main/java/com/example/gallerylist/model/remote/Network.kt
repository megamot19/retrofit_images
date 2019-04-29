package com.example.gallerylist.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    const val BASE_URL = "https://dog.ceo/api/breed/"

    fun call(): DogService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogService::class.java)
}