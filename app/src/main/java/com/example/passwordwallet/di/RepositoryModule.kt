package com.example.passwordwallet.di

import com.example.passwordwallet.data.repository.UserRepositoryImpl
import com.example.passwordwallet.data.repository.PasswordRepositoryImpl
import com.example.passwordwallet.data.repository.datasource.UserDataSource
import com.example.passwordwallet.data.repository.datasource.PasswordDataSource
import com.example.passwordwallet.domain.repository.UserRepository
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
    fun provideUserRepository(userDataSource: UserDataSource): UserRepository {
        return UserRepositoryImpl(userDataSource)
    }

    @Singleton
    @Provides
    fun providePasswordRepository(passwordDataSource: PasswordDataSource): PasswordRepository {
        return PasswordRepositoryImpl(passwordDataSource)
    }

}