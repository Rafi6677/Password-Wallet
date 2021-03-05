package com.example.passwordwallet.domain.usecase

import com.example.passwordwallet.data.db.model.Access
import com.example.passwordwallet.domain.repository.PasswordRepository

class SaveAccessUseCase(private val passwordRepository: PasswordRepository) {

    suspend fun execute(access: Access) = passwordRepository.saveAccess(access)

}