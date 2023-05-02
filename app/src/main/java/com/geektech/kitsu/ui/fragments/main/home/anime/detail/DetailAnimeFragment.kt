package com.geektech.kitsu.ui.fragments.main.home.anime.detail

import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1dz.R
import com.example.android4lesson1dz.databinding.FragmentDetailAnimeBinding
import com.geektech.kitsu.Utils.Resource
import com.geektech.kitsu.base.BaseFragment
import com.geektech.kitsu.extension.setImage
import com.geektech.kitsu.models.ResponsData
import com.geektech.kitsu.ui.adapters.AnimeDetailAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@Suppress("CAST_NEVER_SUCCEEDS")
@AndroidEntryPoint
class DetailAnimeFragment :
    BaseFragment<DetailAnimeViewModel, FragmentDetailAnimeBinding>(R.layout.fragment_detail_anime) {

    override val binding by viewBinding(FragmentDetailAnimeBinding::bind)
    override val viewModel: DetailAnimeViewModel by viewModels()
    private var animeDetailAdapter = AnimeDetailAdapter()
    private val args by navArgs<DetailAnimeFragmentArgs>()

    override fun initialise() {
        binding.animeDetailRecView.adapter = animeDetailAdapter
    }

    override fun setupObserves() {
        lifecycleScope.launch {
            viewModel.fetchDetailAnime(args.id).collect() {
                when (it) {
                    is Resource.Error -> {
                        binding.progressBar.isInvisible = true
                        Toast.makeText(requireContext(), "error", Toast.LENGTH_SHORT).show()
                    }

                    is Resource.Loading -> {
                        binding.progressBar.isInvisible = false
                        Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
                    }

                    is Resource.Success -> {
                        it.data.let { anime ->
                            binding.progressBar.isInvisible = true
                            binding.animeTextView.text = anime!!.data.attributes.description
                            binding.animeName.text = anime.data.attributes.titles.enJp
                            binding.animeImageViewTwo.setImage(anime.data.attributes.posterImage.large)
                            binding.animeImageView.setImage(anime.data.attributes.posterImage.original)
                            Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
                            animeDetailAdapter.submitList(animeDetailAdapter.currentList)
//                        lifecycleScope.launch {
//
//                        }
                        }
                    }
                }
            }
        }
    }
}