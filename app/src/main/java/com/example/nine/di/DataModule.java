package com.example.nine.di;

import com.example.nine.data.NewsService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class DataModule {


    private static final String BASE_URL = "https://bruce-v2-mob.fairfaxmedia.com.au/";

    @Singleton
    @Provides
    static Retrofit provideRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    static NewsService provideRetrofitService(Retrofit retrofit) {
        return retrofit.create(NewsService.class);
    }
}
