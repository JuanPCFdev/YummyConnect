package com.jpdev.yummyconnect.domain.usecase.user

import com.jpdev.yummyconnect.domain.model.User
import com.jpdev.yummyconnect.domain.repository.UserRepository
import javax.inject.Inject

class CreateOrUpdateUserUseCase @Inject constructor(
    private val userRepository: UserRepository,
) {
    suspend operator fun invoke(user: User) = userRepository.createOrUpdateUser(user)
}