package com.mark.petfinderexpert.di

import com.mark.petfinderexpert.data.remote.datasource.RemoteDataSource
import com.mark.petfinderexpert.data.remote.datasource.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Singleton
    @Binds
    abstract fun bindRemoteDataSource(
        movieImageDataSource: RemoteDataSourceImpl,
    ): RemoteDataSource
}