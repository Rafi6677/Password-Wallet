package com.example.passwordwallet.data.repository.datasource

import com.example.passwordwallet.data.db.model.Password

interface PasswordDataSource {

    suspend fun deletePasswordFromDB(password: Password)
    suspend fun updatePasswordToDB(password: Password)
    suspend fun getAllStoredPasswordsFromDB(): List<Password>
    suspend fun insertPasswordIntoDB(password: Password)

}