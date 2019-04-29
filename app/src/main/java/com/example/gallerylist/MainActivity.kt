package com.example.gallerylist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.gallerylist.model.remote.Network
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // bind the button from the view (xml)
        button.setOnClickListener {
            // call the dog api function
            fetchImages()
        }
    }

    private fun fetchImages() {
        Network.call().getDogsImages().enqueue(object : Callback<DogResponse> {
            override fun onResponse(call: Call<DogResponse>, response: Response<DogResponse>) {
                if (response.isSuccessful) {
                    Log.d("test", "Success ${response.body()?.imagesList ?: arrayListOf()}")
                } else {
                    // internal error 500..600
                    Log.d("test", "error")
                }
            }

            override fun onFailure(call: Call<DogResponse>, t: Throwable) {
                Log.d("test", "error")
            }
        })
    }
}
