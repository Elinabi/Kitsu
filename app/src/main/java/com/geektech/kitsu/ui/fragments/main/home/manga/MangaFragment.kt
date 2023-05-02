package com.geektech.kitsu.ui.fragments.main.home.manga

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1dz.R
import com.example.android4lesson1dz.databinding.FragmentMangaBinding
import com.geektech.kitsu.base.BaseFragment
import com.geektech.kitsu.ui.adapters.MangaAdapter
import com.geektech.kitsu.ui.fragments.main.home.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment:
    BaseFragment<MangaViewModel, FragmentMangaBinding>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel by viewModels<MangaViewModel>()
    private var mangaAdapter = MangaAdapter(this::onItemClick)

    override fun initialise() {
        binding.mangaRecView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = mangaAdapter
        }
    }

    override fun setupObserves() {
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                mangaAdapter.submitData(it)
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailMangaFragment(id))
    }
}