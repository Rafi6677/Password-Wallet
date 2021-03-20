package com.example.passwordwallet.domain.repository

import com.example.passwordwallet.data.db.model.User

interface UserRepository {

    suspend fun authenticateUser(login: String, passwordHash: String): User
    suspend fun editUser(user: User)
    suspend fun getUserById(id: Int): User
    suspend fun getUserByLogin(login: String): User
    suspend fun saveUser(user: User): Long

}