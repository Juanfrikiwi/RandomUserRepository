package com.example.randomuser.di

import com.example.randomuser.utils.LocalCache
import com.example.randomuser.utils.LocalCacheImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalCacheModule {

    @Singleton
    @Provides
    fun provideDataCache(): MutableMap<String, Any> = ConcurrentHashMap<String, Any>()

    @Singleton
    @Provides
    fun provideLocalCache(localCache: LocalCacheImpl): LocalCache = localCache


}