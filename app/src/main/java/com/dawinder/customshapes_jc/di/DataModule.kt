package com.dawinder.customshapes_jc.di

import com.dawinder.customshapes_jc.repositories.ImagesRepository
import com.dawinder.customshapes_jc.repositories.ImagesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * This module is installed in the [SingletonComponent]
 * instance will be a singleton.
 */
@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    /**
     * Provides a singleton instance of [ImagesRepository].
     *
     * @param imagesRepository An instance of [ImagesRepositoryImpl] which is a concrete implementation of [ImagesRepository].
     * @return An instance of [ImagesRepository].
     */
    @Provides
    @Singleton
    fun provideImagesRepository(imagesRepository: ImagesRepositoryImpl): ImagesRepository {
        return imagesRepository
    }
}