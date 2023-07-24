package com.dawinder.customshapes_jc.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.dawinder.customshapes_jc.models.Images
import com.dawinder.customshapes_jc.repositories.ImagesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(imagesRepository: ImagesRepository) : ViewModel() {

    private val _images = mutableStateListOf<Images>()
    val images: List<Images> get() = _images

    init {
        _images.addAll(imagesRepository.getImagesList())
    }
}