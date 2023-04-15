package com.geektech.kitsu.data.remote.apiservices

import com.geektech.kitsu.models.Anime
import com.geektech.kitsu.models.DataItem
import retrofit2.http.GET
import retrofit2.http.Query

interface MangaApiServices {

    @GET("manga")
    suspend fun fetchManga(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int,
    ): Anime<DataItem>

//    @GET("api/manga/{id}")
//    suspend fun fetchMangaDetail(@Path("id") id: String): ResponseData
}