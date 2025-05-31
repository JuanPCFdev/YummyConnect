package com.jpdev.yummyconnect.domain.usecase

import com.jpdev.yummyconnect.domain.model.User
import com.jpdev.yummyconnect.domain.repository.AuthRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(email: String, password: String): User? {
        return authRepository.signIn(email, password)
    }
}