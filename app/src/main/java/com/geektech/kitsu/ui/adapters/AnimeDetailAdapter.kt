package com.geektech.kitsu.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android4lesson1dz.databinding.ItemTitlsBinding
import com.geektech.kitsu.models.ResponsData

class AnimeDetailAdapter: ListAdapter<ResponsData,AnimeDetailAdapter.ViewHolder>(
    PokemonDiffCallBack) {


    inner class ViewHolder(private val binding: ItemTitlsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: ResponsData) {
            binding.text.text = item.data.attributes.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTitlsBinding.inflate(
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
object PokemonDiffCallBack : DiffUtil.ItemCallback<ResponsData>() {
    override fun areItemsTheSame(
        oldItem: ResponsData,
        newItem: ResponsData,
    ): Boolean {
        return oldItem.data == newItem.data
    }

    override fun areContentsTheSame(
        oldItem: ResponsData,
        newItem: ResponsData,
    ): Boolean {
        return oldItem.data == newItem.data
    }
}