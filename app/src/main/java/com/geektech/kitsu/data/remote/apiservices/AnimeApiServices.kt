package com.geektech.kitsu.data.remote.apiservices

import com.geektech.kitsu.models.Anime
import com.geektech.kitsu.models.Attributes
import com.geektech.kitsu.models.DataItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeApiServices {

    @GET ("anime")
    suspend fun fetchAnime(): Anime<DataItem>

//    @GET("api/anime/{id}")
//    suspend fun fetchAnimeDetail(@Path("id") id: String):DataItem
}