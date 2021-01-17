package com.example.nine.data.models

data class RelatedAsset(
    val assetType: String,
    val authors: List<AuthorX>,
    val categories: List<CategoryX>,
    val headline: String,
    val id: Int,
    val lastModified: Long,
    val onTime: Long,
    val sponsored: Boolean,
    val timeStamp: Long,
    val url: String
)