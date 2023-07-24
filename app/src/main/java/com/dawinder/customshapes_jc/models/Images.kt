package com.dawinder.customshapes_jc.models

/**
 * A data class representing an image with its URL.
 *
 * @property url The URL of the image.
 */
class Images(val url: String) {

    /**
     * Builder class to construct an [Images] instance.
     */
    class Builder {

        private lateinit var url: String

        fun url(url: String) = apply { this.url = url }

        fun build(): Images {
            return Images(url)
        }
    }
}