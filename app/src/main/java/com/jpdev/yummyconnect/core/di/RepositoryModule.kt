package com.jpdev.yummyconnect.core.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.jpdev.yummyconnect.data.local.dao.UserDao
import com.jpdev.yummyconnect.data.repository.UserRepositoryImpl
import com.jpdev.yummyconnect.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// Inyección de repositorios

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule{

    @Provides
    @Singleton
    fun provideUserRepository(
        userDao: UserDao,
        firebaseAuth: FirebaseAuth,
        firestore: FirebaseFirestore
    ): UserRepository {
        return UserRepositoryImpl(userDao, firebaseAuth, firestore)
    }

    // Agrega aquí otros repositorios
}