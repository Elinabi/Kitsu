package com.geektech.kitsu.ui.fragments.main.home.manga.detail

import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1dz.R
import com.example.android4lesson1dz.databinding.FragmentDetailMangaBinding
import com.geektech.kitsu.Utils.Resource
import com.geektech.kitsu.base.BaseFragment
import com.geektech.kitsu.extension.setImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailMangaFragment :
    BaseFragment<DetailMangaViewModel, FragmentDetailMangaBinding>(R.layout.fragment_detail_manga) {

    override val binding by viewBinding(FragmentDetailMangaBinding::bind)
    override val viewModel: DetailMangaViewModel by viewModels()
    private val args by navArgs<DetailMangaFragmentArgs>()

    override fun setupObserves() {
        lifecycleScope.launch {
            viewModel.fetchDetailManga(args.id).collect() {
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
//                        binding.mangaTextView.text = anime!!.data.attributes.titles.enJp
                            binding.mangaImageViewTwo.setImage(anime!!.data.attributes.posterImage.large)
                            binding.mangaImageView.setImage(anime.data.attributes.posterImage.original)
                            Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}