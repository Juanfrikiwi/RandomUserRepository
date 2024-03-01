package com.example.randomuser.di

import com.example.randomuser.data.network.api.GetUsersApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    @Named("getUsersProvider")
    fun provideGetUsers(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient.Builder = OkHttpClient.Builder()
        client.connectTimeout(15, TimeUnit.SECONDS)
        client.readTimeout(15, TimeUnit.SECONDS)
        client.writeTimeout(15, TimeUnit.SECONDS)
        client.addInterceptor(logging)

        return Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client.build())
            .build()
    }

    @Singleton
    @Provides
    fun provideLoginApiClient(@Named("getUsersProvider") retrofit: Retrofit): GetUsersApiClient {
        return retrofit.create(GetUsersApiClient::class.java)
    }
}
