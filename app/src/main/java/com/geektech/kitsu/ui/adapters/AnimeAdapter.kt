package com.geektech.kitsu.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android4lesson1dz.databinding.ItemAnimeBinding
import com.geektech.kitsu.extension.setImage
import com.geektech.kitsu.models.DataItem

class AnimeAdapter :
    PagingDataAdapter<DataItem, AnimeAdapter.ViewHolder>(
        AnimeDiffCallBack
    ) {

    inner class ViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

//        init {
//            itemView.setOnClickListener {
//                getItem(absoluteAdapterPosition)?.let { anime -> onItemClick(anime.id) }
//            }
//        }

        fun onBind(item: DataItem) {
            binding.itemText.text = item.attributes.titles.enJp
            binding.itemImage.setImage(item.attributes.posterImage.original)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }
}

object AnimeDiffCallBack : DiffUtil.ItemCallback<DataItem>() {
    override fun areItemsTheSame(
        oldItem: DataItem,
        newItem: DataItem,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: DataItem,
        newItem: DataItem,
    ): Boolean {
        return oldItem.id == newItem.id
    }
}