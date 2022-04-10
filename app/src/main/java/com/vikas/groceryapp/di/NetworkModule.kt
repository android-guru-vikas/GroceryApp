package com.vikas.groceryapp.di

import com.vikas.groceryapp.api.APIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun provideGroceryService(): APIService {
        return APIService.create()
    }
}
