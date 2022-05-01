package com.example.pathfinder.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PathClient {

    private val pathClient: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl("http://15.164.162.177:8080")
            .addConverterFactory(GsonConverterFactory.create())
    }

    val pathService: RetrofitApi by lazy {
        pathClient.build().create(RetrofitApi::class.java)
    }

}


