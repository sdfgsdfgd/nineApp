package com.example.nine.data.models

data class RelatedImageX(
    val assetType: String,
    val authors: List<Any>,
    val brands: List<Any>,
    val categories: List<Any>,
    val description: String,
    val height: Int,
    val id: Int,
    val lastModified: Long,
    val photographer: String,
    val sponsored: Boolean,
    val timeStamp: Long,
    val type: String,
    val url: String,
    val width: Int
)