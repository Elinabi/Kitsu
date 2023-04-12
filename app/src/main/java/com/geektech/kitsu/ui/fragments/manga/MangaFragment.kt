package com.geektech.kitsu.ui.fragments.manga

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.kitsu.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.geektech.kitsu.databinding.FragmentMangaBinding
import com.geektech.kitsu.Resource
import com.geektech.kitsu.base.BaseFragment
import com.geektech.kitsu.ui.adapters.MangaAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaFragment:
    BaseFragment<MangaViewModel, FragmentMangaBinding>(R.layout.fragment_manga) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel by viewModels<MangaViewModel>()
    private var mangaAdapter = MangaAdapter(this:: onItemClick)

    override fun initialise() {
        binding.mangaRecView.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = mangaAdapter
        }
    }

    override fun setupObserve() {
        viewModel.fetchManga().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error ->
                    Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
                is Resource.Loading ->{

                }
                is Resource.Success -> {
                    it.data?.let {
                        Log.e("Anime", it.data.toString() )
                        mangaAdapter.submitList(it.data)
                    }
                }
            }
        }
    }
    private fun onItemClick(id: String) {
        findNavController().navigate(MangaFragmentDirections.actionMangaFragmentToDetailMangaFragment(id))
    }

}