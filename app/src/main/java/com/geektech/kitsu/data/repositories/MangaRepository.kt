package com.geektech.kitsu.data.repositories

import androidx.lifecycle.liveData
import com.geektech.kitsu.Resource
import com.geektech.kitsu.data.remote.apiservices.MangaApiServices
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiServices: MangaApiServices
) {
    fun fetchManga() = liveData {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(mangaApiServices.fetchManga()))
        }catch (exception: Exception){
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
//    fun fetchMangaDetail(id: String) = liveData {
//        emit(Resource.Loading())
//        try {
//            emit(Resource.Success(mangaApiServices.fetchMangaDetail(id)))
//        }catch (exception: Exception){
//            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
//        }
//    }
}