package com.dawinder.customshapes_jc.models

class Images(val url: String) {
    class Builder {

        private lateinit var url: String

        fun url(url: String) = apply { this.url = url }

        fun build(): Images {
            return Images(url)
        }
    }
}