package com.geektech.kitsu.data.remote.apiservices

import com.geektech.kitsu.models.Anime
import com.geektech.kitsu.models.DataItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MangaApiServices {

    @GET("manga")
    suspend fun fetchManga(): Anime<DataItem>

//    @GET("api/manga/{id}")
//    suspend fun fetchMangaDetail(@Path("id") id: String): DataItem
}