package com.example.passwordwallet.data.repository

import com.example.passwordwallet.data.db.model.Access
import com.example.passwordwallet.data.repository.datasource.AccessDataSource
import com.example.passwordwallet.domain.repository.AccessRepository

class AccessRepositoryImpl(private val accessDataSource: AccessDataSource) : AccessRepository {

    override suspend fun getMainAccess(mainAccessId: Int): Access = accessDataSource.getMainAccessFromDB(mainAccessId)

    override suspend fun saveAccess(access: Access) {
        accessDataSource.insertAccessIntoDB(access)
    }

}