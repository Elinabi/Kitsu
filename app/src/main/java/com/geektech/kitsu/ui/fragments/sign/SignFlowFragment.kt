package com.geektech.kitsu.ui.fragments.sign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.android4lesson1dz.R
import com.geektech.kitsu.base.BaseFlowFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignFlowFragment : BaseFlowFragment(R.layout.flow_fragment_sign) {

    override val navigationId: Int
        get() = R.id.sign_nav_host_container
}