package com.example.passwordwallet.domain.usecase

import com.example.passwordwallet.data.db.model.Access
import com.example.passwordwallet.domain.repository.AccessRepository
import com.example.passwordwallet.domain.repository.PasswordRepository

class SaveAccessUseCase(private val accessRepository: AccessRepository) {

    suspend fun execute(access: Access) = accessRepository.saveAccess(access)

}