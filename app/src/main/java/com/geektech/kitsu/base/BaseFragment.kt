package com.geektech.kitsu.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseFragment< VM : BaseViewModel,VB : ViewBinding,>(@LayoutRes layoutId: Int):
    Fragment(layoutId) {
    abstract val binding: VB
    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialise()
        setupListener()
        setupRequest()
        setupObserves()
        setupSubscribers()
    }

    protected open fun initialise() {}

    protected open fun setupListener() {}

    protected open fun setupObserves() {}

    protected open fun setupRequest(){}

    protected open fun setupSubscribers(){}

}