package com.jpdev.yummyconnect.data.repository

import com.jpdev.yummyconnect.data.remote.auth.FirebaseAuthService
import com.jpdev.yummyconnect.domain.model.User
import com.jpdev.yummyconnect.domain.repository.AuthRepository
import javax.inject.Inject


class AuthRepositoryImpl @Inject constructor(
    private val authService: FirebaseAuthService
) : AuthRepository {

    override suspend fun signIn(
        email: String,
        password: String,
    ): User? {
        val firebaseUser = authService.signIn(email, password)
        return firebaseUser?.let {
            User(id = it.uid, name = it.displayName ?: "", email = it.email ?: "", recipes = emptyList())
        }
    }

    override suspend fun signUp(
        email: String,
        password: String,
    ): User? {
        val firebaseUser = authService.signUp(email, password)
        return firebaseUser?.let {
            User(id = it.uid, name = it.displayName ?: "", email = it.email ?: "", recipes = emptyList())
        }
    }

    override suspend fun signOut() {
        authService.signOut()
    }

    override fun getCurrentUserId(): String? {
        return authService.getCurrentUser()?.uid
    }
}