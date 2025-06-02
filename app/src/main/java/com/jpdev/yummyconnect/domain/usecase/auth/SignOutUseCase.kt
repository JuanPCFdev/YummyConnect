package com.jpdev.yummyconnect.domain.usecase.auth

import com.jpdev.yummyconnect.domain.repository.AuthRepository
import javax.inject.Inject

class SignOutUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke() {
        authRepository.signOut()
    }
}