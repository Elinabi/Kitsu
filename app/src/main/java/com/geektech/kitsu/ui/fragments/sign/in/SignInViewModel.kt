package com.geektech.kitsu.ui.fragments.sign.`in`

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.geektech.kitsu.Utils.Resource
import com.geektech.kitsu.base.BaseViewModel
import com.geektech.kitsu.data.repositories.SignRepository
import com.geektech.kitsu.models.auth.AuthModel
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: SignRepository
) : BaseViewModel() {

    fun postUserData(authModel: AuthModel) = repository.postUserData(authModel)
}