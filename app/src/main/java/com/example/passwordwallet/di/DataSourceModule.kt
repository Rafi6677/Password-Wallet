package com.example.passwordwallet.di

import com.example.passwordwallet.data.db.dao.AccessDAO
import com.example.passwordwallet.data.db.dao.PasswordDAO
import com.example.passwordwallet.data.repository.datasource.AccessDataSource
import com.example.passwordwallet.data.repository.datasource.PasswordDataSource
import com.example.passwordwallet.data.repository.datasourceimpl.AccessDataSourceImpl
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
    fun provideAccessDataSource(dao: AccessDAO): AccessDataSource {
        return AccessDataSourceImpl(dao)
    }

    @Singleton
    @Provides
    fun providePasswordDataSource(dao: PasswordDAO): PasswordDataSource {
        return PasswordDataSourceImpl(dao)
    }

}