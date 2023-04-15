package com.geektech.kitsu.data.remote.apiservices

import com.geektech.kitsu.models.Anime
import com.geektech.kitsu.models.DataItem
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiServices {

    @GET("anime")
    suspend fun fetchAnime(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int,
    ): Anime<DataItem>

//    @GET("api/anime/{id}")
//    suspend fun fetchAnimeDetail(@Path("id") id: String):ResponsData
}