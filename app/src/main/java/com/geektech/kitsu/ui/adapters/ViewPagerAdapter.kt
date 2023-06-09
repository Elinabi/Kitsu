package com.geektech.kitsu.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.geektech.kitsu.ui.fragments.main.home.anime.AnimeFragment
import com.geektech.kitsu.ui.fragments.main.home.anime.AnimeViewModel
import com.geektech.kitsu.ui.fragments.main.home.manga.MangaFragment

class ViewPagerAdapter(fragment: Fragment ) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AnimeFragment()
            else -> MangaFragment()
        }
    }
}