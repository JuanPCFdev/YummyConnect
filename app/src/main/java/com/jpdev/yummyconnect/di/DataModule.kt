package com.jpdev.yummyconnect.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.jpdev.yummyconnect.data.remote.source.AuthDataSource
import com.jpdev.yummyconnect.data.remote.source.FirestoreDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(
        auth: FirebaseAuth,
        firestoreDataSource: FirestoreDataSource,
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
    ): AuthDataSource = AuthDataSource(auth, firestoreDataSource, ioDispatcher)

    @Provides
    @Singleton
    fun provideFirestoreDataSource(
        firestore: FirebaseFirestore,
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
    ): FirestoreDataSource = FirestoreDataSource(firestore, ioDispatcher)

}