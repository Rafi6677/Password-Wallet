package com.example.passwordwallet.domain.usecase

import com.example.passwordwallet.domain.repository.UserRepository

class AuthenticateUserUseCase(private val userRepository: UserRepository) {

    suspend fun execute(login: String, password: String) = userRepository.authenticateUser(login, password)

}