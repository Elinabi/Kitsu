package com.geektech.kitsu.ui.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.android4lesson1dz.R
import com.geektech.kitsu.base.BaseFlowFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFlowFragment : BaseFlowFragment(R.layout.fragment_main_flow) {

    override val navigationId: Int
        get() = R.id.main_nav_host_container

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        setupNavigation()
//    }
//
//    private fun setupNavigation() {
//        val navHostFragment =
//            childFragmentManager.findFragmentById(R.id.main_nav_host_container) as NavHostFragment
//        val navController = navHostFragment.navController
//    }
}