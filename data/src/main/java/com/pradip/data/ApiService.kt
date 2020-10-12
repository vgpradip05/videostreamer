package com.pradip.data


import com.google.gson.JsonObject
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/videos")
    suspend fun getVideoList(@Query("page") page: Int, @Query("limit") limit: Int): JsonObject

}