package com.example.passwordwallet.domain.usecase

import com.example.passwordwallet.domain.repository.AccessRepository

class GetMainAccessUseCase(private val accessRepository: AccessRepository) {

    suspend fun execute(mainAccessId: Int) = accessRepository.getMainAccess(mainAccessId)

}