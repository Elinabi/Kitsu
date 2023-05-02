package com.geektech.kitsu.data.repositories

import com.geektech.kitsu.Utils.Resource
import com.geektech.kitsu.base.BaseRepository
import com.geektech.kitsu.data.remote.apiservices.SignApiServices
import com.geektech.kitsu.models.auth.AuthModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignRepository @Inject constructor(
    private val signApiServices: SignApiServices
) : BaseRepository() {

    fun postUserData(authModel: AuthModel) = doRequest{
        signApiServices.postAuthDataUser(authModel)
    }
}
//fun postUserData(authModel: AuthModel) = doRequest {
//    api.postAuthDataUser(authModel)
//}