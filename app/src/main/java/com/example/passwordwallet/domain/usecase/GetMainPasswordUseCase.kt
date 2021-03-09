package com.example.passwordwallet.domain.usecase

import com.example.passwordwallet.domain.repository.PasswordRepository

class GetMainPasswordUseCase(private val passwordRepository: PasswordRepository) {

    suspend fun execute() = passwordRepository.getMainPassword()

}