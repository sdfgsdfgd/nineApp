package com.example.nine.di


import com.example.nine.domain.NewsRepository
import dagger.Module
import javax.inject.Singleton

@Module
abstract class DomainModule {
    @Singleton
    abstract fun bindNewsRepository(): NewsRepository
}
