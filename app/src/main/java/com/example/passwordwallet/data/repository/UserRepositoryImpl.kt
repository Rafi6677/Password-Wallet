package com.example.passwordwallet.data.repository

import com.example.passwordwallet.data.db.model.User
import com.example.passwordwallet.data.repository.datasource.UserDataSource
import com.example.passwordwallet.domain.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {

    override suspend fun authenticateUser(login: String, passwordHash: String): User = userDataSource.authenticateUserFromDB(login, passwordHash)

    override suspend fun editUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDataSource.updateUserToDB(user)
        }
    }

    override suspend fun getUserById(id: Int): User = userDataSource.getUserByIdFromDB(id)

    override suspend fun getUserByLogin(login: String): User = userDataSource.getUserByLoginFromDB(login)

    override suspend fun saveUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            userDataSource.insertUserIntoDB(user)
        }
    }

}