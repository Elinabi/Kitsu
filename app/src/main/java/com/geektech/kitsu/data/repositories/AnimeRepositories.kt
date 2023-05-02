package com.geektech.kitsu.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.geektech.kitsu.base.BaseRepository
import com.geektech.kitsu.data.remote.apiservices.AnimeApiServices
import com.geektech.kitsu.data.repositories.paginsours.AnimePagingSours
import javax.inject.Inject

class AnimeRepositories @Inject constructor(
    private val animeApiServices: AnimeApiServices
): BaseRepository() {

    fun fetchAnime() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        AnimePagingSours(animeApiServices)
    }.liveData

    fun fetchAnimeDetail(id: String) = doRequest {
        animeApiServices.fetchAnimeDetail(id)
    }
//    fun fetchAnime() = liveData {
////        emit(animeApiServices.fetchAnime())
//        emit(Resource.Loading())
//        try {
//            emit(Resource.Success(animeApiServices.fetchAnime()))
//        }catch (exception: Exception){
//            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
//        }
//    }
}