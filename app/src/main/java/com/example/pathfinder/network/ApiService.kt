package com.example.pathfinder.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class ApiService {

    private val retrofit = Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()


    companion object {
        private const val BASE_URL = "http://15.164.162.177:8080/withJson"


    }

    interface ApiService{

        @GET()
        fun getData(@Query("start") start: String, @Query("middle") middle: String,@Query("end") end: String): String
    }
}