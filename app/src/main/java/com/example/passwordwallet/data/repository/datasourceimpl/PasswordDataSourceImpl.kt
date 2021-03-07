package com.example.passwordwallet.data.repository.datasourceimpl

import com.example.passwordwallet.data.db.dao.PasswordDAO
import com.example.passwordwallet.data.db.model.Password
import com.example.passwordwallet.data.repository.datasource.PasswordDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PasswordDataSourceImpl(private val dao: PasswordDAO) : PasswordDataSource {

    override suspend fun deletePasswordFromDB(password: Password) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deletePassword(password)
        }
    }

    override suspend fun updatePasswordToDB(password: Password) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.updatePassword(password)
        }
    }

    override suspend fun getAllStoredPasswordsFromDB(): List<Password> = dao.getAllStoredPasswords()

    override suspend fun insertPasswordIntoDB(password: Password) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertPassword(password)
        }
    }

}