package com.example.passwordwallet.data.repository.datasourceimpl

import com.example.passwordwallet.data.db.dao.PasswordDAO
import com.example.passwordwallet.data.db.model.Password
import com.example.passwordwallet.data.repository.datasource.PasswordDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PasswordDataSourceImpl(private val dao: PasswordDAO) : PasswordDataSource {

    override suspend fun deletePasswordFromDB(password: Password) {
        dao.deletePassword(password)
    }

    override suspend fun updatePasswordToDB(password: Password) {
        dao.updatePassword(password)
    }

    override suspend fun getAllStoredPasswordsFromDB(userId: Int): List<Password> = dao.getAllStoredPasswords(userId)

    override suspend fun insertPasswordIntoDB(password: Password) {
        dao.insertPassword(password)
    }

}