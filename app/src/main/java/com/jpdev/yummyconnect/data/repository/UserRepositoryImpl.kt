package com.jpdev.yummyconnect.data.repository

import com.jpdev.yummyconnect.data.dto.UserDto
import com.jpdev.yummyconnect.data.dto.toDomain
import com.jpdev.yummyconnect.data.dto.toDto
import com.jpdev.yummyconnect.data.remote.firestore.FirestoreService
import com.jpdev.yummyconnect.domain.model.User
import com.jpdev.yummyconnect.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val firestoreService: FirestoreService,
): UserRepository {
    override suspend fun createOrUpdateUser(user: User) {
        val dto = user.toDto()
        firestoreService.createOrUpdateUser(dto)
    }

    override suspend fun getUserById(id: String): User? {
        val dto: UserDto? = firestoreService.getUserById(id)
        return dto?.toDomain()
    }
}