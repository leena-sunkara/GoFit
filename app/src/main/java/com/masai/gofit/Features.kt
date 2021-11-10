package com.masai.gofit

class Features {
    private var image: String? = null
    private var title: String? = null
    private var description: String? = null

    fun setImage(image: String?) {
        this.image = image
    }

    fun getImage(): String? {
        return image
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getTitle(): String? {
        return title
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getDescription(): String? {
        return description
    }
}