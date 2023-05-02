package com.geektech.kitsu.data.remote.apiservices

import com.geektech.kitsu.Utils.Constants
import com.geektech.kitsu.models.Anime
import com.geektech.kitsu.models.DataItem
import com.geektech.kitsu.models.ResponsData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiServices {

    @GET("edge/anime")
    suspend fun fetchAnime(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int,
    ): Anime<DataItem>

    @GET("edge/anime/{id}")
    suspend fun fetchAnimeDetail(@Path("id") id: String): ResponsData
}