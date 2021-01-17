package com.example.nine.domain

import com.example.nine.data.NewsService
import com.example.nine.data.models.News
import io.reactivex.Single
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsService: NewsService) {
    fun getNews(): Single<News?>? = newsService.serviceGetNews()
}
