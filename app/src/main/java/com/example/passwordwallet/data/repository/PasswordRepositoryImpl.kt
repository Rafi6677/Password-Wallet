package com.example.passwordwallet.data.repository

import android.util.Log
import com.example.passwordwallet.data.db.model.Password
import com.example.passwordwallet.data.repository.datasource.PasswordDataSource
import com.example.passwordwallet.domain.repository.PasswordRepository
import java.lang.Exception

class PasswordRepositoryImpl(private val passwordDataSource: PasswordDataSource) : PasswordRepository {

    override suspend fun deletePassword(password: Password) {
        passwordDataSource.deletePasswordFromDB(password)
    }

    override suspend fun editPassword(password: Password) {
        passwordDataSource.updatePasswordToDB(password)
    }

    override suspend fun getAllStoredPasswords(): List<Password> {
        lateinit var passwordList: List<Password>

        try {
            passwordList = passwordDataSource.getAllStoredPasswordsFromDB()
        } catch (e: Exception) {
            Log.i("REPOSITORY_EXCEPTION", e.message.toString())
        }

        return passwordList
    }

    override suspend fun savePassword(password: Password) {
        passwordDataSource.insertPasswordIntoDB(password)
    }

}