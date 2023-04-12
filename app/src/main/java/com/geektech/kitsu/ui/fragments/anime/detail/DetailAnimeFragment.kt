package com.geektech.kitsu.ui.fragments.anime.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.kitsu.R
import com.geektech.kitsu.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
//class DetailAnimeFragment :
//    BaseFragment<DetailAnimeViewModel, com.geektech.kitsu.databinding.FragmentDetailAnimeBinding>(R.layout.fragment_detail_anime){
//
//    override val binding by viewBinding(FragmentDetailAnimeBinding::bind)
//    override val viewModel: DetailAnimeViewModel by viewModels()
//    private val args by navArgs<DetailAnimeFragmentArgs>()

//    override fun setupObserve() {
//        viewModel.fetchDetailAnime(args.id).observe(viewLifecycleOwner){
//            binding.animeImageView.setImage(it.message.toString())
//            binding.animeTextView.text = it.message
//        }
//    }
//}