package com.jpdev.yummyconnect.domain.usecase.user

import com.jpdev.yummyconnect.domain.repository.UserRepository
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(userId: String) = userRepository.getUserById(userId)
}