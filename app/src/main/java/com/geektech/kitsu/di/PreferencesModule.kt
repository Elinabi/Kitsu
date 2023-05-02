package com.geektech.kitsu.di

import android.content.Context
import com.geektech.kitsu.data.local.preferences.PreferencesHelper
import com.geektech.kitsu.data.local.preferences.UserPreferencesData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Singleton
    @Provides
    fun providePreferenceHelper(@ApplicationContext context: Context) =
        PreferencesHelper(context)

    @Singleton
    @Provides
    fun provideUserPreferenceData(preferencesHelper: PreferencesHelper) =
        UserPreferencesData(preferencesHelper)

//    @Singleton
//    @Provides
//    fun provideSharedPreferences(
//        @ApplicationContext context: Context
//    ) = PreferencesHelper(context)
}