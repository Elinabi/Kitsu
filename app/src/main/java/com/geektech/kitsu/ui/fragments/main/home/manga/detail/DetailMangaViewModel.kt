package com.geektech.kitsu.ui.fragments.main.home.manga.detail

import androidx.lifecycle.ViewModel
import com.geektech.kitsu.base.BaseViewModel
import com.geektech.kitsu.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailMangaViewModel @Inject constructor(
    private val mangaRepositories: MangaRepository
) : BaseViewModel() {
    fun fetchDetailManga(id: String) = mangaRepositories.fetchMangaDetail(id)
}