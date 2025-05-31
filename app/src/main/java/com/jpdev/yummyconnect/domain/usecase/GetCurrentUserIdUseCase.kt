package com.jpdev.yummyconnect.domain.usecase

import com.jpdev.yummyconnect.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUserIdUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    operator fun invoke(): String? {
        return authRepository.getCurrentUserId()
    }
}