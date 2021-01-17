package com.example.nine.data.models

data class AuthorX(
    val email: String,
    val name: String,
    val relatedAssets: List<Any>,
    val relatedImages: List<RelatedImageX>,
    val title: String
)