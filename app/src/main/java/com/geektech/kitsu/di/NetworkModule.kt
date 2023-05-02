package com.geektech.kitsu.di

import com.geektech.kitsu.data.remote.RetrofitClient
import com.geektech.kitsu.data.remote.apiservices.AnimeApiServices
import com.geektech.kitsu.data.remote.apiservices.MangaApiServices
import com.geektech.kitsu.data.remote.apiservices.SignApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideAnimeApiServices(): AnimeApiServices {
        return retrofitClient.provideAnimeApiServices()
    }

    @Singleton
    @Provides
    fun provideMangaApiServices(): MangaApiServices {
        return retrofitClient.provideMangaApiServices()
    }

    @Singleton
    @Provides
    fun provideSignInApiService(): SignApiServices{
        return retrofitClient.providerSignInApiService()
    }
}