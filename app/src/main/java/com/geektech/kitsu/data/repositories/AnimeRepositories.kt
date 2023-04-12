package com.geektech.kitsu.data.repositories

import androidx.lifecycle.liveData
import com.geektech.kitsu.Resource
import com.geektech.kitsu.data.remote.apiservices.AnimeApiServices
import javax.inject.Inject

class AnimeRepositories @Inject constructor(
    private val animeApiServices: AnimeApiServices
) {
    fun fetchAnime() = liveData {
//        emit(animeApiServices.fetchAnime())
        emit(Resource.Loading())
        try {
            emit(Resource.Success(animeApiServices.fetchAnime()))
        }catch (exception: Exception){
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
//    fun fetchAnimeDetail(id: String) = liveData {
//        emit(Resource.Loading())
//        try {
//            emit(Resource.Success(animeApiServices.fetchAnimeDetail(id)))
//        }catch (exception: Exception){
//            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
//        }
//    }
}