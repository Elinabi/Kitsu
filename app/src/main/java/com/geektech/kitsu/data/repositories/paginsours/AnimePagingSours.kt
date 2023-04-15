package com.geektech.kitsu.data.repositories.paginsours

import android.net.Uri
import androidx.paging.PagingSource
import com.geektech.kitsu.base.BasePagingSource
import com.geektech.kitsu.data.remote.apiservices.AnimeApiServices
import com.geektech.kitsu.models.DataItem

class AnimePagingSours (
    private val apiServices: AnimeApiServices
): BasePagingSource<DataItem>(){

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> {
        return try {
            val nextPage = params.key ?: HEADLINE_PAGE
            val response = apiServices.fetchAnime(params.loadSize, nextPage)
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