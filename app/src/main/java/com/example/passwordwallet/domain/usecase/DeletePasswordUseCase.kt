package com.example.passwordwallet.domain.usecase

import com.example.passwordwallet.data.db.model.Password
import com.example.passwordwallet.domain.repository.PasswordRepository

class DeletePasswordUseCase(private val passwordRepository: PasswordRepository) {

    suspend fun execute(password: Password) = passwordRepository.deletePassword(password)

}