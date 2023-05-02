package com.geektech.kitsu.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android4lesson1dz.databinding.ItemMangaBinding
import com.geektech.kitsu.extension.setImage
import com.geektech.kitsu.models.DataItem

class MangaAdapter(val onItemClick: (id: String) -> Unit) :
    PagingDataAdapter<DataItem, MangaAdapter.ViewHolder>(AnimeDiffCallBacks
    ) {

    inner class ViewHolder(private val binding: ItemMangaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.let { manga -> onItemClick(manga.id) }
            }
        }

        fun onBind(item: DataItem) {
            binding.itemText.text = item.attributes.titles.enJp
            binding.itemImage.setImage(item.attributes.posterImage.original)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMangaBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    object AnimeDiffCallBacks : DiffUtil.ItemCallback<DataItem>() {
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
}