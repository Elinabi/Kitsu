package com.geektech.kitsu.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.geektech.kitsu.Utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

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

    protected open fun setupRequest(){}

    protected open fun setupObserves() {}

    protected open fun setupSubscribers(){}

    protected open fun <T> Flow<Resource<T>>.subscribe(
        state: ((state: Resource<T>) -> Unit)? = null,
        onError: (error: String) -> Unit,
        onSuccess: ((data: T) -> Unit)
    ) {
        lifecycleScope.launch {
            collect {
                when (it) {
                    is Resource.Error -> onError(it.message.toString())
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        it.data?.let { data ->
                            onSuccess(data)
                        }
                    }
                }
            }
        }
    }
}