package com.geektech.kitsu.ui.fragments.anime.detail
//
//import android.widget.Toast
//import androidx.fragment.app.viewModels
//import androidx.navigation.fragment.navArgs
//import by.kirich1409.viewbindingdelegate.viewBinding
//import com.example.android4lesson1dz.R
//import com.example.android4lesson1dz.databinding.FragmentDetailAnimeBinding
//import com.geektech.kitsu.Resource
//import com.geektech.kitsu.base.BaseFragment
//import com.geektech.kitsu.extension.setImage
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class DetailAnimeFragment :
//    BaseFragment<DetailAnimeViewModel, FragmentDetailAnimeBinding>(R.layout.fragment_detail_anime){
//
//    override val binding by viewBinding(FragmentDetailAnimeBinding::bind)
//    override val viewModel: DetailAnimeViewModel by viewModels()
//    private val args by navArgs<DetailAnimeFragmentArgs>()
//
//    override fun setupObserves() {
//        viewModel.fetchDetailAnime(args.id).observe(viewLifecycleOwner) {
//            when (it) {
//                is Resource.Success -> {
//                    it.data.let { anime ->
//                        binding.animeTextView.text = anime!!.data.attributes.titles.enJp
//                        binding.animeImageView.setImage(anime.data.attributes.posterImage.original)
//                        Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
//                    }
//                }
//                else -> {}
//            }
//        }
//    }
//}