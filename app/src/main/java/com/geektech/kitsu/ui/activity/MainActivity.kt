package com.geektech.kitsu.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.kitsu.R
import com.geektech.kitsu.databinding.ActivityMainBinding
import com.geektech.kitsu.ui.adapters.AnimeAdapter
import com.geektech.kitsu.ui.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}