package com.example.passwordwallet.domain.repository

import com.example.passwordwallet.data.db.model.Password

interface PasswordRepository {

    suspend fun deletePassword(password: Password)
    suspend fun editPassword(password: Password)
    suspend fun getAllStoredPasswords(userId: Int): List<Password>
    suspend fun savePassword(password: Password)

}