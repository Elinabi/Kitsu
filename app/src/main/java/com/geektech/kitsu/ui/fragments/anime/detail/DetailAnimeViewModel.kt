package com.geektech.kitsu.ui.fragments.anime.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.kitsu.base.BaseViewModel
import com.geektech.kitsu.data.repositories.AnimeRepositories
import com.geektech.kitsu.models.DataItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//@HiltViewModel
//class DetailAnimeViewModel @Inject constructor(
//    private val animeRepositories: AnimeRepositories
//): BaseViewModel() {

//    fun fetchDetailAnime(id: String) = animeRepositories.fetchAnimeDetail(id)
//}