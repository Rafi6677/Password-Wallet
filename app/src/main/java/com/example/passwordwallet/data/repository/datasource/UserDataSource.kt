package com.example.passwordwallet.data.repository.datasource

import com.example.passwordwallet.data.db.model.User

interface UserDataSource {

    suspend fun authenticateUserFromDB(login: String, passwordHash: String): User
    suspend fun updateUserToDB(user: User)
    suspend fun getUserByIdFromDB(id: Int): User
    suspend fun getUserByLoginFromDB(login: String): User
    suspend fun insertUserIntoDB(user: User)

}