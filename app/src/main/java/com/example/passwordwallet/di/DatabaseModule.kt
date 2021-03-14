package com.example.passwordwallet.di

import android.content.Context
import androidx.room.Room
import com.example.passwordwallet.data.db.PasswordWalletDataBase
import com.example.passwordwallet.data.db.dao.UserDAO
import com.example.passwordwallet.data.db.dao.PasswordDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): PasswordWalletDataBase {
        return Room.databaseBuilder(
            context,
            PasswordWalletDataBase::class.java,
            "password_wallet_database",
        ).build()
    }

    @Singleton
    @Provides
    fun provideUserDAO(passwordWalletDataBase: PasswordWalletDataBase): UserDAO {
        return passwordWalletDataBase.UserDAO()
    }

    @Singleton
    @Provides
    fun providePasswordDAO(passwordWalletDataBase: PasswordWalletDataBase): PasswordDAO {
        return passwordWalletDataBase.PasswordDAO()
    }

}