package com.example.passwordwallet.di

import com.example.passwordwallet.data.db.dao.UserDAO
import com.example.passwordwallet.data.db.dao.PasswordDAO
import com.example.passwordwallet.data.repository.datasource.UserDataSource
import com.example.passwordwallet.data.repository.datasource.PasswordDataSource
import com.example.passwordwallet.data.repository.datasourceimpl.UserDataSourceImpl
import com.example.passwordwallet.data.repository.datasourceimpl.PasswordDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideUserDataSource(dao: UserDAO): UserDataSource {
        return UserDataSourceImpl(dao)
    }

    @Singleton
    @Provides
    fun providePasswordDataSource(dao: PasswordDAO): PasswordDataSource {
        return PasswordDataSourceImpl(dao)
    }

}