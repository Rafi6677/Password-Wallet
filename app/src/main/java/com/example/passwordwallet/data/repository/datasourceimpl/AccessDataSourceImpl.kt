package com.example.passwordwallet.data.repository.datasourceimpl

import com.example.passwordwallet.data.db.dao.AccessDAO
import com.example.passwordwallet.data.db.model.Access
import com.example.passwordwallet.data.repository.datasource.AccessDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AccessDataSourceImpl(private val dao: AccessDAO) : AccessDataSource {

    override suspend fun insertAccessIntoDB(access: Access) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insertAccess(access)
        }
    }

}