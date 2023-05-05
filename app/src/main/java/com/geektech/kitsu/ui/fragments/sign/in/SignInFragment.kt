package com.geektech.kitsu.ui.fragments.sign.`in`

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1dz.R
import com.example.android4lesson1dz.databinding.FragmentSignInBinding
import com.geektech.kitsu.base.BaseFragment
import com.geektech.kitsu.data.local.preferences.UserPreferencesData
import com.geektech.kitsu.extension.toast
import com.geektech.kitsu.models.auth.AuthModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment :
    BaseFragment<SignInViewModel, FragmentSignInBinding>(R.layout.fragment_sign_in) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData

    override val binding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels()

    override fun setupSubscribers() = with(binding)  {

        binding.signInBtn.setOnClickListener {
            val email = inputLayoutNickName.text.toString()
            val password = inputLayoutPassword.text.toString()
            val authModel = AuthModel("password", email, password)

            viewModel.postUserData(authModel).subscribe(
                onError = {
                    Log.e("TAG", "setupSubscribes: $it")
                }
            ) {
                toast("$it")
                if (it != null) {
                    userPreferencesData.apply {
                        isAuthorized = true
                        accessToken = it.accessToken
                        refreshToken = it.refreshToken
                    }
                    requireActivity().findNavController(R.id.fragment_container)
                        .navigate(R.id.action_signFlowFragment_to_mainFlowFragment)
                }
            }
        }
    }
}