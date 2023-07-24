package com.dawinder.customshapes_jc.repositories

import com.dawinder.customshapes_jc.models.Images

interface ImagesRepository {

    fun getImagesList(): List<Images>
}