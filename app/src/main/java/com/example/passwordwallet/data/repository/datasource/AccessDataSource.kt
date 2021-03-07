package com.example.passwordwallet.data.repository.datasource

import com.example.passwordwallet.data.db.model.Access

interface AccessDataSource {

    suspend fun insertAccessIntoDB(access: Access)

}