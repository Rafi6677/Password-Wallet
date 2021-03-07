package com.example.passwordwallet.domain.repository

import com.example.passwordwallet.data.db.model.Access

interface AccessRepository {

    suspend fun saveAccess(access: Access)

}