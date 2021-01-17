package com.example.nine.data.models

data class Author(
    val email: String,
    val name: String,
    val relatedAssets: List<Any>,
    val relatedImages: List<RelatedImage>,
    val title: String
)