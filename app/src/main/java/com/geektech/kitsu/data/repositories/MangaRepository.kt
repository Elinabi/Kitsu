package com.geektech.kitsu.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.geektech.kitsu.base.BaseRepository
import com.geektech.kitsu.data.remote.apiservices.MangaApiServices
import com.geektech.kitsu.data.repositories.paginsours.MangaPagingSours
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiServices: MangaApiServices
): BaseRepository() {

    fun fetchManga() = Pager(
        PagingConfig(pageSize = 20, initialLoadSize = 10)
    ) {
        MangaPagingSours(mangaApiServices)
    }.liveData

//    fun fetchDetailManga(id: String) = doRequest {
//        mangaApiServices.fetchManga(id)
//    }

}