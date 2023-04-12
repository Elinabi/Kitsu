package com.geektech.kitsu.ui.fragments.anime

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.kitsu.R
import com.geektech.kitsu.Resource
import com.geektech.kitsu.base.BaseFragment
import com.geektech.kitsu.databinding.FragmentAnimeBinding
import com.geektech.kitsu.ui.adapters.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment :
    BaseFragment<AnimeViewModel, FragmentAnimeBinding>(R.layout.fragment_anime) {

    override val binding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel by viewModels<AnimeViewModel>()
    private var animeAdapter = AnimeAdapter(this:: onItemClick)

    override fun initialise() {
        binding.animeRecView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = animeAdapter
        }
    }

    override fun setupObserve() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error ->
                    Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
                is Resource.Loading ->{

                }
                is Resource.Success -> {
                    it.data?.let {
                        Log.e("Anime", it.data.toString() )
                        animeAdapter.submitList(it.data)
                    }
                }
            }
//            animeAdapter.submitList(it.data)
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(AnimeFragmentDirections.actionAnimeFragmentToDetailAnimeFragment(id))
    }

}