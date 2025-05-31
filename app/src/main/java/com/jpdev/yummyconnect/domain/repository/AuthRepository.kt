package com.jpdev.yummyconnect.domain.repository

import com.jpdev.yummyconnect.domain.model.User

interface AuthRepository {
    suspend fun signIn(email: String, password: String): User?
    suspend fun signUp(email: String, password: String): User?
    suspend fun signOut()
    fun getCurrentUserId(): String?
}