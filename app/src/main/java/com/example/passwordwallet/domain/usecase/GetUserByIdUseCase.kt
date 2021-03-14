package com.example.passwordwallet.domain.usecase

import com.example.passwordwallet.data.db.model.User
import com.example.passwordwallet.domain.repository.UserRepository

class GetUserByIdUseCase(private val userRepository: UserRepository) {

    suspend fun execute(id: Int) = userRepository.getUserById(id)

}