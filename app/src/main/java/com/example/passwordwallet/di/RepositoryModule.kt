package com.example.passwordwallet.di

import com.example.passwordwallet.data.repository.AccessRepositoryImpl
import com.example.passwordwallet.data.repository.PasswordRepositoryImpl
import com.example.passwordwallet.data.repository.datasource.AccessDataSource
import com.example.passwordwallet.data.repository.datasource.PasswordDataSource
import com.example.passwordwallet.domain.repository.AccessRepository
import com.example.passwordwallet.domain.repository.PasswordRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideAccessRepository(accessDataSource: AccessDataSource): AccessRepository {
        return AccessRepositoryImpl(accessDataSource)
    }

    @Singleton
    @Provides
    fun providePasswordRepository(passwordDataSource: PasswordDataSource): PasswordRepository {
        return PasswordRepositoryImpl(passwordDataSource)
    }

}