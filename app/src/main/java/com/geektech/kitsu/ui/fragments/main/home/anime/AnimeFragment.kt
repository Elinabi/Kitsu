package com.geektech.kitsu.ui.fragments.main.home.anime

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1dz.R
import com.example.android4lesson1dz.databinding.FragmentAnimeBinding
import com.geektech.kitsu.base.BaseFragment
import com.geektech.kitsu.ui.adapters.AnimeAdapter
import com.geektech.kitsu.ui.fragments.main.home.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment :
    BaseFragment<AnimeViewModel, FragmentAnimeBinding>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel by viewModels<AnimeViewModel>()
    private var animeAdapter = AnimeAdapter(this::onItemClick)

    override fun initialise() {
        binding.animeRecView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    override fun setupObserves() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                animeAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailAnimeFragment(
            id))
    }
}
