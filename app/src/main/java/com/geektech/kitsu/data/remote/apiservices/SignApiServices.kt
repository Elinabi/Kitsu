package com.geektech.kitsu.data.remote.apiservices

import com.geektech.kitsu.models.auth.AuthModel
import com.geektech.kitsu.models.auth.TokenModel
import retrofit2.http.Body
import retrofit2.http.POST

interface SignApiServices {

    @POST("oauth/token")
    suspend fun postAuthDataUser(
        @Body authModel: AuthModel
    ): TokenModel
}