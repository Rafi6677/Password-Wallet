package com.example.passwordwallet.domain.usecase

import com.example.passwordwallet.domain.repository.UserRepository

class GetUserByLoginUseCase(private val userRepository: UserRepository) {

    suspend fun execute(login: String) = userRepository.getUserByLogin(login)

}