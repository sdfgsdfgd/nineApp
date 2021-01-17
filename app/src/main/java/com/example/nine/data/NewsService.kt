package com.example.nine.data

import com.example.nine.data.models.News
import io.reactivex.Single
import retrofit2.http.GET


interface NewsService {
    @GET("1/coding_test/13ZZQX/full")
    fun serviceGetNews(): Single<News?>?
}