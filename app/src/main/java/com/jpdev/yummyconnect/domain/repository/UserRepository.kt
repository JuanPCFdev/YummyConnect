package com.jpdev.yummyconnect.domain.repository

import com.jpdev.yummyconnect.domain.model.User

interface UserRepository {
    //Create -- Update
    suspend fun createOrUpdateUser(user: User)
    //Read
    suspend fun getUserById(id: String): User?
    //Delete TODO
    suspend fun deleteUser(id: String)
}