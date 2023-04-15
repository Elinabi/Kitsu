package com.geektech.kitsu.ui.fragments.manga

import androidx.lifecycle.ViewModel
import com.geektech.kitsu.App
import com.geektech.kitsu.base.BaseViewModel
import com.geektech.kitsu.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val mangaRepositories: MangaRepository
) : BaseViewModel() {

    fun fetchManga() = mangaRepositories.fetchManga()
}