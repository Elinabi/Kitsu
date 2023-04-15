package com.geektech.kitsu.data.repositories.paginsours

import android.net.Uri
import com.geektech.kitsu.base.BasePagingSource
import com.geektech.kitsu.data.remote.apiservices.MangaApiServices
import com.geektech.kitsu.models.DataItem

class MangaPagingSours(
    private val apiMangaServices: MangaApiServices,
) : BasePagingSource<DataItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        return try {
            val nextPage = params.key ?:HEADLINE_PAGE
            val response = apiMangaServices.fetchManga(params.loadSize, nextPage)
            val nextPages =
                Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()

            LoadResult.Page(
                data = response.data,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPages
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}