package com.example.passwordwallet.di

import com.example.passwordwallet.domain.repository.AccessRepository
import com.example.passwordwallet.domain.repository.PasswordRepository
import com.example.passwordwallet.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideSaveAccessUseCase(
        accessRepository: AccessRepository
    ): SaveAccessUseCase {
        return SaveAccessUseCase(accessRepository)
    }

    @Singleton
    @Provides
    fun provideDeletePasswordUseCase(
        passwordRepository: PasswordRepository
    ): DeletePasswordUseCase {
        return DeletePasswordUseCase(passwordRepository)
    }

    @Singleton
    @Provides
    fun provideEditPasswordUseCase(
        passwordRepository: PasswordRepository
    ): EditPasswordUseCase {
        return EditPasswordUseCase(passwordRepository)
    }

    @Singleton
    @Provides
    fun provideGetAllStoresPasswordsUseCase(
        passwordRepository: PasswordRepository
    ): GetAllStoredPasswordsUseCase {
        return GetAllStoredPasswordsUseCase(passwordRepository)
    }

    @Singleton
    @Provides
    fun provideSavePasswordUseCase(
        passwordRepository: PasswordRepository
    ): SavePasswordUseCase {
        return SavePasswordUseCase(passwordRepository)
    }

}