package com.example.passwordwallet.data.repository.datasourceimpl

import com.example.passwordwallet.data.db.dao.UserDAO
import com.example.passwordwallet.data.db.model.User
import com.example.passwordwallet.data.repository.datasource.UserDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserDataSourceImpl(private val dao: UserDAO) : UserDataSource {

    override suspend fun authenticateUserFromDB(login: String, passwordHash: String): User = dao.authenticateUser(login, passwordHash)

    override suspend fun updateUserToDB(user: User) {
        dao.updateUser(user)
    }

    override suspend fun getUserByIdFromDB(id: Int): User = dao.getUserById(id)

    override suspend fun getUserByLoginFromDB(login: String): User = dao.getUserByLogin(login)

    override suspend fun insertUserIntoDB(user: User) {
        dao.insertUser(user)
    }

}