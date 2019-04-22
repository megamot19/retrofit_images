package com.example.gallerylist

import retrofit2.Call
import retrofit2.http.GET

interface DogService {

    @GET("hound/images")
    fun getDogsImages(): Call<DogResponse>


}