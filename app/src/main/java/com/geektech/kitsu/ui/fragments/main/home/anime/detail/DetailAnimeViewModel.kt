package com.geektech.kitsu.ui.fragments.main.home.anime.detail

import com.geektech.kitsu.base.BaseViewModel
import com.geektech.kitsu.data.repositories.AnimeRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailAnimeViewModel @Inject constructor(
    private val animeRepositories: AnimeRepositories
): BaseViewModel() {

    fun fetchDetailAnime(id: String) = animeRepositories.fetchAnimeDetail(id)
}