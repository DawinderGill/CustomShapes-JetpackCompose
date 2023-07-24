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
        images.add(Images.Builder().url("https://images.pexels.com/photos/1346347/pexels-photo-1346347.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/1983037/pexels-photo-1983037.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/993626/pexels-photo-993626.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/6744887/pexels-photo-6744887.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/1346342/pexels-photo-1346342.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/771319/pexels-photo-771319.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/3728022/pexels-photo-3728022.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/9540183/pexels-photo-9540183.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/189367/pexels-photo-189367.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/439816/pexels-photo-439816.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/11807186/pexels-photo-11807186.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/9540184/pexels-photo-9540184.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/507710/pexels-photo-507710.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/17033989/pexels-photo-17033989/free-photo-of-young-model-in-a-green-blouse-and-pants-set-in-front-of-the-mirror.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/7397130/pexels-photo-7397130.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/5314574/pexels-photo-5314574.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/4289116/pexels-photo-4289116.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/4433935/pexels-photo-4433935.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/4426389/pexels-photo-4426389.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
        images.add(Images.Builder().url("https://images.pexels.com/photos/6089086/pexels-photo-6089086.jpeg?auto=compress&cs=tinysrgb&w=1200").build())
    }

    override fun getImagesList(): List<Images> {
        return images
    }
}