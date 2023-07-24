package com.dawinder.customshapes_jc.repositories

import com.dawinder.customshapes_jc.models.Images
import javax.inject.Inject

class ImagesRepositoryImpl @Inject constructor() : ImagesRepository {

    private val images = mutableListOf<Images>()

    init {
        // Initialize songs here or load from a data source
        createImages()
    }

    private fun createImages() {
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
        images.add(Images.Builder().url("").build())
    }

    override fun getImagesList(): List<Images> {
        return images
    }
}