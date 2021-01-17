package com.example.nine.data.models

data class News(
    val assetType: String,
    val assets: List<Asset>,
    val authors: List<Any>,
    val categories: List<Any>,
    val displayName: String,
    val id: Int,
    val lastModified: Long,
    val onTime: Long,
    val relatedAssets: List<Any>,
    val relatedImages: List<Any>,
    val sponsored: Boolean,
    val timeStamp: Long,
    val url: String
)