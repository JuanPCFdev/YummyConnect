package com.jpdev.yummyconnect.domain.usecase.user

import com.jpdev.yummyconnect.domain.repository.UserRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(id: String) = userRepository.deleteUser(id)
}