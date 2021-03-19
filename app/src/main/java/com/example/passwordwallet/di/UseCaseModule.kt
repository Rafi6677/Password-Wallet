package com.example.passwordwallet.di

import com.example.passwordwallet.domain.repository.UserRepository
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
    fun provideAuthenticateUserUseCase(
        userRepository: UserRepository
    ): AuthenticateUserUseCase {
        return AuthenticateUserUseCase(userRepository)
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
    fun provideEditUserUseCase(
        userRepository: UserRepository
    ): EditUserUseCase {
        return EditUserUseCase(userRepository)
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
    fun provideGetUserByIdUseCase(
        userRepository: UserRepository
    ): GetUserByIdUseCase {
        return GetUserByIdUseCase(userRepository)
    }

    @Singleton
    @Provides
    fun provideGetUserByLoginUseCase(
        userRepository: UserRepository
    ): GetUserByLoginUseCase {
        return GetUserByLoginUseCase(userRepository)
    }

    @Singleton
    @Provides
    fun provideSavePasswordUseCase(
        passwordRepository: PasswordRepository
    ): SavePasswordUseCase {
        return SavePasswordUseCase(passwordRepository)
    }

    @Singleton
    @Provides
    fun provideSaveUserUseCase(
        userRepository: UserRepository
    ): SaveUserUseCase {
        return SaveUserUseCase(userRepository)
    }

}