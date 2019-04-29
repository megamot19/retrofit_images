package com.example.gallerylist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.example.gallerylist.model.remote.Network
import com.example.gallerylist.ui.main.DogsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var dogsAdapter: DogsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDogsRecyclerView()
        fetchImages()
        // bind the button from the view (xml)
//        button.setOnClickListener {
            // call the dog api function

//        }
    }

    private fun setDogsRecyclerView() {
        dogsAdapter = DogsAdapter {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = dogsAdapter
    }

    private fun fetchImages() {
        Network.call().getDogsImages().enqueue(object : Callback<DogResponse> {
            override fun onResponse(call: Call<DogResponse>, response: Response<DogResponse>) {
                if (response.isSuccessful) {
                    dogsAdapter?.showDogs(response.body()?.imagesList ?: arrayListOf())
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
