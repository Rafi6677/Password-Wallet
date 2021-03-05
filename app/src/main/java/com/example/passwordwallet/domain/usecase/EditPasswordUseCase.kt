package com.example.passwordwallet.domain.usecase

import com.example.passwordwallet.data.db.model.Password
import com.example.passwordwallet.domain.repository.PasswordRepository

class EditPasswordUseCase(private val passwordRepository: PasswordRepository) {

    suspend fun execute(password: Password) = passwordRepository.editPassword(password)

}