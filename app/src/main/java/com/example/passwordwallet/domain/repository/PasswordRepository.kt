package com.example.passwordwallet.domain.repository

import com.example.passwordwallet.data.db.model.Access
import com.example.passwordwallet.data.db.model.Password

interface PasswordRepository {

    suspend fun deletePassword(password: Password)
    suspend fun editPassword(password: Password)
    suspend fun getAllStoredPasswords(): List<Password>
    suspend fun saveAccess(access: Access)
    suspend fun savePassword(password: Password)

}