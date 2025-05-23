package com.jpdev.yummyconnect.domain.repository

import com.jpdev.yummyconnect.domain.model.User

interface UserRepository {
    suspend fun getUser(id: String): User
    suspend fun saveUser(user: User)
}