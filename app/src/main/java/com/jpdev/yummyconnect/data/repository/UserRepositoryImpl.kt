package com.jpdev.yummyconnect.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.jpdev.yummyconnect.data.local.dao.UserDao
import com.jpdev.yummyconnect.data.local.mapper.toDomain
import com.jpdev.yummyconnect.data.local.mapper.toEntity
import com.jpdev.yummyconnect.domain.model.User
import com.jpdev.yummyconnect.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val authService: FirebaseAuth,
    private val firestore: FirebaseFirestore
): UserRepository {
    override suspend fun getUser(id: String): User =
        userDao.getUserById(id)?.toDomain() ?: run {
            val firebaseUser = authService.getCurrentUser()!!
            val domain = User(firebaseUser.uid, firebaseUser.displayName ?: "", firebaseUser.email ?: "")
            userDao.insertUser(domain.toEntity())
            domain
        }

    override suspend fun saveUser(user: User) {
        userDao.insertUser(user.toEntity())
        // opcional: guardar en Firestore si tienes colección de usuarios
    }
}