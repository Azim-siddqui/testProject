package com.example.istjetpackcomposeapp.di

import com.example.istjetpackcomposeapp.data.api.ApiService
import com.example.istjetpackcomposeapp.data.repository.PostRepositoryImpl
import com.example.istjetpackcomposeapp.data.repository.remote.RemoteDataSource
import com.example.istjetpackcomposeapp.data.repository.remote.RemoteDataSourceImpl
import com.example.istjetpackcomposeapp.domain.repository.PostRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesMoshi() : Moshi = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideApiService(moshi: Moshi) : ApiService = Retrofit
        .Builder()
        .baseUrl(ApiService.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build().create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesRemoteDataSource(apiService: ApiService) : RemoteDataSource = RemoteDataSourceImpl(apiService)

    @Provides
    @Singleton
    fun providesRepository(remoteDataSource: RemoteDataSource) : PostRepository = PostRepositoryImpl(remoteDataSource)
}