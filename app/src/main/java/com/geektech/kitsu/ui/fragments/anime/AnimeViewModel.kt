package com.geektech.kitsu.ui.fragments.anime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.geektech.kitsu.App
import com.geektech.kitsu.base.BaseViewModel
import com.geektech.kitsu.data.repositories.AnimeRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val animeRepositories: AnimeRepositories
): BaseViewModel() {

    fun fetchAnime() = animeRepositories.fetchAnime().cachedIn(viewModelScope)
}