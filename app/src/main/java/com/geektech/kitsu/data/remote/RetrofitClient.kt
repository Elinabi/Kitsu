package com.geektech.kitsu.data.remote

import com.geektech.kitsu.Utils.Constants
import com.geektech.kitsu.data.remote.apiservices.AnimeApiServices
import com.geektech.kitsu.data.remote.apiservices.MangaApiServices
import com.geektech.kitsu.data.remote.apiservices.SignApiServices
import com.geektech.kitsu.data.repositories.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private var OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .addInterceptor(TokenInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient)
        .build()

    private fun provideLoggingInterceptor() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideAnimeApiServices(): AnimeApiServices {
        return retrofitClient.create(AnimeApiServices::class.java)
    }

    fun provideMangaApiServices(): MangaApiServices {
        return retrofitClient.create(MangaApiServices::class.java)
    }

    fun providerSignInApiService(): SignApiServices{
        return retrofitClient.create(SignApiServices::class.java)
    }
}