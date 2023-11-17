package com.mark.petfinderexpert.di


import com.mark.petfinderexpert.data.remote.repos.AuthRepositoryImpl
import com.mark.petfinderexpert.data.remote.repos.PetRepositoryImpl
import com.mark.petfinderexpert.domain.repos.AuthRepo
import com.mark.petfinderexpert.domain.repos.PetsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl,
    ): AuthRepo
    @Singleton
    @Binds
    abstract fun bindPetsRepository(
        petsRepositoryImpl: PetRepositoryImpl,
    ): PetsRepo
}