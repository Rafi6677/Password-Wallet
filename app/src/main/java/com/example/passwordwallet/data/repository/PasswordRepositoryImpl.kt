package com.example.passwordwallet.data.repository

import android.util.Log
import com.example.passwordwallet.data.db.model.Password
import com.example.passwordwallet.data.repository.datasource.PasswordDataSource
import com.example.passwordwallet.domain.repository.PasswordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class PasswordRepositoryImpl(private val passwordDataSource: PasswordDataSource) : PasswordRepository {

    override suspend fun deletePassword(password: Password) {
        CoroutineScope(Dispatchers.IO).launch {
            passwordDataSource.deletePasswordFromDB(password)
        }
    }

    override suspend fun editPassword(password: Password) {
        CoroutineScope(Dispatchers.IO).launch {
            passwordDataSource.updatePasswordToDB(password)
        }
    }

    override suspend fun getAllStoredPasswords(userId: Int): List<Password> = passwordDataSource.getAllStoredPasswordsFromDB(userId)

    override suspend fun savePassword(password: Password) {
        CoroutineScope(Dispatchers.IO).launch {
            passwordDataSource.insertPasswordIntoDB(password)
        }
    }

}