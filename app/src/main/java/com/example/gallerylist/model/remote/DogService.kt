package com.example.gallerylist.model.remote

import com.example.gallerylist.DogResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * this is the retrofit interface of the the dog service.
 */
interface DogService {
    @GET("hound/images")
    fun getDogsImages(): Call<DogResponse>
}