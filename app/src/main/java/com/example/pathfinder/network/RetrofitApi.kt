package com.example.pathfinder.network

import com.example.pathfinder.model.json.JsonResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {

    @GET("/withJson")
    fun getData(@Query("start") start: String, 
                @Query("middle") middle: String, 
                @Query("end") end: String
                ): Call<JsonResult>
}